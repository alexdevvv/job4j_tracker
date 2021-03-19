package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("I am Bus. I drive");
    }

    @Override
    public void passengers(int man) {
        System.out.println("I can transport " + man + "passengers");
    }

    @Override
    public double fillUp(double fuel) {
        return fuel * 44.7d;
    }
}
