package com.example;

class Parent {
    public int add() throws NullPointerException {
        int a = 5 + 6;
        return a;
    }
}

public class Child extends Parent {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.add());
    }

    public int add() throws Exception  {
        int a = 5 + 16;
        return a;
    }
}
