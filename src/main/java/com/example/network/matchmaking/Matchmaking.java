package com.example.network.matchmaking;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Queue;
import com.example.network.player.Player;

public class Matchmaking {
  private Queue<Player> sesson;

  public Matchmaking(Queue<Player> playersList) {
    this.sesson = playersList;
  }

  public void balanceSession() {
    sesson.forEach(player -> {
      try {
        System.out.print(player.getPlayer().getOutputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  public static void ping(Socket client, long startTime) {
    try {
      OutputStream outputStream = client.getOutputStream();
      PrintWriter writer = new PrintWriter(outputStream, true);

      long endTime = System.currentTimeMillis();
      long pingMs = endTime - startTime;

      writer.println(pingMs + "ms");
      writer.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
