package com.iocs.designPattern.bp.adapter;

import java.io.*;

public class Client {



    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();
        ClassA a = new ClassA();
        adapter.request(a);
    }
}
