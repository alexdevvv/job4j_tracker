package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete an Item ====");
        int id = input.askInt("Enter the Id to delete the request");
        if (tracker.delete(id)) {
            out.println("The application was successfully deleted.");
        } else {
            out.println("Request deletion error");
        }
        return true;
    }
}
