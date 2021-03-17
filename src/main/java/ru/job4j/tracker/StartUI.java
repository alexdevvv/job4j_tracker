package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("ABCD");
        item2.setName("1234");
        tracker.add(item1);
        tracker.add(item2);

        System.out.println(tracker.findById(1).getName());
        System.out.println(tracker.findById(2).getName());

    }
}
