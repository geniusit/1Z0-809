package com.certif.chapter1._2_overload_rules;

/**
 * Java overloaded method call is resolved using 3 steps,
 *                 STEP 1: Compiler will try to resolve call without boxing and unboxing and variable
 *         argument.
 *
 *                 STEP 2: Compiler will try to resolve call by using boxing and unboxing.
 *
 *         STEP 3: Compiler will try to resolve call by using boxing/unboxing and variable argument.
 */
public class OverloadedMethodSpecific {

    public void test(String str) {
        System.out.println("String");
    }

    public void test(Object obj) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        OverloadedMethodSpecific obj = new OverloadedMethodSpecific();
        //If more than one method is both accessible and applicable to a method invocation then
        //Java compiler uses the set of rules that the most specific method is chosen for invocation. (String in this case)
        obj.test(null);
    }
}

class OverloadedMethodAmbiguous {

    public void test(String str) {
        System.out.println("String");
    }

    public void test(StringBuffer obj) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        OverloadedMethodAmbiguous obj = new OverloadedMethodAmbiguous();
        //StringBuffer and String class are both at same level in Object hierarchy,
        // So in this case Compiler will not able to resolve which method to invoke and it gives Compile time error.
        //obj.test(null);
    }
}

class OverloadedMethodOrder{
    public void test(String obj1, Object obj2) {
        System.out.println("B");
    }

    public void test(Object obj1, String obj2) {
        System.out.println("C");
    }

    public static void main(String[] args) {
        OverloadedMethodOrder obj = new OverloadedMethodOrder();
        //Compile time error because method contains parameter in opposite order and none of
        //the test method in this case is more specific and can be resolved.
        //obj.test(null, null);
    }
}

class OverloadedMethodArray{
    public void test(int[] intArr) {
        System.out.println("int array");
    }

    public void test(char[] charArr) {
        System.out.println("char array");
    }

    public static void main(String[] args) {
        OverloadedMethodArray obj = new OverloadedMethodArray();
        //Ambiguous call because int[] and char[]are at the same level
        //bj.test(null);

        System.out.println(int[].class.isPrimitive()); //false
        System.out.println(int[].class.getName()); //[I
        System.out.println(int[].class.getSuperclass()); //java.lang.Object

        System.out.println(int.class.isPrimitive()); //true
        System.out.println(int.class.getName()); //int
        System.out.println(int.class.getSuperclass()); //null

        Object ref1=new int[]{1,2,3};   //valid because int[] extends Object and Object is base class.

        //Object[] ref2=new int[]{1,2,3};  invalid statement because int[] extends Object class and not Object[] class.
    }
}

class OverloadedMethodAmbiguousNext{
    public void test(Object obj) {
        System.out.println("Object");
    }
    public void test(char[] obj) {
        System.out.println("Char");
    }
    public void test(Integer obj) {
        System.out.println("Int");
    }
    public static void main(String[] args) {
        OverloadedMethodAmbiguousNext obj = new OverloadedMethodAmbiguousNext();
        //Ambiguous call because both the classes char[] and Integer are at same level to Object class and fall in
        //different hierarchy, so compiler will not able to resolve as which method to invoke.
        //obj.test(null);
    }
}

class OverloadedMethodWidening{
    public void test(long lng) {
        System.out.println("Long");
    }

    public void test(Integer integer) {
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        OverloadedMethodWidening obj = new OverloadedMethodWidening();
        //Display Long because widening wins over Boxing
        obj.test(1);
    }
}

class OverloadedMethodWidenThenBox{
    public void test(Integer i) {
        System.out.println("Integer");
    }
    public void test(Long l) {
        System.out.println("Long");
    }

    public static void main(String[] args) {
        OverloadedMethodWidenThenBox obj = new OverloadedMethodWidenThenBox();
        short s = 10;
        //Compilation error : You cannot widen then box
        //For short primitive type to be resolved to either Integer or Long wrapper class, it has to
        //first widen short to int and then box it to Integer, which is not possible.
        //obj.test(s);
    }
}

class OverloadedMethodBoxThenWiden{
    public void test(Character c) {
        System.out.println("Character");
    }
    public void test(Integer i) {
        System.out.println("Integer");
    }
    public void test(Object o) {
        System.out.println("Object");
    }
    public static void main(String[] args) {
        OverloadedMethodBoxThenWiden obj = new OverloadedMethodBoxThenWiden();
        byte b = 10;
        obj.test(b);
    }
}

class OverloadedMethodAmbiguousNextNext {
    public void test(char i, Character j) {
        System.out.println("method 1");
    }

    public void test(Character i, Character j) {
        System.out.println("method 2");
    }

    public static void main(String[] args) {
        OverloadedMethodAmbiguousNextNext obj = new OverloadedMethodAmbiguousNextNext();

        /*
        If call is not resolved by using any of the 3 ways then it gives compile error.

        In our case, method call, test('a','a') is not resolved by using STEP 1 because,
                In STEP 1, 1st argument of method test(char i, Character j) is mapped but for 2nd parameter
        it is not able to resolved using STEP 1, so control flow to STEP 2 for method resolution.

        In STEP 2, Compiler tries to resolve call using Boxing and Un-Boxing and found that both
        method is applicable and valid for call to test('a','a') and that is why Compiler stop here and
        gave Ambiguous method call error.*/

        //obj.test('a', 'a');
    }
}

class OverloadedMethodVarArgs{
    public void test(int... i) {
        System.out.println("method 1");
    }
    public void test(Integer... i) {
        System.out.println("method 2");
    }

    public static void main(String[] args) {
        OverloadedMethodVarArgs obj = new OverloadedMethodVarArgs();
        /*
        In our case, method call, test(1) is not resolved by using STEP 1 because,
               In STEP 1,compiler will try data type widening and see whether call is resolved but no in
               our case.

               In STEP 2, Compiler tries to resolve call using Boxing and Un-Boxing and see whether call
               is resolved but no in our case.

               In STEP 3, Compiler tries to resolve call using Boxing and Un-Boxing along with variable
               argument and see whether call is resolved. In our case at this step compiler will find both
               method test(int...) and test(Integer...) is applicable and call  resolved to 2 methods that is
               why it gave compile error.
         */
        //obj.test(1);
    }
}

class OverloadedMethodAmbiguousSysout{

    public static void main(String[] args) {
            /*
             It gave compiler error because call to println(null) is ambiguous and compiler will not able
              to decide as which method to invoke among multiple overloaded println() method as none
              of the class level parameter is more specific.
             */
        //System.out.println(null);
    }
}
