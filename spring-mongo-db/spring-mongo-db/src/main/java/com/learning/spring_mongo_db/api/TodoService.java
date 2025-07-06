package com.learning.spring_mongo_db.api;

import java.util.List;

public interface TodoService {
    public List<String> retrieveTodos(String user);
}
