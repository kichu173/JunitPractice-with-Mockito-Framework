package org.example;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) // 1st step
public class StringHelperParameterizedTest {

	// AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA

	StringHelper helper = new StringHelper();
	
	private String input;// 3rd step
	private String expectedOutput;
	
	public StringHelperParameterizedTest(String input, String expectedOutput) { //4th step
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters //2nd step
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = { 
				{ "AACD", "CD" }, // {input, output}
				{ "ACD", "CD" }
		};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(expectedOutput, 
				helper.truncateAInFirst2Positions(input));
	}
}