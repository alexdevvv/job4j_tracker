package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {

    @Test
    public void whenHigher1Priority() {
        PriorityQueue priority = new PriorityQueue();
        priority.put(new Task("low", 5));
        priority.put(new Task("urgent", 3));
        priority.put(new Task("middle", 1));
        Task result = priority.take();
        assertThat(result.getDesc(), is("middle"));

    }

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}