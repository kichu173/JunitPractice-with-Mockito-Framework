package org.example.mockito.section_5;

import org.example.mockito.TodoBusinessImpl;
import org.example.mockito.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ArgumentCapture {
    @Test
    public void letsTestDeleteNow_usingBDD_argumentCapture() {

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");


        // Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        // then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture()); // if arguments are captured multiple times, when specific method is called

        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

        // if arguments are captured multiple times, when specific method is called
        //assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
