package com.yong.demo;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 * pending implement
 */

@Slf4j
@Component
public class TodoExceptionHandler {}/*implements WebExceptionHandler {


    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        log.error("handle exception test");
        return ServerResponse.badRequest().body(Mono.just(Throwables.getRootCause(throwable).getMessage()), String.class);
    }
}
*/