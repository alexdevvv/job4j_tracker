package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] newItems = new Item[size];
        return newItems = Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] newNameItem = new Item[size];
        int num = 0;
        for (int i = 0; i < newNameItem.length; i++) {
            Item item = items[i];
            if(key.equals(item.getName())) {
                newNameItem[num++] = items[i];
            }
        }
        return newNameItem;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}