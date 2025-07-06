package com.learning.spring_mongo_db.impl;

import com.learning.spring_mongo_db.api.TodoService;
import com.learning.spring_mongo_db.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {

    @Test
    public void test(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoServiceImpl impl = new TodoServiceImpl(todoServiceStub);

        List<String> filteredTodosList = impl.retrieveTodosForSpring("Dummy");
        assertEquals(1, filteredTodosList.size());
    }
}
