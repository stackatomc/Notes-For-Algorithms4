package com.stackatomc.OfferPractise;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @File: Solution18_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/3 19:06
 * @Version: 1.0
 */
public class Solution18_1 {

    // 模仿数字排列的全排列实现
    public ArrayList<String> permutation(String str){
        String[] strs=str.split("");
        ArrayList<String> arrayList=new ArrayList<String>();
        if((str.trim()).length()==0){
            arrayList.add(new String(str));
            return arrayList;}

        // 初始化sb打印
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;++i){
            sb.append(strs[0]);
        }



        //通过全排列实现
//        for(int i=0;i<strs.length;++i){
//            sb.replace(0,1,strs[i]);
//            arrayList=PrintRestStrs(sb,strs,1,arrayList);
//        }

        // 也可以简化成以下一句即可，但是
        arrayList=PrintRestStrs(sb,strs,0,arrayList);
        return arrayList;
    }

    public ArrayList<String> PrintRestStrs(StringBuilder sb, String[] strs, int index, ArrayList<String> arrayList){

        if(index==sb.length()){
            arrayList.add(sb.toString());
            System.out.println(sb.toString());
            return arrayList;
        }
//看能否合二为一
        for(int i=0;i<strs.length;++i){
            sb.replace(index,index+1,strs[i]);
            PrintRestStrs(sb,strs,index+1,arrayList);
        }
        return arrayList;

//        int j=sb.length()-1;
//        int k=0;
//        while(k<strs.length){// 该实现也是O(n^2)
//            sb.replace(j,j+1,strs[k]);
//            j=j-1;
//            if(j==0){
//                arrayList.add(sb.toString());
//                System.out.println(sb.toString());
//                j=sb.length()-1;
//            }
//        }
    }

    public ArrayList<String> permutation2(String str){
        System.out.println(str.length());
        if(str==null)return null;
        String[] strs=str.split("");
        Queue<StringBuilder> q=new LinkedList<StringBuilder>();
        ArrayList<String> aq=new ArrayList<String>();

        if((str.trim()).length()==0){
            aq.add(str);
            return aq;}
        q.offer(new StringBuilder());
        aq=PrintRestStrs2(q,strs,aq);
        return aq;
    }

    public ArrayList<String> PrintRestStrs2(Queue<StringBuilder> q,String[] strs,ArrayList<String> arrayList){
        while((q.peek()).length()<=strs.length){
            StringBuilder curValue=q.poll();
            System.out.println(curValue);
            // 对String类型空的判断
            //if(!(curValue.toString().equals("")))
            arrayList.add(curValue.toString());

            for(int i=0;i<strs.length;++i){
                q.offer(new StringBuilder(curValue.append(strs[i])));
                // 注意加入队列的是一个StringBuilder的对象，而此处curValue是一个引用随之改变
                curValue.delete(curValue.length()-1,curValue.length());
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Solution18_1 s18=new Solution18_1();
        System.out.println(s18.permutation(""));
    }
}
