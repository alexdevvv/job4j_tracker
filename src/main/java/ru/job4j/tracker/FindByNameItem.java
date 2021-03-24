package ru.job4j.tracker;

public class FindByNameItem implements UserAction {
    private final Output out;

    public FindByNameItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by Name Item ====");
        String nameItem = input.askStr("Enter the name to search for the application");
        Item[] arrayItems = tracker.findByName(nameItem);
        if (arrayItems.length > 0) {
            for (int i = 0; i < arrayItems.length; i++) {
              out.println(arrayItems[i]);
            }
        } else {
            out.println("Applications with this name were not found");
        }
        return true;
    }
}
