package com.stackatomc.OfferPractise;

import java.util.Stack;

/**
 * @File: Solution5
 * @Description:用两个栈实现队列
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author: MayerFang
 * @Date: 2018/8/26 0:49
 * @Version: 1.0
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //public void push(int node) {
        //.push(node);
    //}
    public void push(int node){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        while(!stack1.isEmpty()){
            System.out.println(stack1.search(5));
            stack2.push(stack1.pop());
        }
        int result=stack2.pop();
        return result;
    }

    public static void main(String[] args) {
        Solution5 s5=new Solution5();
        s5.push(3);
        s5.push(5);
        System.out.println(s5.pop());
    }
}
