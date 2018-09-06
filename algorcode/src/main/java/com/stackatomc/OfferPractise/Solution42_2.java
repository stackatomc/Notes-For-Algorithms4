package com.stackatomc.OfferPractise;

/**
 * @File: Solution42_2
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/5 23:29
 * @Version: 1.0
 */
public class Solution42_2 {

    public int[][] EightQueen(){

        int[][] EightTable=new int[8][8];
        //对角线上置为1
        for(int i=0;i<EightTable.length;++i){
            EightTable[i][i]=1;
        }
        int[][] E={{0,0,0,0,0,0,0,1},{0,0,0,1,0,0,0,0},{1,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,0,0,1,0,0,0}};

        return isQueen(E,1,0);
    }

//变行不变列
    public int[][] isQueen(int[][] EnghtTable,int index,int j1) {
        if ( j1 >= 0 && j1 < EnghtTable[0].length && index >= 0 && index < EnghtTable.length) {
            if (!isSame(EnghtTable)) {
                for (int i = 0; i < EnghtTable.length; ++i) {
                    if (EnghtTable[i][j1] == 1) {
                        int t=index;
                        for(int j=0;j<EnghtTable[0].length;++j){
                            if(EnghtTable[index][j]==1){
                                swap(EnghtTable,i,j1,index,j);
                                int[][] result=isQueen(EnghtTable,t+1,j1+1);
                                if(result!=null)return result;
                                System.out.println("换回来了");
                                swap(EnghtTable,i,j1,index,j);
                                j=0;
                                if(index>=EnghtTable.length-1)return null;
                                else
                                {
                                    System.out.println("该列向下继续找");
                                    index=index+1;
                                }

                            }
                        }
                    }
                }
            } else {
                return EnghtTable;
            }
        }
        return null;
    }

    public void swap(int[][] EnghtTable,int i1,int j1,int i2,int j2){
        System.out.println("=====");
        System.out.println("swap():("+i1+","+j1+")("+i2+","+j2+")");

        int temp=EnghtTable[i1][j1];
        EnghtTable[i1][j1]=EnghtTable[i2][j1];
        EnghtTable[i2][j1]=temp;

        int temp2=EnghtTable[i2][j2];
        EnghtTable[i2][j2]=EnghtTable[i1][j2];
        EnghtTable[i1][j2]=temp2;


        System.out.println("====");
        for(int i=0;i<EnghtTable.length;++i){
            for(int j=0;j<EnghtTable [0].length;++j)
                System.out.print(EnghtTable[i][j]);
            System.out.println();
        }
        System.out.println("====");
    }

    public boolean isSame(int[][] EnghtTable){
        //判断Z字
        for(int i=0;i<EnghtTable.length;++i){
            for(int j=0;j<EnghtTable[0].length;++j){
                if(EnghtTable[i][j]==1){
                    EnghtTable[i][j]=2;
                    if(!Zboolean(EnghtTable,i,j)){
                        EnghtTable[i][j]=1;
                        return false;
                    }
                    else EnghtTable[i][j]=1;
                    break;
                }
            }
        }
        return true;
    }

    public boolean Zboolean(int[][] EnghtTable,int i,int j){
        if(i<0||i>=EnghtTable.length||j<0||j>=EnghtTable[0].length)
            return true;
        boolean resulttemp=true;
        while(i>=0&&i<EnghtTable.length-1&&j>=0&&j<EnghtTable[0].length-1){
            resulttemp=isZ(EnghtTable,++i,++j);
        }
        if(!resulttemp)return resulttemp;
        while(i>0&&i<=EnghtTable.length-1&&j>=0&&j<EnghtTable[0].length-1){
            resulttemp=isZ(EnghtTable,--i,++j);
        }
        if(!resulttemp)return resulttemp;
        while(i>=0&&i<EnghtTable.length-1&&j>0&&j<=EnghtTable[0].length-1){
            resulttemp=isZ(EnghtTable,++i,--j);
        }
        if(!resulttemp)return resulttemp;
        while(i>0&&i<=EnghtTable.length-1&&j>0&&j<=EnghtTable[0].length-1){
            resulttemp=isZ(EnghtTable,--i,--j);
        }
        return resulttemp;
    }

    public boolean isZ(int[][] EnghtTable,int i,int j){
        int a=EnghtTable[i][j];
        if(a==1){
            return false;
        }else{
            return true;
        }

    }



    public static void main(String[] args) {
        Solution42_2 s42=new Solution42_2();
        System.out.println();
        int[][] r=s42.EightQueen();
        if(r==null) System.out.println(r);
//        for(int i=0;i<r.length;++i){
//            for(int j=0;j<r [0].length;++j)
//                System.out.print(r[i][j]);
//            System.out.println();
//        }
    }
}
