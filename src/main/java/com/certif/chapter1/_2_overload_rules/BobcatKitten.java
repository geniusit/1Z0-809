package com.certif.chapter1._2_overload_rules;

public class BobcatKitten extends Bobcat {

    public void findDen(GrandParent value) {

        System.out.println("BobcatKitten GrandPArent");
    }

    public void findDen(Parent value) {

        System.out.println("BobcatKitten Parent");
    }

    public void findDen(Integer a){
        System.out.println("boxed int : " + a.intValue()    );
    }

   public void findDen(int a, Integer b){
        System.out.println("int : " + a);
    }

    public void findDen(Integer a, int b){
        System.out.println("int : " + a);
    }

    public void findDen(int ... a){
        System.out.println("variable int : " + a);
    }

    /*public void findDen(long bL){
        System.out.println("long : " + bL);
    }*/

    /*public void findDen(Number number){
        System.out.println("number : " + number);
    }*/
}
