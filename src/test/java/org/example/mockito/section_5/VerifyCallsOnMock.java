package org.example.mockito.section_5;

import org.example.mockito.TodoBusinessImpl;
import org.example.mockito.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class VerifyCallsOnMock {
    // let's see how to check if a method is called or not
    // And also how many times a method is called

    @Test
    public void letsMockListGet_BDD() {
        // given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willReturn("in28Minutes");

        // when
        String element = list.get(0);

        //assert
        assertThat(element, is("in28Minutes"));
    }

    @Test
    public void letsTestDeleteNow() {

        // given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");


        // Then
        verify(todoServiceMock).deleteTodo("Learn to Dance");// Is deleteTodo called with "Learn To Dance" as argument
//        then(todoServiceMock).should().deleteTodo("Learn to Dance"); // alternate to above syntax(BDD)

        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
//        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");
        //        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");

        verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }
}
