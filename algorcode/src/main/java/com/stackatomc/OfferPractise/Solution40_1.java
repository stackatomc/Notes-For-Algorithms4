package com.stackatomc.OfferPractise;

import java.util.HashMap;

/**
 * @File: Solution40_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/6 23:07
 * @Version: 1.0
 */
public class Solution40_1 {
    public int[] minsK(int[] arrs,int k){
        if(arrs==null||k<0)return null;

        int[] result=new int[k];

        int min=quicks(arrs,0,arrs.length-1);

        while((min+1)!=k&&min!=-1){
            if((min+1)<k)
                min=quicks(arrs,min+1,arrs.length-1);
            if((min+1)>k)
                min=quicks(arrs,0,min-1);
        }
        if(min==-1)return null;
            for(int i=0;i<=min;++i){
                result[i]=arrs[i];
            }
            return result;

    }

    public int quicks(int[] arrs,int start,int end){
        if(arrs==null)return -1;
        int val=arrs[0];
        int start1=start;
        int end1=end;
        while(start1<end1){
            while(start1<end1&&arrs[end1]>=val){
                end1=end1-1;
            }
            arrs[start1]=arrs[end1];
            while(start1<end1&&arrs[start1]<val){
                start1=start1+1;
            }
            arrs[end1]=arrs[start1];
        }
        return start1;
    }

    // 通过二叉树实现
    public int getKnums(int[] arrs,int k){
        if(arrs==null||k<0)return -1;
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        ListNode first=new ListNode(arrs[0]);
        ListNode head=first;
        for(int i=1;i<arrs.length;++i){

            if(hashMap.size()<k){
                if(hashMap.containsKey(arrs[i])){
                    int values=hashMap.get(arrs[i]);
                    hashMap.put(arrs[i],values+1);
                    k=k-1;//要做个膝盖
                    break;
                }else{
                    hashMap.put(arrs[i],1);
                    head=AddNode(first,arrs[i]);
                }
            }else{
                if(head.val>arrs[i]){

                }else if(head.val==arrs[i]){
                    int nums=hashMap.get(arrs[i]);
                    head=remove(head);
                    if(nums==1)
                        hashMap.remove(arrs[i]);
                    else
                        hashMap.put(arrs[1],nums-1);
                }
            }
        }
    }
    public ListNode AddNode(ListNode head,int val){
        ListNode maxhead=head;
        ListNode listNode=new ListNode(val);
        if(val>maxhead.val){
            listNode.next=maxhead;
            return listNode;
        }else{
            while(val<maxhead.val&&maxhead.next!=null){
                maxhead=maxhead.next;
            }
            maxhead.next=listNode;
            return head;
        }
    }

    public ListNode removeNode(ListNode head){
        ListNode oldhead=head;
        ListNode newhead=oldhead.next;
        return newhead;
    }

    public int maxTree(TreeNode head){
        if(head!=null)
            return head.val;
        return -1;
    }


    public static void main(String[] args) {
        Solution40_1 s4=new Solution40_1();
        int[] a={4,5,3,2,1,7,3,2};
        int[] r=s4.minsK(a,4);
        for(int i=0;i<r.length;++i){
            System.out.print(r[i]+",");
        }
    }
}
