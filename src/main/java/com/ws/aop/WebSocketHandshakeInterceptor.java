package com.ws.aop;


import com.ws.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * WS全局拦截器，负责在请求处理之前拦截，请求之后拦截。
 */
@Configuration
@Slf4j
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        List<String> authorization = request.getHeaders().get("authorization");
        if (Objects.nonNull(authorization)){
            // 参数填充
            attributes.put("authorization",authorization.get(0));
        }
        // if return false，program will return else go on。
        log.info("beforeHandshake {}", DateUtils.CurrentTime());
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // 在握手之后处理，处理成功响应页面。
        log.info("afterHandshake {}", DateUtils.CurrentTime());
    }
}
