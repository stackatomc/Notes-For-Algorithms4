package com.stackatomc.OfferPractise;

import java.util.Arrays;

/**
 * @File: Solution2
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/30 21:38
 * @Version: 1.0
 */
public class Solution2 {

    // String.split 切分后实现
    public String replaceSpace(StringBuffer str){
        if(str==null)return null;
        String strings=str.toString();
        String[] strs=strings.split(" ");

        System.out.println(str.capacity());
        System.out.println(strings.length());
        str.delete(0,str.capacity());// 清空原数据
        //str.delete(0,str.length()-1); //如果是str.length()-1则最后一个不会被删除

        for(int i=0;i<strs.length-1;++i){
            str.append(strs[i]);
            str.append("%20");
        }
        str.append(strs[strs.length-1]);
        return str.toString();
    }

    // StringBuffer replace 实现
    public String replaceSpace2(StringBuffer str){
        if(str==null)return null;
        for(int i=0;i<str.length();++i){
            char c=str.charAt(i);
            if(c==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    // char[] 对数组扩容计算结合两个“指针”进行定位
    public char[] replaceSpace(char[] str){
        if(str.length==-1)return null;
        int count=0;
        for(int i=0;i<str.length;++i){
            if(str[i]==' ')
                count=count+1;
        }
        int oldindex=str.length-1;
        System.out.println("count:"+count);
        System.out.println("oldindex:"+oldindex);
        str=Arrays.copyOf(str,str.length+count*2);
        int newindex=str.length-1;
        System.out.println("newindex:"+newindex);

        while(oldindex>=0) {
            if (str[oldindex] != ' ') {
                str[newindex] = str[oldindex];
                oldindex = oldindex - 1;
                newindex = newindex - 1;
            }else{
            oldindex=oldindex-1;
            str[newindex]='0';
            str[newindex-1]='2';
            str[newindex-2]='%';
            newindex=newindex-3;}
        }
        return str;
    }

    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        //System.out.println(s2.replaceSpace(new StringBuffer("We Are Happy")));
        char[] str={'W','e',' ','A','r','e',' ','H','a','p','p','y'};
        System.out.println(s2.replaceSpace(str));
    }
}
