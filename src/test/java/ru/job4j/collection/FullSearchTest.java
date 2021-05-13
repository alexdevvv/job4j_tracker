package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void whenAreTwoSameNumbers() {
        List<Task> list = List.of(
                new Task("1", "One"),
                new Task("2", "Two"),
                new Task("3", "Three"),
                new Task("1", "Four")
        );
        HashSet<String> rsl = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(rsl, is(FullSearch.extractNumber(list)));
    }

    @Test
    public void whenAreFourSameNumbers() {
        List<Task> list = List.of(
                new Task("1", "One"),
        new Task("2", "Two"),
        new Task("1", "Three"),
        new Task("2", "Four"),
        new Task("3", "Five"),
        new Task("3", "Six")
        );
        Set<String> expect = Set.of("1", "2", "3");
        assertThat(expect, is(FullSearch.extractNumber(list)));
    }
}