package com.example.network.player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Player {
  private Socket player;
  public Player(ServerSocket server) {
    try {
      this.player = server.accept();
    } catch(IOException e) {
      System.out.println(e);
    }
  }

  public Socket getPlayer() {
    return this.player;
  }
}
