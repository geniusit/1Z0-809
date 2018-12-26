package com.certif.chapter1._1_access_modifiers.cat.species;

import com.certif.chapter1._1_access_modifiers.cat.BigCat;

public class Lynx extends BigCat {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //DO NOT COMPILE
        //System.out.println(cat.hasFur); //code being accessed by variable rather than by inheritance
        //System.out.println(cat.hasPaws); //default and in an other package
        //System.out.println(cat.id); //private

        BigCat catLynx = new Lynx();
        //Do not compile
        //System.out.println(catLynx.hasFur); //code being accessed by variable rather than by inheritance

        Lynx lynx = new Lynx(); //Lynx is a subclass => can access to protected members
        System.out.println(lynx.hasFur); //access by inheritance

        //System.out.println(hasFur); //hasFur is a no static variable

    }

    public void test(){
        System.out.println(hasFur);
    }
}
