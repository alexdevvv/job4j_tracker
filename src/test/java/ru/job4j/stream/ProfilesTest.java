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
        List<Address> expect = Arrays.asList(
                new Address("Moskow", "Arbat", 34, 45),
                new Address("Ivanovo", "Lenina", 4, 9));
        Profiles profiles = new Profiles();
        List<Address> rls = profiles.collect(list);
        assertThat(expect.get(1).getApartment(), is(rls.get(1).getApartment()));
    }
}