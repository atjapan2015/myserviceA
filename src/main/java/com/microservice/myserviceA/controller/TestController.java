package com.microservice.myserviceA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.myserviceA.discover.Server;
import com.microservice.myserviceA.discover.ServiceDiscovery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("Test api")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ServiceDiscovery serviceDiscovery;

    @ApiOperation("Get service list via serviceName")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "serviceName", dataType = "string", required = true, value = "service name") })
    @RequestMapping(value = "/getServiceList", method = RequestMethod.GET)
    public List<Server> getServiceList(@RequestParam("serviceName") String serviceName) {
        return serviceDiscovery.getServerList(serviceName);
    }

}
