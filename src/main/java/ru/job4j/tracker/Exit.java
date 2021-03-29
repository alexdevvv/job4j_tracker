package ru.job4j.tracker;

public class Exit implements UserAction {
    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit.";
    }

    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
