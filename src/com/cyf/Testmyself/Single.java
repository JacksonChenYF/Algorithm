package com.cyf.Testmyself;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/29 23:56
 * @Description:
 */
public class Single {

    private Single(){};

    private static volatile Single single;

    public static Single getSingle(){
        if (single == null){
            synchronized (Single.class){
                if (single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }

}
