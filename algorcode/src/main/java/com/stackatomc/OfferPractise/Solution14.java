package com.stackatomc.OfferPractise;

/**
 * @File: Solution14
 * @Description: 链表种倒数第k个结点
 * 题目描述
输入一个链表，输出该链表中倒数第k个结点。
 * @Author: MayerFang
 * @Date: 2018/8/26 15:20
 * @Version: 1.0
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution14 {

    public ListNode FindKthToTail(ListNode head, int k) {

        if(head==null||k<=0)return null;

        ListNode listNode1=head;
        ListNode listNode2=head;
        // - - - - k=2
        int p1=1,p2=1;
        //-----------
        while(head.next!=null){
            head=head.next;
            listNode2=listNode2.next;
            p2=p2+1;
            if(p2>k){
                p1=p1+1;
                listNode1=listNode1.next;
            }
        }

        if(p2<k)
            return null;

        return listNode1;
    }

}