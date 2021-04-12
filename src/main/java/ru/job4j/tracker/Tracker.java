package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public  class Tracker {
    private final List<Item> listItems = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        listItems.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(listItems);
    }

    public List<Item> findByName(String key) {
        List<Item> newNameItem = new ArrayList<>();
        for (Item item : listItems) {
            if (key.equals(item.getName())) {
                newNameItem.add(item);
            }
        }
        return newNameItem;
    }

    private int indexOff(int id) {
        int rsl = -1;
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return  rsl;
    }

    public Item findById(int id) {
        int index = indexOff(id);
        return index != -1 ? listItems.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOff(id);
        boolean rsl = index != -1;
        if (rsl) {
            listItems.set(index, item);
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int indexId = indexOff(id);
        boolean rsl = indexId != -1;
        if (rsl) {
            listItems.remove(indexId);
        }
        return rsl;
    }
}

