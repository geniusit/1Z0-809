package com.certif.chapter1._4_instanceof;

public class Test {

    public static void main(String ... args){

        System.out.println(null instanceof Object);

        HeavyAnimal hippo = new Hippo();
        System.out.println(hippo instanceof Hippo);
        System.out.println(hippo instanceof HeavyAnimal);
        System.out.println(hippo instanceof Elephant);
        System.out.println(hippo instanceof Mother);

        HeavyAnimal motherHippo = new MotherHippo();

        System.out.println(motherHippo instanceof Mother);

        Hippo anotherHippo = new Hippo();
        //COMPILATION ERROR
        //System.out.println(anotherHippo instanceof Elephant); //Inconvertible types

    }
}

interface Mother {}

class HeavyAnimal {}

class Hippo extends HeavyAnimal {}

class Elephant extends HeavyAnimal {}

class MotherHippo extends Hippo implements Mother{}