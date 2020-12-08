package com.cyf.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class kk {

    private static String startTime = "b";

    public static void setStart() {
        startTime = "a";
    }

    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            System.out.println(i);
            if (i == 8) {
                System.out.println("over");
                if (true){
                    break;
                }
            }

        } while (true);

        /*String formatStr = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
        System.out.println(dateFormat.format(new Date(0)));
        //System.out.println(dateFormat.format(lastUpdateTime));*/


    }
}
