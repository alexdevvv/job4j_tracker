package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "new Item";
        Item item = tracker.add(new Item(name));
        Input in = new StubInput(
                new String[] {"1"}
        );
        UserAction[] actions = {
                new FIndAllItems(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(name));
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "new Item";
        Item item = tracker.add(new Item(name));
        Input in = new StubInput(
                new String[] {"1"}
        );
        UserAction[] actions = {
                new FindByIdItem(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker, is(name));
    }

}
