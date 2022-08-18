package com.iocs.thread.communication;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> data = new ArrayBlockingQueue<Integer>(100);
        Producer p = new Producer(data);
        Consumer c1 = new Consumer(data);
        Consumer c2 = new Consumer(data);
        Consumer c3 = new Consumer(data);
        Consumer c4 = new Consumer(data);
        //Consumer c5 = new Consumer(data);

        new Thread(p,"Producer 1: ").start();
        new Thread(c1,"Consumer 1: ").start();
        new Thread(c2,"Consumer 2: ").start();
        new Thread(c3,"Consumer 3: ").start();
        new Thread(c4,"Consumer 4: ").start();
        //new Thread(c5,"Consumer 5: ").start();
    }
}
