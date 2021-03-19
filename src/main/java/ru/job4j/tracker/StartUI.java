package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
//            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    Item item = items[i];
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("Please enter the application id that you want to change: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Please enter the name of the application: ");
                String itemName = scanner.nextLine();
                Item newItem = new Item(itemName);
                if(tracker.replace(id, newItem)) {
                    tracker.replace(id, newItem);
                    System.out.println("Replacement completed successfully");
                } else {
                    System.out.println("Replacement completed error!");
                }

            } else if(select == 3) {
                System.out.println("Enter the Id to delete the request");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    tracker.delete(id);
                    System.out.println("The application was successfully deleted.");
                } else {
                    System.out.println("Request deletion error");
                }
            } else if (select == 4){
                System.out.println("Enter the ID to search for the application");
                int id = Integer.valueOf(scanner.nextLine());
                Item newItem = tracker.findById(id);
                if (newItem != null) {
                    System.out.println(newItem.getName());
                }else {
                    System.out.println("The application with this id was not found!");
                }
            } else if (select == 5) {
                System.out.println("Enter the name to search for the application");
                String nameItem = scanner.nextLine();
                Item[] arrayItems = tracker.findByName(nameItem);
                if (arrayItems.length > 0) {
                    for (int i = 0; i < arrayItems.length; i++) {
                        Item item = arrayItems[i];
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Applications with this name were not found");
                }
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
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
