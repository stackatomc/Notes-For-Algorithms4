package com.stackatomc.OfferPractise;

/**
 * @File: Solution42_1
 * @Description: 回溯法解决正方形8个数字放到正方体8个顶点上
 * @Author: MayerFang
 * @Date: 2018/9/5 21:00
 * @Version: 1.0
 */
public class Solution42_1 {

    public boolean EightSq(int[] squares){
        if(squares==null)return false;
        return EightSq(squares,0);
    }

    public boolean EightSq(int[] squares,int i){
        if(i==squares.length)return false;
        if(!equalSquares(squares)){
            for(int j=i;j<squares.length;++j){
                swap(squares,i,j);
                EightSq(squares,i+1);
                swap(squares,i,j);
            }
        }else return true;
        return false;
    }
    public boolean equalSquares(int[] a){
        return ((a[0]+a[1]+a[2]+a[3])==(a[4]+a[5]+a[6]+a[7]))&&
                ((a[0]+a[2]+a[4]+a[6])==(a[1]+a[3]+a[5]+a[7]))&&
                ((a[0]+a[1]+a[4]+a[5])==(a[3]+a[4]+a[6]+a[7]));
    }

    public void swap(int[] squares,int i,int j){
        int temp=squares[i];
        squares[i]=squares[j];
        squares[j]=temp;
    }

    public static void main(String[] args) {
        Solution42_1 s42=new Solution42_1();
        int[] nums={4,4,4,4,4,4,4,4};
        System.out.println(s42.EightSq(nums));
    }
}
