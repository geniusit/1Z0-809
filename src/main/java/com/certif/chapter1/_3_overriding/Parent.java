package com.certif.chapter1._3_overriding;

public class Parent {
    String message = "parent";
}

class Child extends Parent {
    String message = "child";
}

class Test {

    public static void main(String ... args){

        Parent p = new Child();
        //OVERRIDING IS ONLY APPLICABLE TO METHODS BUT NOT VARIABLES
        System.out.println(p.message); //displays parent
    }
}
