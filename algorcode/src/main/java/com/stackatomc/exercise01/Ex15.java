package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex15
 * @Description
 * @date 2018/8/21
 */
public class Ex15 {

    /*
    *     public static int[] histogram(int[] a,int M){int[] c=new int[a.length];
    *     //这里一定要注意new分配堆内存空间，不能是null
    *
    * */
    public static int[] histogram(int[] a,int M){
        int[] c=new int[a.length]; //这里一定要注意new分配堆内存空间，不能是null
        int count=0;
        for(int i=0;i<M;++i){
            for(int j=0;j<a.length;++j){
                if(a[j]==i) count++;
            }
            c[i]=count;
            count=0;
        }
        return c;
    }

    public static void main(String[] args) {

        int[] a={3,2,4,1,2,3,5};
        int result[]=histogram(a,6);
        for(int i=0;i<result.length;++i){
            System.out.print(result[i]+" ");
        }
    }
}
