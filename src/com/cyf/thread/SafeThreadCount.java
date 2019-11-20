package com.cyf.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/17 15:01
 * @Description: 编写一个线程安全的计数器
 */
public class SafeThreadCount implements Runnable {

    private static AtomicInteger count = new AtomicInteger(0);  //计数器初始值0

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SafeThreadCount.calc();
        }
    }

    private synchronized static void calc() {
        if (count.get() < 1000) {
            // 自增1，返回更新后的值
            int c = count.incrementAndGet();
            System.out.println("线程:" + Thread.currentThread().getName() + " :" + c);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SafeThreadCount safeThreadCount = new SafeThreadCount();
            Thread t = new Thread(safeThreadCount);
            t.start();
        }
    }

}
