package com.iocs.core.finallyBlock;

public class FinallyDemo {

    public static void main(String[] args) {
        test();
    }

    public static String test(){
        try{
            return "Hello";
        }finally {
            System.out.println("Finally");
        }
    }
}
