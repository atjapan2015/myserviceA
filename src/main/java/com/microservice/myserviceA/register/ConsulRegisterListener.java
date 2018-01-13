package com.microservice.myserviceA.register;

import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.orbitz.consul.Consul;

public class ConsulRegisterListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Consul consul = event.getApplicationContext().getBean(Consul.class);
        ConsulProperties consulProperties = event.getApplicationContext().getBean(ConsulProperties.class);
        try {
            consul.agentClient().register(consulProperties.getServicePort(),
                    URI.create(consulProperties.getHealthUrl()).toURL(), consulProperties.getHealthInterval(),
                    consulProperties.getServiceName(), consulProperties.getServiceName(),
                    consulProperties.getServiceTag());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
