package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> list = Arrays.asList(
                new Account("112233","Alex", "30000"),
                new Account("556633","Ivan", "55000"),
                new Account("112233","Alex", "30000")
        );
        Set<Account> expect = new HashSet<>(Arrays.asList(
                new Account("112233","Alex", "30000"),
                new Account("556633","Ivan", "55000")
             )
        );
        assertThat(NotifyAccount.sent(list), is(expect));
    }
}