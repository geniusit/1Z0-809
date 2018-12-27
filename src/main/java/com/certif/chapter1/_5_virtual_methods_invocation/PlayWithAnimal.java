package com.certif.chapter1._5_virtual_methods_invocation;

abstract class Animal {

    String name = "???";

    public void printName() {
        System.out.println(name);
    }

    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }

    public abstract void feed();
}

class Cow extends Animal {

    public void feed() { addHay(); }
    private void addHay() { }
}

class Bird extends Animal {
    public void feed() { addSeed(); }
    private void addSeed() { }
}

class Lion extends Animal {
    String name = "Leo";
    public void feed() { addMeat(); }
    private void addMeat() { }

    public void play() {
        System.out.println("toss in meat");
    }
}

public class PlayWithAnimal {
    public static void main(String... args) {
        Animal animal = new Lion();
        animal.printName(); //print ??? because overriding is only for methods
        animal.careFor();
    }
}