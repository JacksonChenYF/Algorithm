package com.cyf.Testmyself;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/27 11:55
 * @Description:
 */
public class Test {

    Lock lock = new ReentrantLock();   //全局，获取的是同个锁
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static void main(String[] args)  {

        String realPath = System.getProperty("Sso.Path");
        System.out.println("===="+ realPath +"=====");
        String sysname = System.getProperty("os.name");

        String SAP_SSO2EXT_LIB = "";
        String SAP_SECU_LIB = "";
        String SAP_SSO_KEY_FILE = "";
        if(sysname.startsWith("Win")){
            System.out.println(realPath + File.separator +  SSOConstant.SAP_SSO2EXT_LIB_WIN);
            System.out.println(realPath + File.separator + SSOConstant.SAP_SECU_LIB_WIN);
            System.out.println(realPath + File.separator + SSOConstant.SAP_SSO_KEY_FILE_WIN);

            SAP_SSO2EXT_LIB = realPath + File.separator +  SSOConstant.SAP_SSO2EXT_LIB_WIN;
            SAP_SECU_LIB = realPath + File.separator + SSOConstant.SAP_SECU_LIB_WIN;
            SAP_SSO_KEY_FILE = realPath + File.separator + SSOConstant.SAP_SSO_KEY_FILE_WIN;
        }else{
            System.out.println(realPath + File.separator +  SSOConstant.SAP_SSO2EXT_LIB_UNIX);
            System.out.println(realPath + File.separator + SSOConstant.SAP_SECU_LIB_UNIX);
            System.out.println(realPath + File.separator + SSOConstant.SAP_SSO_KEY_FILE_UNIX);

            SAP_SSO2EXT_LIB = realPath + File.separator +  SSOConstant.SAP_SSO2EXT_LIB_UNIX;
            SAP_SECU_LIB = realPath + File.separator + SSOConstant.SAP_SECU_LIB_UNIX;
            SAP_SSO_KEY_FILE = realPath + File.separator + SSOConstant.SAP_SSO_KEY_FILE_UNIX;
        }


        final Test test = new Test();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        //Lock lock = new ReentrantLock();    //注意这个地方,局部变量，获取时不是同个锁
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
            thread.wait(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }

}
