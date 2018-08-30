package com.stackatomc.OfferPractise;


/**
 * @File: Solution15
 * @Description: 反转链表
 * 题目描述
输入一个链表，反转链表后，输出新链表的表头。
 * @Author: MayerFang
 * @Date: 2018/8/26 19:32
 * @Version: 1.0
 *
 *
 *
 */


public class Solution15 {
    /* 复杂性提示问题，其他不清楚，不通过*/
//    public static ListNode ReverseList(ListNode head) {
////        if(head==null) return null;
////
////        ListNode listNode=ReverseList(head.next);
////
////        if(listNode==null)System.out.println("new head-->"+head.val);
////
////        //此时head是最后一个
////        while(listNode!=null){
////            head.next.next=head;
////        }
////        return head;
////    }

    public static ListNode ReverseList2(ListNode head) {
        if(head==null) return null;
        if(head.next==null){
            System.out.println(head.val);
            return head;
        }

        ListNode currNode=new ListNode(head.val);
        ListNode nextNode=null;

        while(head.next!=null){
            nextNode=new ListNode(head.next.val);
            nextNode.next=currNode;

            currNode=nextNode;
            head=head.next;
        }
        System.out.println("new head-->"+head.val);

        return nextNode;
    }

    public static void printL(ListNode head){
        while(head!=null) {
            System.out.print(head.val+"   ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        printL(listNode1);
        System.out.println();
        ListNode newList=ReverseList2(listNode1);
        System.out.println();
        printL(newList);

    }

}