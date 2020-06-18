package com.yufchen.tool;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Java 8 Stream
 */
public class useStream {


    /**
     * 列表元素根据某个字段去重功能
     */
    public static void distinct() {

        //添加元素
        ArrayList<User> userList = addUser();
        System.out.println("元素去重前：");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }

        userList = (ArrayList<User>) userList.stream().filter(distinctByKey(User -> User.getUserId())).collect(Collectors.toList());

        System.out.println("根据userId元素去重后：");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static ArrayList<User> addUser() {
        //添加元素
        User user1 = new User(1, "1号姓名", "男");
        User user2 = new User(48, "48号姓名", "女");
        User user3 = new User(35, "35号姓名", "女");
        User user4 = new User(8, "8号姓名", "女");
        User user5 = new User(35, "35号姓名", "女");
        ArrayList<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        //Collections.addAll(userList, user1, user2, user3, user4, user5);
/*        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);*/
        return userList;
    }

    /**
     * 测试简单去重
     */
    public static void easyDistinct() {
        ArrayList<String> list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        System.out.print("列表去重前元素： ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        List<String> unique = list.stream().distinct().collect(Collectors.toList());

        System.out.print("列表去重后元素： ");
        for (String s1 : unique) {
            System.out.print(s1 + " ");
        }
    }


    public static void main(String[] args) {
        //distinct();
        //easyDistinct();

/*        //过滤空字符串
        List<String> strings = Arrays.asList("Hello","","jade");
        strings.stream().filter(s -> !s.isEmpty()).forEach(System.out::print);*/

/*        //输出元素对应的平方数
        List<Integer> list = Arrays.asList(3,8);
        list.stream().map(i -> i*i).forEach(System.out::println);*/

/*        //返回前面n个元素
        List<Integer> lists = Arrays.asList(3, 8, 8, 3, 112, 2);
        lists.stream().limit(3).forEach(System.out::println);*/

/*        //对流进行排序
        List<Integer> lists = Arrays.asList(3, 2, 8);
        lists.stream().sorted().forEach(System.out::println);*/

/*        //输出随机数
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/

/*        //统计流中元素数
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hollis666", "Hello", "HelloWorld", "Hollis");
        System.out.println(strings.stream().count());*/

/*        //归约操作：接受各种做法作为参数，将流中元素汇总结果：[Hollis, HollisChuang, Hollis666, Hollis]
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hollis666", "Hello", "HelloWorld", "Hollis");
        strings = strings.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        System.out.println(strings);*/

/*        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(list.size());*/

/*
        String[] strings = {"你好", "世界"};
        List list = Arrays.asList(strings);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        strings[0] = "你不好";
        list.set(1, "yufchen");
        System.out.println(Arrays.toString(strings) + list.toString());
        //由于asList产生的集合元素是直接引用作为参数的数组，所以当外部数组或集合改变时，数组和集合会同步变化*/

       // list.add("新增的话");
        //由于asList产生的集合并没有重写add,remove等方法，所以它会调用父类AbstractList的方法，而父类的方法中抛出的却是异常信息。
        //System.out.println(list.toString());

 /*       int intArray[] = {1, 2, 3};
        List<Integer> arraylist = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(arraylist);*/

    }

}
