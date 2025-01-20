package test.rtc.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Slf4j
public class LoggingHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(final ServerHttpRequest request,
        final ServerHttpResponse response,
        final WebSocketHandler wsHandler, final Map<String, Object> attributes) throws Exception {
        log.info("WebSocket connection request: URI={}, Headers={}",
            request.getURI(), request.getHeaders());
        return true; // true를 반환해야 핸드셰이크가 진행됩니다.
    }

    @Override
    public void afterHandshake(final ServerHttpRequest request, final ServerHttpResponse response,
        final WebSocketHandler wsHandler, final Exception exception) {
        log.info("WebSocket connection established: URI={}", request.getURI());
    }
}

