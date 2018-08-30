package com.stackatomc.OfferBook;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @File: Practise01
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/30 11:53
 * @Version: 1.0
 */
public class Practise01 {

    //1 用排序来前后对比，快速排序法排序O(nlogn)
    public boolean dulicate(int[] numbers){
        if(numbers==null||numbers.length==1)return false;
        numbers=twoSort(numbers,0,numbers.length-1);
        for(int i=1;i<numbers.length;++i){
            System.out.print(numbers[i]+" ");
            if(numbers[i-1]==numbers[i])
                return true;
        }
        return false;
    }

    public int[] twoSort(int[] numbers,int start,int end){
        if(start>=end)return numbers;
        int a0=numbers[start];
        int sT=start;
        int eT=end;
        while(sT<eT){
            while(numbers[eT]>=a0&&eT>sT){
                eT=eT-1;
            }
            numbers[sT]=numbers[eT];
            while(numbers[sT]<a0&&eT>sT){
                sT=sT+1;
            }
            numbers[eT]=numbers[sT];
        }
        numbers[sT]=a0;
        twoSort(numbers,start,sT-1);
        twoSort(numbers,sT+1,end);
        return numbers;
    }

    //2 将数组当成hashmap索引来用 O(n)
    public boolean dulicate2(int[] numbers){
        int i=0;
        while(i<numbers.length){
            if(numbers[i]!=i){
                if(numbers[numbers[i]]==numbers[i]){
                    return true;
                }else{
                    int temp=numbers[i];
                    numbers[i]=numbers[numbers[i]];
                    numbers[i]=temp;
                }
            }else{
                i=i+1;
            }
        }
        return false;
    }

    //3 用API，Arrays.sort()底层对数值类型用快速排序方法实现，对象时则是优化的合并排序方法实现
    // O(nlogn)
    public boolean dulicate3(int[] numbers){
        Arrays.sort(numbers);
        for(int i=1;i<numbers.length;++i){
            if(numbers[i]==numbers[i--])
                return true;
        }
        return false;
    }

    //4 用hashmap O(n)
    public boolean dulicate4(int[] numbers){
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=1;i<numbers.length;++i){
            if(hs.containsKey(numbers[i]))
                return true;
            hs.put(numbers[i],1);
        }
        return false;
    }

    public static void main(String[] args) {
        Practise01 p1=new Practise01();
        int[] numbers={2,3,5,4,3,2,0};
        System.out.println(p1.dulicate(numbers));
        System.out.println(p1.dulicate2(numbers));
        System.out.println(p1.dulicate3(numbers));
        System.out.println(p1.dulicate4(numbers));
    }
}
