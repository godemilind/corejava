package com.iocs.collections;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        // size zero will throw error
        try {
            queue.add("One");
            queue.add("Two");
        }catch(IllegalStateException e){
            e.printStackTrace();
        }

        queue = new ArrayBlockingQueue<>(1);
        try{
            queue.add("One");
            queue.remove();
            queue.remove();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

        queue = new ArrayBlockingQueue<>(2);
        queue.offer("ONE");
        queue.offer("TWO");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
