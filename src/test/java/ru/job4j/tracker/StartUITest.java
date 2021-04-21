package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FIndAllItems(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "=== Find all Items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdItem(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find by ID Item" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "=== Find by ID Item ====" + System.lineSeparator()
                        + "The application with this id was not found!" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find by ID Item" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item", "1"}
        );
        Tracker tracker = new Tracker();
        String name = "New Item";
        Item item = tracker.add(new Item("Item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameItem(out));
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find by Name Item" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "=== Find by Name Item ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find by Name Item" + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit." + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit." + ln
                )
        );
    }

}
