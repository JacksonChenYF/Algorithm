package com.cyf.Testmyself;

import com.cyf.SomeIpt.Singleton;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/26 09:53
 * @Description:
 */
public class linklisttest {


    private static volatile linklisttest singleton;
    private linklisttest(){};
    public static linklisttest getSingleton(){
        if (singleton == null){
            synchronized (linklisttest.class){
                if (singleton == null){
                    singleton = new linklisttest();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        List<Integer> excel = new LinkedList<Integer>();
        excel.add(1);
        excel.add(3);
        excel.add(8);
        excel.add(5);
        System.out.println(excel.toString());
        System.out.println(excel.get(1));

        String str = "";
        System.out.println(str.split(",").length);

        System.out.println(str.split(",").toString());


        String aa = "null";
        System.out.println(aa.length());

    }


}
