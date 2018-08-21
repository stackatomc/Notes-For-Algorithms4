package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex28
 * @Description
 * @date 2018/8/21
 */
public class Ex28 {


    public void DelMulti(int[] arr,int index){
        if(index+1>arr.length-1) return ;
        if(arr[index]==arr[index+1])
            {arr[index]=-1;}
        index++;
        DelMulti(arr,index);
    }

    //1. 遍历删除置-1
    //2. 子问题删前后，模仿二分法做递归
}
