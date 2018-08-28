package com.stackatomc.OfferBook;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * @File: Solution20
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/26 22:27
 * @Version: 1.0
 */
import java.util.Stack;

public class Solution20 {

    Stack<Integer> st1=new Stack<Integer>();
    Stack<Integer> recordmin=new Stack<Integer>();
    //int min1=-1;
    //int min2=-1;

    //1. 做了异常处理
    public void push(int node) {
        try{
            if(node<recordmin.peek()){
                recordmin.push(node);
            }
        }catch(EmptyStackException e){
            System.out.println("push()当前是空栈");
            recordmin.push(node);
        }
        st1.push(node);
    }


    public void pop() {
        try{
            if(recordmin.peek()==st1.pop())
                recordmin.pop();
        }catch(EmptyStackException e){
            System.out.println("pop()当前是空栈");
        }
        return ;
    }

    public int top() {
        try{
            return st1.peek();
        }catch(EmptyStackException e){
            System.out.println("top()当前是空栈");
        }
        return -1;
    }

    public int min() {
        try{
            return recordmin.peek();
        }catch(EmptyStackException e){
            System.out.println("min()当前是空栈");
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution20 s20=new Solution20();
        s20.push(9);
        s20.push(10);
        s20.push(7);
        s20.pop();
        System.out.println(s20.min());
        System.out.println(s20.min());
        s20.push(5);
        System.out.println(s20.min());
    }

}