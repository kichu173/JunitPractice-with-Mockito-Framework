package org.example.mockito.section_5;

import org.example.mockito.TodoBusinessImpl;
import org.example.mockito.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class TodoBusinessImplMockitoTest {

	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given (setup)
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		//when (make actual method invocations)
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");

		//then (assertions)
		assertThat(todos.size(), is(2));
	}

}