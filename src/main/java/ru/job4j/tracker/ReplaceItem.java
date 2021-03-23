package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "Replace Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace Items ====");
        int id = input.askInt("Please enter the application id that you want to change: ");
        String itemName = input.askStr("Please enter the name of the application: ");
        Item newItem = new Item(itemName);
        if(tracker.replace(id, newItem)) {
            System.out.println("Replacement completed successfully");
        } else {
            System.out.println("Replacement completed error!");
        }
        return true;
    }
}
