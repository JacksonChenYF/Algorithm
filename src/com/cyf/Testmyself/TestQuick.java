package com.cyf.Testmyself;

/**
 * @Auther: ChenYF
 * @Date: 2019/5/1 11:05
 * @Description:
 */
public class TestQuick {


    public static void quickSort(int[] arr, int L, int R){
        if(L<R){
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swa(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swa(arr, --more, L);
            } else {
                L++;
            }
        }
        swa(arr, more, R);
        return new int[]{less + 1, more};
    }


        public static void swa(int[] arr, int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }



    public static void main(String[] args){
        int[] arr = {1,3,4,2,5};
        quickSort(arr,0,4);
        for (int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
        System.out.println(-5 + 1/4 + 2*-3 + 5.0);
        System.out.println(-1/2);
        System.out.println(2*-3);

        int i = 0;
        i = i++ + i;
        System.out.println("I = "+ i);
    }
}
