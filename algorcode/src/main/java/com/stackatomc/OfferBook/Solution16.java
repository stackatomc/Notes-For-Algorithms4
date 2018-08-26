package com.stackatomc.OfferBook;

/**
 * @File: Solution16
 * @Description: 合并两个排序的链表
 * 题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author: MayerFang
 * @Date: 2018/8/26 20:31
 * @Version: 1.0
 */
public class Solution16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        //考察归并的merge

            ListNode head=new ListNode(5);
            ListNode newNode=head;

            while(list1!=null&&list2!=null){
                if(list1.val<=list2.val){
                    newNode.next=list1;
                    newNode=newNode.next;
                    list1=list1.next;
                }else{
                    newNode.next=list2;
                    newNode=newNode.next;
                    list2=list2.next;
                }
            }
            if(list1!=null)
                newNode.next=list1;
            else if(list2!=null)
                newNode.next=list2;

            return head.next;
    }
}
