package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex11
 * @Description
 * @date 2018/8/21
 */
public class Ex11 {

    /*
    *
    * 实现了打印行号和列号
    *
    *   0 1 2 3 4
    * 0
    * 1
    * 2
    * 3
    * 4
    *
    * */
    public static void printBooleanNum(boolean[][] a) {

        /* 打印列号 */
        System.out.print("  ");
        for(int i=0;i<a[0].length;++i)
            System.out.print(i+" ");
        System.out.println();

        for(int i=0;i<a.length;++i){
            System.out.print(i+" ");
            for(int j=0;j<a[0].length;++j){
                isEmpty(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void isEmpty(boolean b){
        if(b==true){
            System.out.print("* ");
        }else{
            System.out.print("- ");
        }
    }

    public static void main(String[] args) {
        boolean [][] a={{true,true,true},{false,false,true},
                {false,true,true},{false,false,true}};
        printBooleanNum(a);
    }
}
