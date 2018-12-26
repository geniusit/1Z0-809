package com.certif.chapter1._1_access_modifiers.cat;

import com.certif.chapter1._1_access_modifiers.cat.species.Lynx;

public class Sow extends BigCat{

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //public
        //DO NOT COMPILE
        System.out.println(cat.hasFur); //code being accessed by variable rather than by inheritance BUT it's in the same package
        System.out.println(cat.hasPaws); //default and same package
        //System.out.println(cat.id); //private

        Lynx lynx = new Lynx(); //Lynx is a subclass => can access to protected members
        System.out.println(lynx.hasFur); //access by inheritance
    }
}
