package org.example.mockito;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Junit", "Learn Spring", "Learn Mockito");
    }

    public void deleteTodo(String todo) {

    }
}
