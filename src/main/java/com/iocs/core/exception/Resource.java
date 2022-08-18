package com.iocs.core.exception;

public class Resource implements AutoCloseable{

    public void test() throws Exception1,Exception2{

    }

    @Override
    public void close(){
        System.out.println("Resource Released");
    }
}
