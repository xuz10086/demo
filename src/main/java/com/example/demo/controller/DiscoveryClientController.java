package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscoveryClientController {

    // 服务发现客户端
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/testDiscoveryClient")
    public String testDiscoveryClient() {
        return "testDiscoveryClient";
    }
}
