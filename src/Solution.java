

import java.util.*;

class Parent {
    {
        System.out.println("Parent class init block 1");
    }

    static {
        System.out.println("Parent  class  static init 2");
    }
}

class Child extends Parent {
    {
        System.out.println("Child class init block 1");
    }

    static {
        System.out.println("Child class  static init 2");
    }
}


public class Solution {


    public static void main(String[] args) {
        new Child();
    }


}








