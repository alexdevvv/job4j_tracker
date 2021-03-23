package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete an Item ====");
        int id = input.askInt("Enter the Id to delete the request");
        if (tracker.delete(id)) {
            System.out.println("The application was successfully deleted.");
        } else {
            System.out.println("Request deletion error");
        }
        return true;
    }
}
