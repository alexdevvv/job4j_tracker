package ru.job4j.lambda;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.function.*;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x ->  (x * x));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }

}