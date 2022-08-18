package com.iocs.deadlock;

public class DeadlockDemo  implements Runnable{

    private Object lock1;
    private Object lock2;

    public DeadlockDemo(Object lock1,Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new DeadlockDemo(lock1,lock2),"Thread 1").start();
        new Thread(new DeadlockDemo(lock2,lock1),"Thread 2").start();

        // Solution
        //new Thread(new DeadlockDemo(lock1,lock2),"Thread 1").start();
        //new Thread(new DeadlockDemo(lock1,lock2),"Thread 2").start();
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread()+" Obtained lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){

                System.out.println(Thread.currentThread()+" Obtained lock2");
            }
        }
    }
}
