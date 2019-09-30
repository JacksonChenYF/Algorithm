package com.cyf.Testmyself;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/4 21:35
 * @Description:
 */
public class testmd5 {
    public static class md {

        private static final String salt = "1234";
        public static char a = '1';
        public static char b = '2';

        public static void main(String[] args) {
/*            System.out.println(salt.charAt(0));
            System.out.println(salt.charAt(1));
            System.out.println(""+salt.charAt(0)+salt.charAt(1));
            System.out.println(""+a+b);*/

            String url = "/rule/ghgh/ghg/jj/";
            if (null != url && !"".equals(url)) {
                String[] split = url.split("/");
                if (null != split && split.length >= 2) {
                    url = "/" + split[1];
                }
            }
            System.out.println(url);

            System.out.println(9 / 32);

            int[][] arr1 = new int[3][6];
            System.out.println("行数：" + arr1.length + " 第一行的列数：" + arr1[0].length);
            int[] arr2[] = {{1, 2, 3}, {5, 6, 7}, {9, 8}};
            System.out.println("行数：" + arr2.length + " 第一行的列数：" + arr2[0].length + " 第三行的列数：" + arr2[2].length);
            int arr3[][] = new int[3][9];
            System.out.println("行数：" + arr3.length + " 第一行的列数：" + arr3[0].length + " 默认值：" + arr3[1][2]);

            int count = 0;
            for (int i = 0; i < 100; i++) {
                count = count + i;
            }
            System.out.println(count);

        }
    }
}
