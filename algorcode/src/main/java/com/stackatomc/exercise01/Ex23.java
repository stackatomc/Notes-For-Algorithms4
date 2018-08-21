package com.stackatomc.exercise01;

import java.util.Scanner;

/**
 * @author MayerFang
 * @file Ex23
 * @Description
 * @date 2018/8/21
 */
public class Ex23 {

    public static int rank(int key, int[] a)
    {   int count=0;
        return rank(key, a, 0, a.length - 1);  }
    public static int rank(int key, int[] a, int lo, int hi)
    {  //如果key存在于a[]中，它的索引不会小于lo且不会大于hi
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else                   return mid;
    }

    public static int printBoard(int[] board,String key){
        return rank(Integer.parseInt(key.trim()),board);
    }


    public static void main(String[] args) {
        int[] board={2,4,5,6,22,66};
        Scanner sc=new Scanner(System.in);
        System.out.println("+ / - : ");
        String Sign=sc.nextLine();
        String[] keys=sc.nextLine().split(" ");
        for(int i=0;i<keys.length;++i){
            System.out.println(keys[i]);
        }

        if(Sign.equals("+")){
            for(int i=0;i<keys.length;++i){
                if(printBoard(board,keys[i])==-1) System.out.print(keys[i]);
            }//输出不在白名单上的
        }else{
            for(int i=0;i<keys.length;++i){
                if(printBoard(board,keys[i])!=-1) System.out.print(keys[i]);
            }//输出在白名单上的
        }


    }
}