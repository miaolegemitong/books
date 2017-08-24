package com.miaolegemitong.basics.jvm;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2017/5/22
 * @description
 */
public class Counter extends Thread {
    public static Integer count = 1;

    public static Object lock = new Object();

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                Counter.count++;
                System.out.println(Counter.count);
            }
        }
    }

    public static void main(String[] args) {
        Thread increment = new Counter();
        Thread decrement = new Decrement();
        increment.start();
        decrement.start();
    }
}

class Decrement extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (Counter.lock) {
                Counter.count--;
                System.out.println(Counter.count);
            }
        }
    }
}