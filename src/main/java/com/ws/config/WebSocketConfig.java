package com.ws.config;

import com.ws.aop.WebSocketHandshakeInterceptor;
import com.ws.handler.WebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Resource
    private WebSocketHandler webSocketHandler;
    @Resource
    private WebSocketHandshakeInterceptor webSocketHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler,"ws")
                .addInterceptors(webSocketHandshakeInterceptor)
                .setAllowedOrigins("*");
    }
}
