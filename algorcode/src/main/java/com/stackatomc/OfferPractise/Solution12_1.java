package com.stackatomc.OfferPractise;

import java.util.Arrays;
import java.util.Stack;

/**
 * @File: Solution12_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/31 15:41
 * @Version: 1.0
 */
public class Solution12_1 {

    public boolean existStr(char[] c,char[][] chars){
        if(c==null||chars==null)return false;
        Stack<Integer[]> sc=new Stack<Integer[]>();
        int[][] index=new int[chars.length][chars[0].length];
        int start=0;
        for(int i=0;i<chars.length;++i){
            for(int j=0;j<chars[0].length;++j){
                if(chars[i][j]==c[start]){
                    System.out.println(chars[i][j]);
                    sc.push(new Integer[]{i,j});
                    start=start+1;
                    boolean existnext=true;
                    Integer[] curIndex=sc.peek();
                    while(start<=c.length-1&&!sc.empty()&&i>=0&&i<chars.length&&j<chars[0].length){
                        existnext=false;
                        System.out.println(existnext);
                        if(i+1<chars.length&&chars[i+1][j]==c[start]&&!(i+1==curIndex[0]&&j==curIndex[1])&&index[i+1][j]==0){
                            i=i+1;
                            existnext=true;
                        }else if(i-1>=0&&chars[i-1][j]==c[start]&&!(i-1==curIndex[0]&&j==curIndex[1])&&index[i-1][j]==0){
                            i=i-1;
                            existnext=true;
                        }else if(j-1>=0&&chars[i][j-1]==c[start]&&!(i==curIndex[0]&&j-1==curIndex[1])&&index[i][j-1]==0){
                            j=j-1;
                            existnext=true;
                        }else if(j+1<chars[0].length&&chars[i][j+1]==c[start]&&!(i==curIndex[0]&&j+1==curIndex[1])&&index[i][j+1]==0){
                            j=j+1;
                            existnext=true;
                        }
                        if(existnext==true){
                            sc.push(new Integer[]{i,j});
                            index[i][j]=1;
                            start=start+1;
                        }else if(existnext==false&&!sc.empty()){
                            curIndex=sc.pop();
                            index[i][j]=0;
                            if(!sc.empty()){
                                Integer[] oldIndex=sc.peek();
                                i=oldIndex[0];
                                j=oldIndex[1];
                            }
                            start=start-1;
                        }
                    }
                    if(start==c.length){
                            return true;
                    }
                    for(int k=0;k<index.length;++k){
                        for(int l=0;l<index[0].length;++l){
                            index[k][l]=0;
                        }
                    }start=0;
                }
            }
        }return false;
    }
    // 回溯法
    public boolean existStr2(char[] c,char[][] chars){
        if(chars==null)return false;
        boolean[][] visited=new boolean[chars.length][chars[0].length];
        int start=0;
        boolean result=false;
        for(int i=0;i<chars.length;++i){
            for(int j=0;j<chars[0].length;++j){
                if(chars[i][j]==c[start])
                    result=existStrCore(c,chars,0,i,j,visited);
                if(result)
                    return result;
            }
        }
        return existStrCore(c,chars,0,0,0,visited);
    }

    boolean existStrCore(char[] c,char[][] chars,int start,int row,int col,boolean[][] visited){

        if(start>=0&&start<c.length&&row>=0&&row<chars.length&&col>=0&&col<chars[0].length){
            if(chars[row][col]==c[start]&&!visited[row][col])
            {
            System.out.println(c[start]);
            visited[row][col]=true;
            boolean result=existStrCore(c,chars,start+1,row+1,col,visited)||
                    existStrCore(c,chars,start+1,row-1,col,visited)||
                    existStrCore(c,chars,start+1,row,col+1,visited)||
                existStrCore(c,chars,start+1,row,col-1,visited);
            return result;
            }else{
                visited[row][col]=false;
            }
        }else if(start>=c.length){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution12_1 s12=new Solution12_1();
        char[] carr={'s','s','r'};
        char[][] charsarr={{'c','s','d'},{'r','s','d'}};
        System.out.println(s12.existStr2(carr,charsarr));
    }
}
