package com.stackatomc.OfferPractise;

/**
 * @File: Solution31_1
 * @Description: 递归合并两个链表
 * @Author: MayerFang
 * @Date: 2018/9/5 16:08
 * @Version: 1.0
 */
public class Solution31_1 {

    public ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            head.next=mergeList(l1.next,l2);

        }else{
            head=l2;
            head.next=mergeList(l1,l2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l5=new ListNode(5);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);

        l1.next=l5;
        l3.next=l4;
        Solution31_1 s13=new Solution31_1();
        ListNode w=s13.mergeList(l1,l3);
        while(w!=null){
            System.out.println(w.val);
            w=w.next;
        }
    }
}
