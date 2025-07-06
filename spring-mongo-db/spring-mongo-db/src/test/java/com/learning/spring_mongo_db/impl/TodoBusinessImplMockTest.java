package com.learning.spring_mongo_db.impl;

import com.learning.spring_mongo_db.api.TodoService;
import com.learning.spring_mongo_db.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplMockTest {

    @Test
    public void test(){
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn core java", "learn python", "learn aws");

        Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoServiceImpl impl = new TodoServiceImpl(todoServiceMock);
        List<String> filteredTodosList = impl.retrieveTodosForSpring("Dummy");

        assertEquals(2, filteredTodosList.size());
    }
}
