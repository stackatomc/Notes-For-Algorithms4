package com.stackatomc.OfferBook;

/**
 * @File: Singleton3
 * @Description: 多线程中实现单例模式
 * @Author: MayerFang
 * @Date: 2018/8/30 10:18
 * @Version: 1.0
 * @Notes:
 * 1. 构造方法是私有的
 * 2. 获取的方法,不适合直接getSingleton()
 * 3. instance==null 多线程双重加锁
 * 4. 加锁锁定一个对象，不建议锁定this
 */
public class Singleton3 {

    /* java的synchronized(参数)，参数是this对象和参数是非this对象的区别
    * 参数	相同点	不同点
参数是this对象	都能实现同步	实现同步的同时，会阻塞其他线程获取这个对象的锁，影响执行效率
参数是非this对象	都能实现同步	synchronized（非this）代码块中程序与同步方法是异步的，不与其他锁this同步方法争夺this锁，可以提高执行效率
    * */
    private Singleton3(){};

    private static Integer i=1;

    private static Singleton3 instance=null;

    public static Singleton3 instance(){
        if(instance==null)
            synchronized(i){
                if(instance==null)
                    return instance=new Singleton3();
            }
        return instance;
    }
}
