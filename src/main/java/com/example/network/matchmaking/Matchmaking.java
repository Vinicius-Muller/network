package com.example.network.matchmaking;

import java.io.IOException;
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
}
