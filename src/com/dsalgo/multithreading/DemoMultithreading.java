package com.dsalgo.multithreading;

class Bike extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.println("Bike");
    }
}

class Car extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.println("Car");
    }
}

public class DemoMultithreading {

    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();

        bike.start();
        car.start();
    }
}
