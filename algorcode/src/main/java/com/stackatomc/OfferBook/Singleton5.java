package com.stackatomc.OfferBook;

/**
 * @File: Singleton5
 * @Description: 通过静态内部类实现单例模式（懒汉模式，按需提供）
 * @Author: MayerFang
 * @Date: 2018/8/30 10:33
 * @Version: 1.0
 */
public class Singleton5 {

    private Singleton5(){};

    static class SingletonBuilder{
        private static Singleton5 instance=new Singleton5();
    }

    private static Singleton5 instance(){
        return SingletonBuilder.instance;
    }

    public static void main(String[] args) {
        Singleton4 s4=Singleton4.instance();
    }
}
