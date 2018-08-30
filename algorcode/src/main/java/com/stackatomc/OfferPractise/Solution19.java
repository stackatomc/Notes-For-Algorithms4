package com.stackatomc.OfferPractise;

import java.util.ArrayList;
import java.util.List;

/**
 * @File: Solution19
 * @Description: 顺时针打印矩阵
 * 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author: MayerFang
 * @Date: 2018/8/26 21:28
 * @Version: 1.0
 */
public class Solution19 {


    /*
    * 4*4
    * 1 2 3 4
    * 5 6 7 8
    * 9 10 11 12
    * 13 14 15 16
    *
    *
    * */

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        return printMatrix(matrix,arrayList);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix, ArrayList<Integer> array) {
        if(matrix==null)return null;

        for(int j=0;j<matrix[0].length;++j){
            array.add(matrix[0][j]);
            System.out.print(matrix[0][j]+",");
        }
        //一个超级勉强的完成。这里要注意会打印重复的问题
        if(matrix.length==1) return array;
        for(int i=1;i<=matrix.length-1-1;++i){
            array.add(matrix[i][matrix[0].length-1]);
            System.out.print(matrix[i][matrix[0].length-1]+",");
        }

        for(int k=matrix[0].length-1;k>=0;--k){
            array.add(matrix[matrix.length-1][k]);
            System.out.print(matrix[matrix.length-1][k]+",");
        }
        if(matrix[0].length==1) return array;
        for(int l=matrix.length-1-1;l>=1;--l){
            array.add(matrix[l][0]);
            System.out.print(matrix[l][0]+",");
        }

        if(matrix.length-2<=0||matrix[0].length-2<=0) return array;
        int[][] tma=new int[matrix.length-2][matrix[0].length-2];
        for(int i=0;i<=tma.length-1;++i){
            for(int j=0;j<=tma[0].length-1;++j){
                tma[i][j]=matrix[i+1][j+1];
            }
        }
        printMatrix(tma,array);

        return array;
    }

    public static void main(String[] args) {
        int[][] maxt={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(maxt);
    }
}
