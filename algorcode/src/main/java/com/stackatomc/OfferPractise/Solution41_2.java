package com.stackatomc.OfferPractise;

import edu.princeton.cs.algs4.In;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author MayerFang
 * @file Solution41_2
 * @Description 利用PriorityQueue求中位数
 * @date 2018/9/10
 */
public class Solution41_2 {
    private static PriorityQueue<Integer> minHeap,maxHeap;

    public void insert(int num){


        //1. compare重写排序的方法解释
        //2. Java中Comparable和Comparator区别小结 https://www.cnblogs.com/xujian2014/p/5215082.html
        if(((minHeap.size()+maxHeap.size())&1)==0){
            //当前是偶数，加入则是单数
            // 1. 则往小堆先加
            if(minHeap.peek()!=null&&num>minHeap.peek()){
                maxHeap.offer(minHeap.poll());// 视为最小堆反转的最小堆最小都比最大堆最大大，所以把最小堆最小扔给最大堆作为其最大
                minHeap.offer(num);
                System.out.println("here");
                System.out.println(maxHeap);
                System.out.println(minHeap);
            }else{
                // num<=minHeap.peek()说明num恰比最小堆的最小值小或相等
                maxHeap.offer(num);
            }
        }else{
            // 应该是最大堆比最小堆多1
            if(maxHeap.peek()!=null&&num<maxHeap.peek()){
                minHeap.offer(maxHeap.poll());// 视为最小堆反转的最小堆最小都比最大堆最大大，所以把最小堆最小扔给最大堆作为其最大
                maxHeap.offer(num);
                System.out.println("here222");
                System.out.println(maxHeap);
                System.out.println(minHeap);
            }else{
                // num<=minHeap.peek()说明num恰比最小堆的最小值小或相等
                minHeap.offer(num);
            }
        }
    }


    public int getMiddle(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap){
        int middle=-1;
        if(((minHeap.size()+maxHeap.size())&1)==0){
            int m1=minHeap.peek();
            int m2=maxHeap.peek();
            middle=(m1+m2)/2;
        }else{
            middle=maxHeap.peek();
        }

        return middle;
    }

    public static void main(String[] args) {
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>(20,new Comparator<Integer>(){
            @Override
            public int compare(Integer left,Integer right){
                return right.compareTo(left);
            }
        });


        Solution41_2 s2=new Solution41_2();
        int testNums[]={1,2,3,4,55,6,7,8};
        for(int num:testNums){
            System.out.println("num is:"+num);
            s2.insert(num);
        }

        System.out.println(s2.getMiddle(minHeap,maxHeap));
    }
}
