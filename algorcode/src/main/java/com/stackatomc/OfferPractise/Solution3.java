package com.stackatomc.OfferPractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @File: Solution3
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/30 22:55
 * @Version: 1.0
 */
public class Solution3 {

    // 1 递归实现
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listnode) {
        if(listnode==null) return null;
        printListFromTailToHead(listnode.next);
        arrayList.add(listnode.val);
        //System.out.print(listnode.val);
        return arrayList;
    }

    // 2 API Collections.reverse()实现
    public ArrayList<Integer> printListFromTailToHead2(ListNode listnode) {
        if(listnode==null) return null;
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        while(listnode!=null){
            arrayList2.add(listnode.val);
            listnode=listnode.next;

        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    // 3 用栈压入实现
    public ArrayList<Integer> printListFromTailToHead3(ListNode listnode) {
        if(listnode==null) return null;
        Stack<Integer> st=new Stack<Integer>();
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
        while(listnode!=null){
            st.push(listnode.val);
            listnode=listnode.next;
        }
        while(!st.isEmpty()){
            arrayList3.add(st.pop());
        }
        return arrayList3;
    }

    // 4 通过改变链表实现
    public ArrayList<Integer> printListFromTailToHead4(ListNode listnode) {
        if(listnode==null) return null;
        ListNode head=listnode;
        while(listnode!=null){
            ListNode curNode=listnode;
            listnode=listnode.next;
            if(head!=curNode){
                curNode.next=head;
                head=curNode;
            }else{
                head.next=null;
            }
        }
        ArrayList<Integer> arrayList4=new ArrayList<Integer>();
        while(head!=null){
            arrayList4.add(head.val);
            head=head.next;
        }
        return arrayList4;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        Solution3 s3=new Solution3();
        System.out.println(s3.printListFromTailToHead4(listNode1));
    }
}
