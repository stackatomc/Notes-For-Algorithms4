package com.stackatomc.OfferPractise;

/**
 * @File: Solution4_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/31 0:14
 * @Version: 1.0
 */

class ListNode1{
    int val=0;
    ListNode1 left=null;
    ListNode1 right=null;
    ListNode1 parent=null;
    public ListNode1(int val){
        this.val=val;
    }
}
public class Solution4_1 {

    public int nextNode(ListNode1 listnode){
        ListNode1 result=listnode;
        if(listnode.parent==null){
            //listnode是头结点
            if(result.right!=null){
                result=listnode.right;
                while(result.left!=null){
                    result=result.left;
                }return result.val;
            }else{
                return -1;
            }
        }else{
            //listnode不是头结点
            if(result.right!=null){
                result=listnode.right;
                while(result.left!=null){
                    result=result.left;
                }
                return result.val;
            }else{
                result=listnode.parent;
                if(result.left==listnode){
                    return result.val;
                }else{
                    if(result.parent!=null){
                        return result.parent.val;
                    }else{
                        return -1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode1 listNode1=new ListNode1(1);
        ListNode1 listNode2=new ListNode1(2);
        ListNode1 listNode3=new ListNode1(3);
        ListNode1 listNode4=new ListNode1(4);
        ListNode1 listNode5=new ListNode1(5);
        listNode1.left=listNode2;
        listNode2.parent=listNode1;
        listNode1.right=listNode3;
        listNode3.parent=listNode1;
        listNode2.right=listNode4;
        listNode4.parent=listNode2;
        listNode4.left=listNode5;
        listNode5.parent=listNode4;
        Solution4_1 s41=new Solution4_1();
        System.out.println(s41.nextNode(listNode4));
    }
}
