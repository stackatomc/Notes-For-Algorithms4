package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex22
 * @Description
 * @date 2018/8/21
 */
public class Ex22 {

    /* 二分算法的实现 */

    public static int rank(int key, int[] a)
    {   int count=0;
        return rank(key, a, 0, a.length - 1,count);  }
    public static int rank(int key, int[] a, int lo, int hi,int count)
    {  //如果key存在于a[]中，它的索引不会小于lo且不会大于hi
        if (lo > hi) return -1;
        count++;
        int mid = lo + (hi - lo) / 2;
        System.out.println("count："+count+" lo："+lo+" hi："+hi+" mid："+mid);
        if      (key < a[mid]) return rank(key, a, lo, mid - 1,count);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi,count);
        else                   return mid;
    }

    public static void main(String[] args) {

        int a[]={1,5,7,9,22};
        rank(5,a);
    }
}
