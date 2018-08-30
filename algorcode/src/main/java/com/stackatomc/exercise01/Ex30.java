package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex30
 * @Description
 * @date 2018/8/22
 */
public class Ex30 {

//    16 14
//    q=2 p=14
//    q=7 p=2
//    q=1 p=2
//    q=0 return p=2

    public static int gdc(int q,int p){
        if(q==0) return p;
        q=q%p;//7
        return gdc(p,q);
    }

    public static void isDivided(int a,int b){
        if((a/b==1)&&(b/a==1)){
            System.out.print("true");
        }else System.out.print("false");
    }
    public static void main(String[] args) {
        int[][] a={{1,2,3,5},{3,2,1,5},{2,3,5,1},{2,3,5,4}};
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a[0].length;++j)
                isDivided(a[i][j],a[j][i]);
            System.out.println();
        }
    }
}
