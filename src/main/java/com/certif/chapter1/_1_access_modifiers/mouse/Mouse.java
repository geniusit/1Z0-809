package com.certif.chapter1._1_access_modifiers.mouse;

import com.certif.chapter1._1_access_modifiers.cat.BigCat;

public class Mouse {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //public
        //DO NOT COMPILE
        //System.out.println(cat.hasFur);
        //System.out.println(cat.hasPaws);
        //System.out.println(cat.id);
    }
}