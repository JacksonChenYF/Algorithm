package com.cyf.zuoshen.hash;

import java.util.HashMap;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/3 10:12
 * @Description:设计一种结构：
 * 1 insert(key):将某个key加入到该结构。做到不重复加入
 * 2 delete(key):将原本在结构中的某个key移除。
 * 3 getRandom():等概率随机返回结构中的任何一个key
 * 时间复杂度都是O（1）

 */
public class RandomPool {

    public static class RandomPool1{
        public HashMap<String, Integer> map1 = new HashMap<>();
        public HashMap<Integer, String> map2 = new HashMap<>();
        public int size;

        public RandomPool1(){
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            size = 0;
        }

        public void add(String str){
            map1.put(str,size);
            map2.put(size,str);
            size++;
        }

        public String getRandom(){
            if (size == 0){
                return null;
            }
            int index = (int)(Math.random()*size);
            return map2.get(index);
        }



    }

}
