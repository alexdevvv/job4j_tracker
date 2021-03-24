package ru.job4j.tracker;

public class FindByIdItem implements UserAction {
    private final Output out;

    public FindByIdItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by ID Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by ID Item ====");
        int id = input.askInt("Enter the ID to search for the application");
        Item newItem = tracker.findById(id);
        if (newItem != null) {
            out.println(newItem);
        }else {
            out.println("The application with this id was not found!");
        }
        return true;
    }
}
