package com.cyf.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: ChenYF
 * @Date: 2019/4/15 17:32
 * @Description: 比较器
 * 1、自定义对象添加到数组后需要打印后才能输出，不然输出的是其内存地址（toString()将一个对象转换为一个字符串。）
 * 【toString()默认打印的是对象的十六进制的哈希码的值】
 * 2、实现Comparator<>接口，参数为对象名Student，重载compare(Student o1, Student o2)类
 * 3、 Arrays.sort(S,new IDComparator());添加到第二参数；
 */
public class Comparator_Test {

    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }

    //按ID升序排列的方法
    public static class IDComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2){
            //逻辑
           /*if(o1.id < o2.id){
                return -1;
            } else if (o2.id < o1.id){
                return 1;
            }else{
                return 0;
            }*/
           //简化
        return o1.id - o2.id;
        }
    }

    //打印输出
    private static void printStudent(Student[] T) {
        for (int i = 0 ; i < T.length ; i++){
            System.out.println(T[i].toString());
        }
    }

    public static void main(String[] args) {
        Student S1 = new Student("shuai",1,18);
        Student S2 = new Student("YY",8,19);
        Student S3 = new Student("ss",5,15);
        Student S4 = new Student("kk",5,19);
        Student[] S = new Student[]{S1,S2,S3,S4};
        /*System.out.println(S[0].toString());
        System.out.println(S.length);*/
        printStudent(S);

        Arrays.sort(S,new IDComparator());
        System.out.println("按ID排序后：");
        printStudent(S);

        //堆
        PriorityQueue<Student> heap = new PriorityQueue<>(new IDComparator());
        heap.add(S1);
        heap.add(S2);
        heap.add(S3);
        while (!heap.isEmpty()){
            Student student = heap.poll();
            System.out.println("小根堆"+"Student{" +
                    "name='" + student.name + '\'' +
                    ", id=" + student.id +
                    ", age=" + student.age +
                    '}');
        }
    }



}
