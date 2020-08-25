package com.yufchen.tool;

import com.alibaba.fastjson.JSON;

/**
 * @Auther: yufchen
 * @Date: 2020/6/17 14:29
 * @Description:
 */
public class useJson {
    public static void main(String[] args) {


        Sporter sporter1 = new Sporter("篮球", "詹姆斯");
        User user1 = new User(1,"小飞","男",sporter1);

        //将对象转化成json
        String json = JSON.toJSONString(user1);
        System.out.println(json);

        System.out.println("第一次改动，合并");

        System.out.println("哈哈~");

    }





}
