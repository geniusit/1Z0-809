package com.certif.chapter1._2_overload_rules;

public class Bobcat {

    public void findDen(String value) {
        System.out.println(value);
    }



    public void findDen(String value, int otherValue) {
        System.out.println(value + " " + otherValue);
    }

    public void findDen(String value, Integer otherValue) {
        System.out.println(value + " " + otherValue);
    }

    public void findDen(int otherValue, String value) {
        System.out.println(value + " " + otherValue);
    }




}
