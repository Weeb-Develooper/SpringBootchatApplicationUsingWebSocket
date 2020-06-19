package com.project.chatapplication.controller;

import javax.websocket.OnOpen;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{username}")
public class ChatController {
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    private static HashMap<String, String> users = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {
//        Open connection
//        1) add session
        onlineSessions.put(session.getId(),session);

//        2) add user.
        users.put(session.getId(),username);
    }
}
