package com.learning.spring_mongo_db.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring boot", "Learn core java", "learn python", "learn aws");
    }
}
