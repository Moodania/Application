package com.mood.Moodania.Presentation.WebSockets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    private static final Logger log = LoggerFactory.getLogger(MyWebSocketHandler.class);

    private final ObjectMapper mapper;

    private HashMap<UUID, WebSocketSession> sessions = new HashMap<UUID, WebSocketSession>();

    public MyWebSocketHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     *
     * @param session
     * @throws Exception
     *
     *  Puts a pair of <userID, userSession>
     *  if userId exists we replace its session to a new one
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        //TODO()
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //TODO()
    }

    public void sendMessageToUser(String messageText, UUID destinationUserID){
        WebSocketSession destSession = sessions.get(destinationUserID);
        try {
            destSession.sendMessage(new TextMessage(messageText));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
