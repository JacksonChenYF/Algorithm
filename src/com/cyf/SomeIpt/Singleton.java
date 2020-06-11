package com.cyf.SomeIpt;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/23 09:12
 * @Description:双重检验锁
 * 为什么要加 volatile: 这一行代码 singleton = new Singleton(); 可分解为以下三行伪代码
 *  memory = allocate();   //1：分配对象的内存空间
 *  ctorInstance(memory);  //2：初始化对象
 *  instance = memory;     //3：设置instance指向刚分配的内存地址
 *  2和3之间，可能会被重排序，这样执行3时：注意，此时对象还没有被初始化！（所以另一个线程引用的对象有可能还没有完成初始化）
 *
 *  介绍一下volatile（易变的）！
 *  主要作用：使变量在多个线程间可见（可见性）；强制从公共内存中读取变量的值；
 *  与synchronized比较：
 *  1、volatile是线程同步的轻量级实现，性能优于synchronizad；
 *  2、volatile只能修饰变量，而s 可以用于修饰方法，以及代码块；
 *  3、多线程访问volatile不会发生阻塞，而s 会；
 *  4、volatile 能保证数据的可见性，但不会保证原子性；而s 主要解决多个线程访问资源的同步性具有可见性与互斥性。
 *
 *  i++ 分解为 1：从内存中取出i的值、2：计算i的值、3：将i的值写到内存中
 *
 * 练习次数：2 -> 10.8success 3->10.15success 增加
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }



























}
