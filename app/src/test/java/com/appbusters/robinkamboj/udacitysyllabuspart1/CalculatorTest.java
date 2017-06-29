package com.appbusters.robinkamboj.udacitysyllabuspart1;

import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.MyCalculatorModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void checkAddition() throws Exception {
        assertEquals(4, MyCalculatorModel.add(2, 2));
    }

    @Test
    public void checkSubtraction() throws Exception {
        assertEquals(4, MyCalculatorModel.subtract(6, 2));
    }

    @Test
    public void checkSubtractionAgain() throws Exception {
        int expected = 4;
        int actual = MyCalculatorModel.subtract(6, 2);
        assertEquals("Subtraction Failed", actual, expected);
    }

    @Test
    public void checkDivision() throws Exception {
        assertEquals("INFINITY", MyCalculatorModel.divide(4, 0));
        assertEquals("NOT DEFINED", MyCalculatorModel.divide(0, 0));
        assertEquals(2, Integer.parseInt(MyCalculatorModel.divide(4, 2)));
    }
}
