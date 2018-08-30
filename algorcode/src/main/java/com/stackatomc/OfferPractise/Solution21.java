package com.stackatomc.OfferPractise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @File: Solution21
 * @Description: 栈的压入、弹出序列
 * 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @Author: MayerFang
 * @Date: 2018/8/28 19:35
 * @Version: 1.0
 */
public class Solution21 {

    /*
    * 思考盲区:
    * 1. 忘了stack出来的时候的可以陆续出，直到出的不是当前第一个时，才继续压进去
    * 2. 没具体想清楚用什么数据结构/对象存储压入的数值
    * 3. 抛异常时后来的
    * 4. 循环没想清楚
    *
    * */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> st=new ArrayList<Integer>();

        if(pushA==null) return false;

        for(int i=0,j=0;i<pushA.length;){
            while(i<pushA.length&&pushA[i]!=popA[j]) {
                //System.out.println(pushA[i]);
                st.add(pushA[i]);
                i=i+1;
            }
            i++;
            j++;
            while(j<popA.length&&st.size()!=0&&st.get(st.size()-1)==popA[j]){
                //System.out.println(st.get(st.size()-1));
                st.remove(st.size()-1);
                j=j+1;
            }
        }

//        if(st.isEmpty()==true)
//            return true;
//        else
//            return false;
        return st.isEmpty();
    }


    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={4,3,5,1,2};
        System.out.println(IsPopOrder(a,b));
    }
}