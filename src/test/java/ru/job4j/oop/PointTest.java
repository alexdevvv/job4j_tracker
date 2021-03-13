package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when00And02then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertThat(rsl, is(2.0));
    }

    @Test
    public void when00And010then10() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        double rsl = a.distance(b);
        assertThat(rsl, is(10.0));
    }

    @Test
    public void when000And004then4() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 4);
        double rsl = a.distance3d(b);
        assertThat(rsl, is(4.0));
    }
}