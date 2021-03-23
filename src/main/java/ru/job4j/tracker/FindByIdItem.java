package ru.job4j.tracker;

public class FindByIdItem implements UserAction {
    @Override
    public String name() {
        return "Find by ID Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find by ID Item ====");
        int id = input.askInt("Enter the ID to search for the application");
        Item newItem = tracker.findById(id);
        if (newItem != null) {
            System.out.println(newItem);
        }else {
            System.out.println("The application with this id was not found!");
        }
        return true;
    }
}
