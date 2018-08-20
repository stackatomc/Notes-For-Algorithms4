package com.stackatomc.chapter01;

/**
 * @author MayerFang
 * @file StaticFuncs
 * @Description
 * @date 2018/8/20
 */
public class StaticFuncs {

    /* 1. 判断一个数是否是素数 */
    public static boolean isPrime(double x){
        //素数是在大于1的自然数中,除了1和它本身以外不再有其他因数。
        // 2是素数,因为2只能被1和它自己本身整除。
        if(x<2)return false;

        for(int i=2;i*i<=x;++i){
            if(x%i==0) return false;
        }
        return true;
    }

    /* 2. 计算平方根（牛顿迭代法）   !!!无法自己写出 */
    public static double sqrt(double c){
        // NaN（Not a Number，非数）是计算机科学中数值数据类型的一个值，表示未定义或不可表示的值
        if(c<0)return Double.NaN;
        double err=1e-15;
        double t=c;
        while(Math.abs(t-c/t)>err*t)
            t=(c/t+t)/2.0;
        return t;

    }

    /* 3. 计算直角三角形的斜边 */
    public static double hypotenuse(double a,double b){
        return Math.sqrt(a*a+b*b);
    }

    /* 4. 计算调和级数 （倒数之和）*/
    public static double H(int N){
        double sum=0.0;
        for(int i=1;i<N;++i)
            sum+=1.0/i;
        return sum;
    }

    /*  5. 二分查找的递归实现 */
    // 要提供一个最简单的return实现
    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length-1);
    }
    // 解决规模更小的问题
    public static int rank(int key,int[] a,int start,int end){
        if(start>end)return -1;
        int mid=(start+end)/2;
        if(key<a[mid])return rank(key,a,start,mid-1);
        else if(key>a[mid])return rank(key,a,mid+1,end);
        else return mid;
    }

}
