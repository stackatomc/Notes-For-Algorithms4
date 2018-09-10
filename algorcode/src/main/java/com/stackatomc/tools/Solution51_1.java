package com.stackatomc.tools;

/**
 * @author MayerFang
 * @file Solution51_1
 * @Description 最大堆解决取前k个最小值 O(nlogk) 适合海量数据 基于堆或者红黑树的排序搜索解法 优于快速查找法
 * @date 2018/9/10
 */
public class Solution51_1 {

    // 最大堆解决取前k个最小值 O(nlogk)
    public int[] getknums(int[] num,int k){

        if(num==null||k<=0)return null;

        if(num.length<k)
            return null;

        if(num.length==k)return num;

        // 初始化
        int knums[]=new int[k];
        for(int i=0;i<k;++i){
            knums[i]=num[i];
        }
        //做最大堆调整
        maxheapadjust(knums,0);

        for(int i=k;i<num.length;++i){
            if(num[i]<knums[0]){
                knums[0]=num[i];
                maxheapadjust(knums,0);
            }
        }
        return knums;
    }


    public void maxheapadjust(int[] arr,int i){

        int index=i;
        int left=2*i+1;
        int right=2*i+2;


        System.out.println(index);
        System.out.println(left);
        System.out.println(right);
        System.out.println();
        if(left<arr.length-1&&arr[index]<arr[left]){
            index=left;
        }
        if(right<arr.length-1&&arr[index]<arr[right]){
            index=right;
        }

        if(index!=i){
            int temp=arr[i];
            arr[i]=arr[index];
            arr[index]=temp;
            maxheapadjust(arr,index);
        }else{
            return ;
        }
    }

    public static void main(String[] args) {

        int[] ks={2,5,3,1,2,3,53,6,2};
        Solution51_1 s51=new Solution51_1();
        int[] result=s51.getknums(ks,4);
        for(int r:result){
            System.out.print(r+",");
        }
    }
}
