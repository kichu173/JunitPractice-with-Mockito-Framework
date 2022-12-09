package org.example.mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
//    What is mocking?
//    mocking is creating objects that simulate the behavior of real objects.
//    Unlike stubs, mocks can be dynamically created from code - at runtime.
//    Mocks offer more functionality than stubbing.
//    You can verify method calls and a lot of other things.
    @Test
    public void usingAStub() {
        TodoService mockTodoService = mock(TodoService.class);
        when(mockTodoService.retrieveTodos("some_dummy")).thenReturn(Arrays.asList("Learn Spring", "Learn Junit"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("some_dummy");
        assertEquals(1, filteredTodos.size());
    }
}
