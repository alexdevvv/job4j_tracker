package ru.job4j.tracker;

import javax.sound.midi.Track;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItem (Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = input.askInt("Please enter the application id that you want to change: ");
        String itemName = input.askStr("Please enter the name of the application: ");
        Item newItem = new Item(itemName);
        if(tracker.replace(id, newItem)) {
            System.out.println("Replacement completed successfully");
        } else {
            System.out.println("Replacement completed error!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter the Id to delete the request");
        if (tracker.delete(id)) {
            System.out.println("The application was successfully deleted.");
        } else {
            System.out.println("Request deletion error");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter the ID to search for the application");
        Item newItem = tracker.findById(id);
        if (newItem != null) {
            System.out.println(newItem);
        }else {
            System.out.println("The application with this id was not found!");
        }
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        String nameItem = input.askStr("Enter the name to search for the application");
        Item[] arrayItems = tracker.findByName(nameItem);
        if (arrayItems.length > 0) {
            for (int i = 0; i < arrayItems.length; i++) {
                System.out.println(arrayItems[i]);
            }
        } else {
            System.out.println("Applications with this name were not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select:");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if(select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4){
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
