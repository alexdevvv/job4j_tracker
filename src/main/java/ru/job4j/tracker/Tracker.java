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
        return  Arrays.copyOf(items, size);
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            rsl = true;
        } return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int indexID = indexOf(id);
        if(indexID != -1) {
            items[indexID] = null;
            System.arraycopy(items, indexID + 1, items, indexID, size - indexID);
            items[size - 1] = null;
            size--;
            rsl = true;
        } return rsl;

    }
}

