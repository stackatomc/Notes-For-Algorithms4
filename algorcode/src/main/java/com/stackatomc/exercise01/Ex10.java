package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex10
 * @Description
 * @date 2018/8/20
 */
public class Ex10 {

    /* 数组基本类型也是一样，要注意生命时用new初始化，分配内存空间 */
    public static void main(String[] args) {
        int[] a;
        for(int i=0;i<10;i++){
            //！a[i]=i*i; //编译时报错，提示为未初始化；即未用new 为a[] 分配内存
        }
    }
}
