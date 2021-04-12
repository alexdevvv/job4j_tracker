package ru.job4j.collection;

import org.junit.Test;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void whenAreTwoSameNumbers() {
        List<Task> list = new ArrayList<>(Arrays.asList(
                new Task("1", "One"),
                new Task("2", "Two"),
                new Task("3", "Three"),
                new Task("1", "Four")
        ));
        HashSet<String> rsl = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(rsl, is(FullSearch.extractNumber(list)));
    }

    @Test
    public void whenAreFourSameNumbers() {
        List<Task> list = new ArrayList<>();
        list.add(new Task("1", "One"));
        list.add(new Task("2", "Two"));
        list.add(new Task("1", "Three"));
        list.add(new Task("2", "Four"));
        list.add(new Task("3", "Five"));
        list.add(new Task("3", "Six"));
        HashSet<String> expect = new HashSet<>();
        expect.add("1");
        expect.add("2");
        expect.add("3");
        assertThat(expect, is(FullSearch.extractNumber(list)));
    }
}