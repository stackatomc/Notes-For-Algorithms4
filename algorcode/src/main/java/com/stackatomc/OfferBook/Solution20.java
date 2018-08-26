package com.stackatomc.OfferBook;

import java.util.LinkedList;

/**
 * @File: Solution20
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/26 22:27
 * @Version: 1.0
 */
public class Solution20 {

        LinkedList<Integer> st=new LinkedList<Integer>();

        public void push(int node) {
            st.addLast(node);
        }

        public void pop() {
            st.removeLast();
        }

        public int top() {
            // 不删
            int ele=st.getLast();
            return ele;
        }

        public int min() {
            if(st.size()==0)return -1;
            int min=st.get(0);
            for(int i=0;i<st.size()-1;++i){
                if(min>st.get(i))min=st.get(i);
            }
            return min;

        }

    public static void main(String[] args) {
        Solution20 stest=new Solution20();
        stest.push(2);
        stest.push(3);
        stest.push(4);
        stest.pop();
//        String[] test1={"PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"};
//        for(String str:test1)
//        {
//            stest.push(Integer.parseInt(str));
//        }

        System.out.println(stest.min());
    }

}
