package org.example;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    //(expected, actual)  actual value is something comes out as an output from business logic we wrote as method
    // test methods should be always public void
    StringHelper helper = new StringHelper();

    @Test
    void truncateAInFirst2PositionsTest() {
        String actualResult = helper.truncateAInFirst2Positions("AACD");
        String expectedResult = "CD";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void truncateAInFirst2PositionsTwoCharactersLength() {
        String actualResult = helper.truncateAInFirst2Positions("AA");
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void areFirstAndLastTwoCharactersTheSameTest() {
        boolean actualResult = helper.areFirstAndLastTwoCharactersTheSame("Kichu");
        assertFalse(actualResult);
    }

    @Test
    void areFirstAndLastTwoCharactersTheSameTest_lengthLessThan1() {
        boolean actualResult = helper.areFirstAndLastTwoCharactersTheSame("K");
        assertFalse(actualResult);
    }

    @Test
    void areFirstAndLastTwoCharactersTheSameTest_lengthEqual2() {
        boolean actualResult = helper.areFirstAndLastTwoCharactersTheSame("Ki");
        assertTrue(actualResult);
    }
}