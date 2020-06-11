package com.yufchen.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
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
        distinct();
        //easyDistinct();
    }

}
