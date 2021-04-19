package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import static org.junit.Assert.*;

public class AscendingComparatorTest {

    @Test
    public void compareAscendingComparator() {
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setId(3);
        item1.setId(1);
        item2.setId(9);
        List<Item> listItem = new ArrayList<>();
        listItem.add(item);
        listItem.add(item1);
        listItem.add(item2);
        Comparator<Item> comparator = new AscendingComparator();
        List<Item> expect = new ArrayList<>();
        expect.add(item1);
        expect.add(item);
        expect.add(item2);
        Collections.sort(listItem, comparator);
        assertThat(expect, is(listItem));
    }

}