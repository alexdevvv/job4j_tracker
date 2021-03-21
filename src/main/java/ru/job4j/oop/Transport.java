package ru.job4j.oop;

public class Transport {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle bus1 = new Bus();
        Vehicle plane = new Plane();
        Vehicle plane1 = new Plane();
        Vehicle train = new Train();
        Vehicle train1 = new Train();

        Vehicle[] arrayVehicle = {bus, bus1, plane, plane1, train, train1};
        for (int i = 0; i < arrayVehicle.length; i++) {
            Vehicle vehicle = arrayVehicle[i];
            vehicle.move();
        }
    }
}
