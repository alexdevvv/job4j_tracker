package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {

    @Test
    public void when2array() {
        ConvertList list = new ConvertList();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[] {1});
        arrays.add(new int[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(arrays), is(expect));
    }


}