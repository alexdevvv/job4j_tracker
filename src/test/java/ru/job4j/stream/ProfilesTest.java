package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("Moskow", "Arbat", 34, 45)));
        list.add(new Profile(new Address("Ivanovo", "Lenina", 4, 9)));
        List<Address> expect = new ArrayList<>();
        expect.add(new Address("Ivanovo", "Lenina", 4, 9));
        expect.add(new Address("Moskow", "Arbat", 34, 45));
        Profiles profiles = new Profiles();
        List<Address> rls = profiles.collect(list);
        assertThat(expect, is(rls));
    }

    @Test
    public void sortedAndDistinct() {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("Moskow", "Arbat", 34, 45)));
        list.add(new Profile(new Address("Ivanovo", "Lenina", 4, 9)));
        list.add(new Profile(new Address("Moskow", "Arbat", 34, 45)));
        list.add(new Profile(new Address("Omsk", "Stalina", 6, 1)));
        List<Address> expect = Arrays.asList(
                new Address("Ivanovo", "Lenina", 4, 9),
                new Address("Moskow", "Arbat", 34, 45),
                new Address("Omsk", "Stalina", 6, 1));
        Profiles profiles = new Profiles();
        List<Address> rls = profiles.collect(list);
        assertThat(expect, is(rls));
    }
}