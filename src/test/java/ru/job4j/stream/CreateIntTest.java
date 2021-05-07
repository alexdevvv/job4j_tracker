package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CreateIntTest {

    @Test
    public void createArrayToList() {
        Integer[][] matrix = new Integer[][]{
                {100, 200},
                {300, 400}
        };
        List<Integer> expect = List.of(100, 200, 300, 400);
        CreateInt createInt = new CreateInt();
        List<Integer> rsl = createInt.createArrayToList(matrix);
        assertThat(expect, is(rsl));
    }
}