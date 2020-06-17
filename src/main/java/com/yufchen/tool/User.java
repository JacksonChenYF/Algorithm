package com.yufchen.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * 供com.yufchen.tool.stream测试指定去重
 */
@AllArgsConstructor
@Data
public class User {

    @NonNull
    private int userId;
    @NonNull
    private String userName;

    private String userSex;

    private Sporter sporter;

    public User(int userId, String userName, String userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
    }
}
