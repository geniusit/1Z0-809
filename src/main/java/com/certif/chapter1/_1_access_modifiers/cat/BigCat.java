package com.certif.chapter1._1_access_modifiers.cat;

public class BigCat {
    public String name = "cat";
    protected boolean hasFur = true;
    boolean hasPaws = true;
    private int id;

    protected static int age = 1;

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        System.out.println(cat.hasFur);
        System.out.println(cat.hasPaws);
        System.out.println(cat.id);
    }
}

