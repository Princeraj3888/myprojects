package com.learning.spring_mongo_db.impl;

import com.learning.spring_mongo_db.api.TodoService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TodoServiceImpl {

    private final TodoService todoService;

    public TodoServiceImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosForSpring(String user){
        log.info("in retrieve todos method: {}", user);
        List<String> todos = todoService.retrieveTodos(user);
        return todos.stream().filter(t -> t.contains("Spring")).toList();
    }
}
