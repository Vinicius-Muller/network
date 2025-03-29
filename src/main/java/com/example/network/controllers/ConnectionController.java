package com.example.network.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.network.connections.Connection;
import com.example.network.server.GameServer;

@RestController
@RequestMapping("/api/connection")
public class ConnectionController {
  @GetMapping("/start")
  public void start() {   
    GameServer.start(); 
  }

  @GetMapping("/ping") 
  public String ping() {
    return Connection.ping();
  }
}
