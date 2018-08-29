package com.stackatomc.OfferBook;

import java.util.Random;

/**
 * @File: Solution25
 * @Description: 复杂链表的复制
 * 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author: MayerFang
 * @Date: 2018/8/29 14:33
 * @Version: 1.0
 */

/*
* 1 a复制为a1，a1接在a后，一开始是只复制label值next
* 2 只有a1可以根据a确认位置，才可以对a的random也同步复制到a1
* 3 最后拆分a1和a，仅返回a1
*
*
* */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution25{
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)return null;
        RandomListNode plab=CloneNode(pHead);
        plab=CloneRandom(pHead,plab);
        plab=DecRandom(plab);
        return plab;
    }
    public RandomListNode CloneNode(RandomListNode pHead)
    {
        if(pHead==null)return null;
        RandomListNode plab=new RandomListNode(pHead.label);
        plab.next=CloneNode(pHead.next);
        pHead.next=plab;
        return pHead;//1 2 3(3)4(4)5(5)
    }
    public RandomListNode CloneRandom(RandomListNode pHead,RandomListNode plab){
        if(pHead==null||plab==null)return plab;
        if(pHead.random!=null)
            plab.random=pHead.random.next;
        CloneRandom(pHead.next.next,plab.next.next);
        return plab;
    }
    public RandomListNode DecRandom(RandomListNode plab){
        if(plab==null)return plab;
        plab.next=plab.next.next;
        DecRandom(plab.next);
        return plab;
    }

// 别人的答案
    public RandomListNode CloneE(RandomListNode pHead) {
            if(pHead == null) {
                return null;
            }

            RandomListNode currentNode = pHead;
            //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
            while(currentNode != null){
                RandomListNode cloneNode = new RandomListNode(currentNode.label);
                RandomListNode nextNode = currentNode.next;
                currentNode.next = cloneNode;
                cloneNode.next = nextNode;
                currentNode = nextNode;
            }

            currentNode = pHead;
            //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
            while(currentNode != null) {
                currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
                currentNode = currentNode.next.next;
            }

            //3、拆分链表，将链表拆分为原链表和复制后的链表
            currentNode = pHead;
            RandomListNode pCloneHead = pHead.next;
            while(currentNode != null) {
                RandomListNode cloneNode = currentNode.next;
                currentNode.next = cloneNode.next;
                cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
                currentNode = currentNode.next;
            }

            return pCloneHead;
        }


    public static void main(String[] args) {
        RandomListNode r1=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        RandomListNode r5=new RandomListNode(5);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;
        r1.random=r3;
        r2.random=r5;
        r4.random=r2;
        Solution25 s25=new Solution25();
        RandomListNode result=s25.CloneE(r1);
        while(result!=null){
            //if(result.random!=null)
                System.out.print(result.random.label+"     ");
            //else System.out.print("null"+"   ");
            result=result.next;
        }
    }
}