package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookCleanCode = new Book("Clean code", 464);
        Book book2 = new Book("book2", 569);
        Book book3 = new Book("book3", 1251);
        Book book4 = new Book("book4", 986);
        Book[] books = new Book[4];
        books[0] = bookCleanCode;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Name book "  + bk.getName() + "|" +  "Number the pages " + bk.getNumberPages());
        }
        books[0] = book4;
        books[3] = bookCleanCode;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Name book "  + bk.getName() + "|" +  "Number the pages " + bk.getNumberPages());
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("CleanCode")) {
                System.out.println("Name book "  + bk.getName() + "|" +  "Number the pages " + bk.getNumberPages());
            }
        }

    }
}
