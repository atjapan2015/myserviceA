package com.microservice.myserviceA.discover;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.health.ServiceHealth;

@Component
public class ServiceDiscovery {

    @Autowired
    private Consul consul;

    public List<Server> getServerList(String serviceName) {
        List<Server> upServerList = new ArrayList<>();
        List<ServiceHealth> availableServers = consul.healthClient().getHealthyServiceInstances(serviceName)
                .getResponse();
        availableServers.forEach(x -> upServerList.add(new Server(x.getNode().getAddress(), x.getService().getPort())));
        return upServerList;

    }

}
