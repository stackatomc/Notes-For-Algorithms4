package com.stackatomc.OfferPractise;

import edu.princeton.cs.algs4.In;

import java.util.PriorityQueue;

/**
 * @author MayerFang
 * @file Solution41_2
 * @Description
 * @date 2018/9/10
 */
public class Solution41_2 {

    public void insert(int num){
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>();

        //10 6 8 5 4 1 2 6 3 7 9
        //1 2 3 4 5 （6） 6 7 8 9 10
        //10
        //
        // minHeap: maxHeap:
        if(((minHeap.size()+maxHeap.size())&1)==0){
            //当前是偶数，加入则是单数
            // 1. 则往大堆先加
            if(maxHeap.size()==0){
                maxHeap.offer(num);
            }
        }else{
            //1. 肯定是大比小堆多
            if(maxHeap.peek()<num){
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
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
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>();
        int[] testn={3,5,2,10};
        maxHeap.offer(testn[0]);
        maxHeap.offer(testn[1]);
        maxHeap.offer(testn[2]);
        maxHeap.offer(testn[3]);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
    }
}
