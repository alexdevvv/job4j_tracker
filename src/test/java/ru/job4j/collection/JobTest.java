package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorNameAscending() {
        Job job1 = new Job("BBB", 111);
        Job job2 = new Job("CCC", 222);
        Job job3 = new Job("AAA", 222);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        List<Job> expect = new ArrayList<>();
        expect.add(job3);
        expect.add(job1);
        expect.add(job2);
        Collections.sort(list, new NameAscendingComparator());
        assertThat(expect, is(list));
    }

    @Test
    public void whenComparatorNameDescending() {
        Job job1 = new Job("BBB", 111);
        Job job2 = new Job("CCC", 222);
        Job job3 = new Job("AAA", 222);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        List<Job> expect = new ArrayList<>();
        expect.add(job2);
        expect.add(job1);
        expect.add(job3);
        Collections.sort(list, new NameDescendingComparator());
        assertThat(expect, is(list));
    }

    @Test
    public void whenComparatorPriorityAscending() {
        Job job1 = new Job("BBB", 222);
        Job job2 = new Job("CCC", 444);
        Job job3 = new Job("AAA", 333);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        List<Job> expect = new ArrayList<>();
        expect.add(job1);
        expect.add(job3);
        expect.add(job2);
        Collections.sort(list, new PriorityAscendingComparator());
        assertThat(expect, is(list));
    }

    @Test
    public void whenComparatorPriorityDescending() {
        Job job1 = new Job("BBB", 222);
        Job job2 = new Job("CCC", 444);
        Job job3 = new Job("AAA", 333);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        List<Job> expect = new ArrayList<>();
        expect.add(job2);
        expect.add(job3);
        expect.add(job1);
        Collections.sort(list, new PriorityDescendingComparator());
        assertThat(expect, is(list));
    }

    @Test
    public void whenNameByPriority() {
        Comparator<Job> cmpNamePriority = new NameAscendingComparator().thenComparing(new PriorityAscendingComparator());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 10)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriorityByName() {
        Comparator<Job> cmpPriorityName = new PriorityAscendingComparator().thenComparing(new NameAscendingComparator());
        int rsl = cmpPriorityName.compare(
                new Job("AAA", 0),
                new Job("BBB", 10)
        );
        assertThat(rsl, lessThan(10));
    }

    @Test
    public void whenDescendingNameByPriority() {
        Comparator<Job> cmpDesNameByPriority = new NameDescendingComparator().thenComparing(new PriorityAscendingComparator());
        int rsl = cmpDesNameByPriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 10)
        );
        assertThat(rsl, lessThan(10));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new NameDescendingComparator().thenComparing(new PriorityAscendingComparator());
        int rsl = cmpNamePriority.compare(
                new Job("Alex", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, lessThan(0));
    }


}