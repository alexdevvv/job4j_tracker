package ru.job4j.tracker;

public class FIndAllItems implements UserAction {
    private final Output out;

    public FIndAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all Items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            out.println(items[i]);
        }
        return true;
    }
}
