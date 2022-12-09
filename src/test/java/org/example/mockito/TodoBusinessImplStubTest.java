package org.example.mockito;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {
    @Test
    public void usingAStub() {
        TodoServiceStub todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(1, filteredTodos.size());
    }
}
