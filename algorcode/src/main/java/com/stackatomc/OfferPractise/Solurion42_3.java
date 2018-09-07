package com.stackatomc.OfferPractise;

/**
 * @File: Solurion42_3
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/7 17:21
 * @Version: 1.0
 */
public class Solurion42_3 {


    public int[] buildChess(){

        int[] empty=new int[8];
        for(int i=0;i<empty.length;++i){
            empty[i]=i;
        }
        return processing(empty,0);
    }

    public int[] processing(int[] chess,int i){
        if(i>=0&&i<chess.length){
            if(!isBuilded(chess)){
                //当前不满足，要交换
                for(int j=i+1;j<chess.length;++j){
                    swap(chess,i,j);
                    if(processing(chess,i+1)!=null){
                        return chess;
                    }else swap(chess,i,j);
                }
            }else{
                return chess;
            }
        }
        return null;
    }

    public void swap(int[] chess,int i,int j){
        int temp=chess[i];
        chess[i]=chess[j];
        chess[j]=temp;
    }

    public boolean isBuilded(int[] chess){
        for(int i=0;i<chess.length;++i){
            for(int j=i+1;j<chess.length;++j){
                if(((i-j)==(chess[i]-chess[j]))||((j-i)==(chess[i]-chess[j])))
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solurion42_3 s43=new Solurion42_3();
        int[] result=s43.buildChess();
        if(result!=null)
            for(int i:result){
                System.out.print(i+",");
            }
    }
}
