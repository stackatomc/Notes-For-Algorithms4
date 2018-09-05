package com.stackatomc.tools;

/**
 * @File: Solution23_1
 * @Description: 环的问题：判断是否有环、环中节点数、环的入口位置
 * @Author: MayerFang
 * @Date: 2018/9/5 11:20
 * @Version: 1.0
 */

public class Solution23_1 {

    /*
    * 解决方法编辑
第一种方法，将所有的遍历过的节点用某个结构存储起来，然后每遍历一个节点，都在这个结构中查找是否遍历过，如果找到有重复，则说明该链表存在循环；如果直到遍历结束，则说明链表不存在循环。
这个结构我们可以使用hash来做，hash中存储的值为节点的内存地址，这样查找的操作所需时间为O(1)，遍历操作需要O(n)，hash表的存储空间需要额外的O(n)。所以整个算法的时间复杂度为O(n)，空间复杂度为O(n)。
第二种方法，比较的特别，是使用反转指针的方法，每过一个节点就把该节点的指针反向。
当有环的时候，最后指针会定位到链表的头部，如果到最后，都没有再到头部，那说明链表不存在循环。
这个方法会破坏掉链表，所以如果要求是不能破坏链表的话，我们最后就还需要反转一下，再将链表恢复。
这个方法使用的空间复杂度为O(1)，其实是使用了3个指针，用于进行反转。同时，时间复杂度为O(n)。
第三种方法，可能大家已经知道了，同时也是面试官大多想要得到的答案，就是快慢指针。
快指针pf(f就是fast的缩写)每次移动2个节点，慢指针ps(s为slow的缩写)每次移动1个节点，如果快指针能够追上慢指针，那就说明其中有一个环，否则不存在环。
这个方法的时间复杂度为O(n)，空间复杂度为O(1)，实际使用两个指针。
其实第三种解法存在问题，当一个存在环的链表足够长，而环足够小，那么会存在快指针永远不会追上慢指针的情况。快慢指针只适用于环出现在链表尾部的情况，也就是单链表环的问题，而无法解决链表存在循环的问题。
    * */


    //判断是否存在环（快慢两个指针）
    public boolean existCir(ListNode listNode){
        if(listNode==null)return false;
        ListNode fastnode=listNode;
        ListNode slownode=listNode;
        while(fastnode!=null){
            fastnode=fastnode.next.next;
            slownode=slownode.next;

            if(fastnode==slownode){
                System.out.println(countCir(listNode,slownode));
                return true;
            }

        }
        return false;
    }

    //环的节点数目
    public int countCir(ListNode listNode, ListNode slowNode){

        ListNode curNode=slowNode;
        int count=0;
        while(slowNode.next!=curNode){
            count=count+1;
            slowNode=slowNode.next;
        }
        return count+1;
    }

    public ListNode entreCir(ListNode listNode, int count){
        ListNode frontNode=listNode;
        ListNode curNode=listNode;
        for(int i=0;i<count;++i){
            frontNode=frontNode.next;
        }
        while(frontNode!=curNode){
            frontNode=frontNode.next;
            curNode=curNode.next;
        }
        return curNode;
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l7=new ListNode(7);
        ListNode l8=new ListNode(8);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l3;
        Solution23_1 s23=new Solution23_1();
        System.out.println(s23.entreCir(l1,6));
    }
}
