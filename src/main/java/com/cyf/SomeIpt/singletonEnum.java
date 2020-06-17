package com.cyf.SomeIpt;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/1 00:41
 * @Description:对比双重检验锁模式，枚举解决了反射攻击和序列化问题
 */
public enum singletonEnum {
    INSTANCE;
    public singletonEnum getInstance(){
        return INSTANCE;
    }
}
