import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _6_th_Lecture_UnitTesting {
    @Test
    public void testAdd_givenTwoPositiveIntegers_returnCorrectSum() throws Exception {
        // Arrange
        int i = 9;
        int j = 5;

        // Act
        int result = Calculator.add(i,j);

        // Assert
        assertEquals(14, result);
    }

    @Test
    public void testAdd_givenTwoNegativeIntegers_returnsCorrectSum() throws Exception {
        // Arrange
        int i = -9;
        int j = -5;

        // Act
        int result = Calculator.add(i,j);

        // Assert
        assertEquals(-14, result);
    }

    @Test(expected = Exception.class)
    public void testAdd_givenTwoIntMaxes_returns() throws Exception {
        // Arrange
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        System.out.println(i);

        // Act
        Calculator.add(i,j);
    }
}

class Calculator {
    public static int add(int i, int j) throws Exception {
        if(i == Integer.MAX_VALUE && j == Integer.MAX_VALUE)
            throw new Exception("Not supported");
        return i + j;
    }
}
