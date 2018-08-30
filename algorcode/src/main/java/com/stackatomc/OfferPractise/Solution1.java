package com.stackatomc.OfferPractise;

/**
 * @File: Solution1
 * @Description: 二维数组中的查找
 * 题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author: MayerFang
 * @Date: 2018/8/30 20:31
 * @Version: 1.0
 */
public class Solution1 {

    /*
    * 0 1 //3 5
    * 1 5 //6 9
    * //3 7 //8 9
    * */

    //二维数组第一次尝试
    public boolean Find(int target,int[][] array){
        if(array.length==-1)return false;
        int i=0;
        int j=0;
        int jmax=array[0].length;
        int imax=array.length;
        while(j<array[0].length){
            if(target<array[i][j]){
                jmax=j;
                j=array[0].length;
            }else if(target==array[i][j]){
                return true;
            }
            j=j+1;
        }
        j=0;
        while(i<array.length){
            if(target<array[i][j]){
                 imax=i;
                 i= array.length;
            }else if(target==array[i][j]){
                return true;
            }
            i=i+1;
        }
        for(i=0;i<imax;++i){
            for(j=0;j<jmax;++j){
                if(target==array[i][j])
                    return true;
            }
        }
        return false;
    }

    // 二维数组修改后，思想同一维数组
    public boolean Find2(int target,int[][]array){
        if(array.length==-1)return false;
        int i=0,j=array[0].length-1;
        while(i<array.length&&j>=0&&j<array[0].length){
            if(array[i][j]>target){
                j=j-1;
            }else if(array[i][j]==target){
                return true;
            }else{
                i=i+1;
            }
        }
        return false;
    }

    // 一维数组进行查找
    public boolean Find(int target,int[] array,int columns,int rows){

        if(array.length==-1)return false;
        int row=0;
        int column=columns-1;
        while(row<rows&&column>=0) {
            if (array[row * columns + column] > target) {
                column = column - 1;
            } else if (array[row * columns + column] == target) {
                return true;
            } else {
                row = row + 1;
            }
        }
        return false;
    }

        /*1 3 5 6
        * 2 5 8 10
        * */
    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        int[][] mn={{1,3,5,6},{2,5,8,10}};
        int[] m={1,3,5,6,2,5,8,10};
        System.out.println(s1.Find2(7,mn));
    }

}
