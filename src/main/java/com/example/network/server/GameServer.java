package com.example.network.server;

import com.example.network.matchmaking.Matchmaking;
import com.example.network.player.Player;
import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
  private static final int PORT = 5000;
  private static Queue<Player> waitingPlayers = new LinkedList<>();

  public static void start() {
    try(ServerSocket serverSocket = new ServerSocket(PORT)) {
      while (true) {
        long startTime = System.currentTimeMillis();
        Player newPlayer = new Player(serverSocket);

        synchronized (waitingPlayers) {
          waitingPlayers.add(newPlayer);
        }

        new Thread(() -> Matchmaking.ping(
          (Socket) newPlayer.getPlayer(), 
          (long) startTime)
        ).start();
      }
    } catch(IOException e) {
      System.out.println(e);
    }
  }
}