package com.cyf.meeting;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/18 09:21
 * @Description:99乘法表
 */
public class 乘法表 {

    public static void echo99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1 ; j <= i ; j++){
                System.out.print(j + "*" + i +"=" + i*j +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        echo99();
    }

}
