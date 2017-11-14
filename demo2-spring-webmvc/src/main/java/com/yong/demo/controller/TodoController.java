package com.yong.demo.controller;

import com.yong.demo.model.Todo;
import com.yong.demo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository repository;

    @GetMapping("/{id}")
    public Todo findOneTodo(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @GetMapping
    public List<Todo> findAllTodo() {
            return repository.findAll();
    }

    @PostMapping
    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    @PutMapping
    public Todo updateTodo(Todo todo) {
        Todo old = repository.findById(todo.getId()).get();
        Assert.notNull(old, "record not found,updated failure!");
        old.setActivity(todo.isActivity());
        old.setItem(todo.getItem());
        old.setLocked(todo.isLocked());
        old.setTitle(todo.getTitle());
        return repository.save(old);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "helloWorld";
    }
}
