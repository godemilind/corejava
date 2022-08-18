package com.iocs.thread.communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private BlockingQueue<Integer> data;

    private AtomicInteger counter = new AtomicInteger(0);

    private Integer SIZE = 100;

    private Integer SPEED = 100;

    public Producer(BlockingQueue<Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            try {
                if (!(data.size() == SIZE)) {
                    synchronized (data) {
                        data.offer(counter.incrementAndGet());
                        System.out.println(Thread.currentThread().getName()+" Added: " + counter.get()+ " Queue Size: "+data.size());
                        data.notifyAll();
                        //data.wait();
                    }
                    Thread.sleep(SPEED);
                } else {
                    System.out.println("*************** Data Full ****************");
                    Thread.sleep(5000);
//                    synchronized (data) {
//                        data.wait();
//                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

