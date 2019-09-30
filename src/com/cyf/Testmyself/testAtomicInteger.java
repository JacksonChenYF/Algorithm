package com.cyf.Testmyself;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/8 09:30
 * @Description:
 * volatile -- 只保证读或者写是原子性的
 * 1、保证变量在线程间可见，对volatile变量所有的写操作都能立即反应到其他线程中，换句话说，volatile变量在各个线程中是一致的（得益于java内存模型—"先行发生原则"）；
 * 2、禁止指令的重排序优化；
 *
 * AtomicInteger.incrementAndGet()方法的原子性。
 */
public class testAtomicInteger {

    public static class AtomicIntegerTest {

        private static final int THREADS_CONUT = 20;
        //public static volatile int count = 0;
        public static AtomicInteger count = new AtomicInteger(0);

        //test equals
        public static AtomicInteger equals1 = new AtomicInteger(0);
        public static AtomicInteger equals2 = new AtomicInteger(0);

        public static void increase() {
            //count++;
            count.incrementAndGet();
        }

        public static void main(String[] args) {
            Thread[] threads = new Thread[THREADS_CONUT];
            for (int i = 0; i < THREADS_CONUT; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            increase();
                        }
                    }
                });
                threads[i].start();
            }

            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(count);

            System.out.println(equals1.equals(equals2));//比较地址的
            System.out.println(equals1.get() == equals2.get());//.get对值进行比较
            System.out.println(equals1.get());
        }
    }

}
