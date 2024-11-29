package com.ws.handler;

import com.alibaba.fastjson.JSON;
import com.ws.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {
    public static final List<WebSocketSession> sessions  = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 连接完成，触发。
        log.info("afterConnectionEstablished {}", DateUtils.CurrentTime());
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 关闭连接完成，触发。
        log.info("afterConnectionClosed {}", DateUtils.CurrentTime());
        sessions.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("handleMessage {}", DateUtils.CurrentTime());
        super.handleMessage(session, message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handleTextMessage: {} {}", message.getPayload() , DateUtils.CurrentTime());
        // 群发消息
        for (WebSocketSession webSocketSession : sessions) {
            try {
                webSocketSession.sendMessage(message);
            } catch (IOException e) {
                log.error("Error: {}", e.getMessage());
            }
        }
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        log.info("handlePongMessage {}",DateUtils.CurrentTime());
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("handleTransportError {}",DateUtils.CurrentTime());
        super.handleTransportError(session, exception);
    }

    @Override
    public boolean supportsPartialMessages() {
        log.info("supportsPartialMessages {}",DateUtils.CurrentTime());
        return super.supportsPartialMessages();
    }
}
