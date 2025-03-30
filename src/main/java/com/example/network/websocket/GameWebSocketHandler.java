package com.example.network.websocket;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.network.game.GameClass;
import com.example.network.player.PlayerClass;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameWebSocketHandler extends TextWebSocketHandler {
  private static final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
  private static Queue<PlayerClass> playerQueue = new ConcurrentLinkedQueue<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
    sessions.add(session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String playerMessage = message.getPayload();

    if (playerMessage.equals("READY")) {
      PlayerClass player = new PlayerClass((String) session.getId());
      playerQueue.add(player);
    }

    for (WebSocketSession s : sessions) {
      s.sendMessage(new TextMessage(playerMessage));
    }

    if (playerQueue.size() > 1 && playerQueue.size() == sessions.size()) {
      System.out.print("Game is about to start !");
      GameClass.start(playerQueue);
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    sessions.remove(session);
  }
}
