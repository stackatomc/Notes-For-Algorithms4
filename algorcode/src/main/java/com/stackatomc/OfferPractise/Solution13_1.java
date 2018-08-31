package com.stackatomc.OfferPractise;

/**
 * @File: Solution13_1
 * @Description: 回溯法
 * @Author: MayerFang
 * @Date: 2018/8/31 21:08
 * @Version: 1.0
 */
public class Solution13_1 {

    public int movingCount(int k,int[][] array){
        if(k<0||array.length==-1)return 0;
        boolean[][] visited=new boolean[array.length][array[0].length];
        int count=movingCountCore(k,array,0,0,visited);
        return count;
    }

    int movingCountCore(int k,int[][] array,int col,int row,boolean[][] visited){
        int count=0;
        if(check(k,array,row,col,visited)){
            visited[row][col]=true;
            count=1+movingCountCore(k,array,row-1,col,visited)+
                    movingCountCore(k,array,row+1,col,visited)+
                    movingCountCore(k,array,row,col-1,visited)+
                    movingCountCore(k,array,row,col+1,visited);
        }
        return count;
    }

    boolean check(int k,int[][]array,int row,int col,boolean[][] visited){
        if(row>=0&&row<array.length&&col>=0&&col<array[0].length&&isMin(row,col)<k&&!visited[row][col]){
            return true;
        }
        return false;
    }
    public int isMin(int i,int j){
        return i/10+i%10+j/10+j%10;
    }

}
