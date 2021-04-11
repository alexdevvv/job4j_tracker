package ru.job4j.tracker;

import java.util.List;

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
        String nameItem = input.askStr("Enter the name to search for the application: ");
        List<Item> arrayItems = tracker.findByName(nameItem);
        if (arrayItems.size() > 0) {
            for (int i = 0; i < arrayItems.size(); i++) {
              out.println(arrayItems.get(i));
            }
        } else {
            out.println("Applications with this name were not found");
        }
        return true;
    }
}
