package com.stackatomc.tools;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author MayerFang
 * @file Ex28
 * @Description
 * @date 2018/8/21
 */
public class Ex28 {

    // 删除数组重复元素
    //1. 遍历删除置-1
    //2. 子问题删前后，模仿二分法做递归  未实现
    //3. 用Set来存

    public static int[] deleteList(int[] arr){
        int temp;
        for(int i=0;i+1<arr.length;++i){
            temp=i;
            if(arr[temp]==arr[temp+1]){
                arr[temp]=-1;
            }
        }
        return arr;
    }

    public static int[] changeToSet(int[] arr){
        Set lhs=new LinkedHashSet();
        for(int i=0;i<arr.length;++i){
            lhs.add(arr[i]);
        }
        //System.out.println(lhs);
        Iterator iterator=lhs.iterator();
        //System.out.println(lhs.size());
        for(int i=0;iterator.hasNext();++i){
                //arr[i]=iterator.next();
                arr[i]=((Integer)iterator.next()).intValue();
        }

        if(arr.length>lhs.size()){
            for(int i=lhs.size()+1;i<arr.length;++i){
                arr[i-1]=0;
            }
        }
        // 缩容
        for(int i=0;i<arr.length;++i){
            arr=Arrays.copyOf(arr,lhs.size());
        }
        return arr;
    }

//    /*  5. 二分查找的递归实现 */
//    // 要提供一个最简单的return实现
//    public static int[] rank(int[] a){
//        return rank(a,0,a.length-1);
//    }
//    // 解决规模更小的问题
//    public static int[] rank(int[] a,int start,int end){
//        if(start>end)return null;
//        int mid=(start+end)/2;
//        if(a[0]==a[1])a[0]=-1;
//        if(a[mid-1]==a[mid])a[mid-1]=-1;
//        while(1<mid)
//            rank(a,start,mid-1);
//            rank(a,mid+1,end);
//        return a;
//    }
//
//    //删除两个仅前一个
//    public static int[] delHalf(int[] arr){
//        //arr.length==2
//        int count=0;
//        if(arr.length<2)return arr;
//        if(arr[0]==arr[1]){
//            arr[0]=-1;
//        }
//        //应该用在外面的...
//        int[] templeft=new int[arr.length/2];
//        int[] tempright=new int[arr.length/2];
//        for(int i=0;i<arr.length/2;++i){
//            tempright[i]=arr[i];
//        }
//        for(int i=arr.length/2;i<arr.length;++i){
//            tempright[count]=arr[i];
//            count=count+1;
//        }
//
//        //删除前后
//        if(templeft[templeft.length-1]==tempright[0])
//            templeft[templeft.length-1]=-1;
//
//        delHalf(templeft);
//        delHalf(tempright);
//
//        for(int i=0;i<arr.length;++i){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        //子问题
//        return arr;
//    }

    public static void main(String[] args) {
        int[] arrTest={3,4,4,5,7,9,11,11};//arrTest.length=8
        //int[] arrtemp=deleteList(arrTest);
        int[] arrtemp=deleteList(arrTest);
        //delHalf(arrTest);
        for(int i=0;i<arrtemp.length;++i){
            System.out.print(arrtemp[i]+" ");
        }

    }
}
