package ru.job4j.ex;

public class FindEl {
    public static void main(String[] args) {
        String[] str = {"A"};
        try {
            indexOf(str, "B");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        } if (rsl == -1) {
            throw new ElementNotFoundException("Element not found in this array");
        }
        return rsl;
    }
}
