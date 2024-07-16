package practice.servergateway.auth;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import practice.utils.JwtTool;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class LoginFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String pathString = request.getPath().toString();

        // login
        if (pathString.equals("/users/login") || pathString.equals("/users/logout")) {
            return chain.filter(exchange);
        }
        // register
        String method = Objects.requireNonNull(request.getMethod()).toString();
        if (pathString.equals("/users") || method.equals("POST")) {
            return chain.filter(exchange);
        }

        String authorization = request.getHeaders().getFirst("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            // check signature
            String token = authorization.substring("Bearer ".length());
            String payload = JwtTool.getPayload(token);
            if (payload != null) {
                return chain.filter(exchange);
            }
        }

        // not logged in
        ServerHttpResponse response = exchange.getResponse();
        response.setRawStatusCode(401);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
