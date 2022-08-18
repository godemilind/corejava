package com.iocs.designPattern.bp.adapter;

public class AdapterImpl implements Adapter{

    private Adaptee adaptee;

    @Override
    public void request(ClassA a) {
        ClassB b = convertAtoB(a);
        adaptee.request(b);
    }

    public ClassB convertAtoB(ClassA a){
        return new ClassB();
    }
}
