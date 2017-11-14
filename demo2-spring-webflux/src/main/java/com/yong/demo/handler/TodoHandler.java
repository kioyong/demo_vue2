package com.yong.demo.handler;

import com.yong.demo.model.Todo;
import com.yong.demo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@AllArgsConstructor
@Component
public class TodoHandler {

    private final TodoRepository repository;

    public Mono<ServerResponse> findOneTodo(ServerRequest request) {
        return ServerResponse.ok().body(repository.findById(request.pathVariable("id")), Todo.class);
    }

    public Mono<ServerResponse> findAllTodo(ServerRequest request) {
        Flux<Todo> todoFlux = repository.findAll();
        return ServerResponse.ok().body(todoFlux, Todo.class);
    }

    public Mono<ServerResponse> addTodo(ServerRequest request) {
        Mono<Todo> todo = request.bodyToMono(Todo.class);
        return ServerResponse.ok().body(repository.save(todo.block()),Todo.class);
    }

    public Mono<ServerResponse> updateTodo(ServerRequest request) {
        Mono<Todo> todo = request.bodyToMono(Todo.class);
        Mono<Todo> result = todo.flatMap(t -> {
            Todo old = repository.findById(t.getId()).block();
            Assert.notNull(old, "record not found,updated failure!");
            old.setActivity(t.isActivity());
            old.setItem(t.getItem());
            old.setLocked(t.isLocked());
            old.setTitle(t.getTitle());
            return repository.save(old);
        });
        return ServerResponse.ok().body(result,Todo.class);
    }

     public Mono<ServerResponse> helloWorld(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("helloWorld"), String.class);
    }


}
