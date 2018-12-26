package com.certif.chapter1._2_overload_rules;

public class Test {

    public static void main(String ... args){

        BobcatKitten kitten = new BobcatKitten();

        kitten.findDen(new Child());

        kitten.findDen((short) 1);

        kitten.findDen(new Integer(1) , 1);



    }
}
