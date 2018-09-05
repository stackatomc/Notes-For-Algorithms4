package com.stackatomc.OfferPractise;

/**
 * @File: Solution19_1
 * @Description: 正则表达式匹配
 * @Author: MayerFang
 * @Date: 2018/9/4 20:57
 * @Version: 1.0
 */
public class Solution19_1 {

    public boolean match(char[] str, char[] pattern) {
        if (pattern == null) {
            return false;
        }
        return matcher(str,0,pattern,0);
    }

    public boolean matcher(char[] str,int i,char[] pattern,int j){
        if (i == str.length && j == pattern.length)
            return true;
        if(j==pattern.length&&i!=str.length)
            return false;

        //可能str完pattern还有，如*
        if(j+1<pattern.length&&pattern[j+1]=='*'){
            if(i==str.length)return matcher(str,i,pattern,j+2);//通过对情况进行判断，避免数组访问溢出
            else if((str[i]==pattern[j])||(pattern[j]=='.'&&str[i]!='\0')){
                return matcher(str,i+1,pattern,j+2)||
                        matcher(str,i+1,pattern,j)||
                        matcher(str,i,pattern,j+2);
            }else return matcher(str,i,pattern,j+2);
        }else{
            if(i==str.length)return false;
            else if(str[i]==pattern[j]||(pattern[j]=='.'&&str[i]!='\0'))
                return matcher(str,i+1,pattern,j+1);
            else return false;
        }
    }

    public static void main(String[] args) {
        Solution19_1 s1=new Solution19_1();
        char[] chars={'w','w','w'};
        char[] pattenrs={'w','w','w','*'};
        System.out.println(s1.match(chars,pattenrs));
    }
}

