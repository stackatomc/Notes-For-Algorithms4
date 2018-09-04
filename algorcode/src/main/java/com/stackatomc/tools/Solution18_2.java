package com.stackatomc.tools;


/**
 * @File: Solution18_2
 * @Description: 1 高效删除链表节点的方法（给出删除的节点可不需要得到前一个节点）2 删除链表节点的逻辑（头结点判断、中间节点、尾节点）
 * @Author: MayerFang
 * @Date: 2018/9/3 21:13
 * @Version: 1.0
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class Solution18_2 {

    public void DeleteNode(ListNode listNode,ListNode deleteNode){
        if(listNode==null||deleteNode==null)return ;
        ListNode node=listNode;
        //删除时间复杂度为0（1）的算法,必须确定下一个非空,也就是非尾节点，但可以为头结点
        if(deleteNode.next!=null){
            ListNode deleteNodenNext=deleteNode.next;
            deleteNode.val=deleteNodenNext.val;
            deleteNode.next=deleteNodenNext.next;
            return ;
        }
        else{
            //删除非头结点或尾节点
            if(node.next==deleteNode){
                // 判断是否只有两个节点，而deleteNode恰为尾节点
                node.next=null;
                return;
            }

            //如果以上都不是，只能从头结点一直遍历找到尾节点前一个进行删除
            //注意deleteNode是一个引用，是一个句柄
        while(node!=null&&node!=deleteNode){
            node=node.next;
       }
        if(node==null)return;
        node.next=deleteNode.next;
        return ;
        }
    }
}
