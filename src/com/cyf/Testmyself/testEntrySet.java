package com.cyf.Testmyself;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/17 11:40
 * @Description:
 */
public class testEntrySet {




    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        //Map<String, String> map = new HashMap<>();
        map.put("笑话","书");
        map.put("YY","ku");
        map.put("地方","三亚");
        map.put("kenan","xiaoxin");
        map.put("2","4");
        map.put("6","7");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet){
            System.out.println(entry.getKey()+entry.getValue()+"");
        }


    }
}
