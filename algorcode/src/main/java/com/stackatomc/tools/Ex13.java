package com.stackatomc.tools;

/**
 * @author MayerFang
 * @file Ex13
 * @Description
 * @date 2018/8/21
 */
public class Ex13 {


    /*
    *   0 1 2
    * 0
    * 1
    * 2
    * 3
    *
    *   0 1 2 3
    * 0
    * 1
    * 2
    *
    * */
    public static void  reversedMatrix(int[][] arr){
        System.out.print("  ");
        for(int i=0;i<arr.length;++i){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i=0;i<arr[0].length;++i){
            System.out.print(i+" ");
            for(int j=0;j<arr.length;++j){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array={{1,2,3},{2,3,4},{3,4,5},{4,5,6}};
        reversedMatrix(array);
    }

}
