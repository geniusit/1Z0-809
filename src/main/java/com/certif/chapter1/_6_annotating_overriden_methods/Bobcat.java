package com.certif.chapter1._6_annotating_overriden_methods;

public class Bobcat {

    public void findDen(){}
}

class BobcatMother extends Bobcat {

    @Override
    public void findDen(){

    }

    //throw a compiler error
    //@Override
    public void findDen(boolean b){

    }
}
