package com.stackatomc.OfferBook;

/**
 * @File: Singleton4
 * @Description: 饿汉模式创建
 * @Author: MayerFang
 * @Date: 2018/8/30 10:36
 * @Version: 1.0
 */
public class Singleton4 {

    private Singleton4(){};
    /* 这种静态变量在类加载时才分配内存 */
    private static Singleton4 instance=new Singleton4();
    public  static Singleton4 instance(){
        return instance;
    }
}
