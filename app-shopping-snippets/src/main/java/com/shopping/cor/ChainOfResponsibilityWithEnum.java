package com.shopping.cor;

public class ChainOfResponsibilityWithEnum {
    public static void main(String[] args) {


        int _a =10 , b=10 ;
        int A =12 ;



        System.out.println(_a);
        System.out.println(b);
        System.out.println(A);

        // Starting the chain with the first handler
        Request request = new Request("");
        ProcessStep.START.handle(request);
    }
}
