package com.cyf.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 递归实验 第二
 */
public class GetMax {

    public static int getMax(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = (L + R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1,R);
        return  Math.max(maxLeft,maxRight);
    }

    private static String extractXmlValue(String xml, String tagName) {
        int start = xml.indexOf("<" + tagName + ">");
        if (start >= 0) {
            int end = xml.indexOf("</" + tagName + ">", start);
            return end <= 0 ? "" : xml.substring(start + ("<" + tagName + ">").length(), end);
        }
        return "";
    }

    public void max(Integer integer, Integer integer2, Integer integer3){
        System.out.println(integer);
        System.out.println(integer2);
        //System.out.println(integer3);
    }

    public static String traceNum = "000000";

    public static String getTraceNum() {
        return traceNum;
    }

    public static void setTraceNum(String traceNum) {
        GetMax.traceNum = traceNum;
    }

    /**
     * @Comment:生成交易全局跟踪号的方法
     * @return traceId 全局交易跟踪号
     * @author: YL
     * @date: 2018-4-26下午1:40:31
     */
    public static String getTraceId(){
        String traceId = "" ;
        String oldNum = GetMax.traceNum;
        String newNum = null;
        if(Integer.parseInt(oldNum)==999999){
            newNum = "000000";
        }else{
            int temp = Integer.parseInt(oldNum);
            newNum = (temp+1)+"";
            if(newNum.length()<6){
                newNum = "0000000000000".substring(0,6-newNum.length())+newNum;
            }

        }
        GetMax.setTraceNum(newNum);

        String time = (System.currentTimeMillis()+"").substring(0,10);
        traceId = "001" + time + oldNum;
        return traceId;
    }


    public static void main(String[] args){
        for (int i = 0 ; i < 10000000 ; i++ ){
            String s = getTraceId();
            System.out.println(s);
        }
    }
}
