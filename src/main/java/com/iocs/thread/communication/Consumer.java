package com.iocs.thread.communication;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> data;

    private Integer SPEED = 500;

    public Consumer(BlockingQueue<Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {

            while (true) {
                try {
                    if (!data.isEmpty()) {
                        synchronized (data) {
                            System.out.println(Thread.currentThread().getName()+" Removed: " + data.poll());
                            data.notifyAll();
                            //data.wait();
                        }
                        Thread.sleep(SPEED);
                    } else {
                        System.out.println("*************** Data Empty ****************");
                        Thread.sleep(5000);
                        synchronized (data) {
                            data.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
