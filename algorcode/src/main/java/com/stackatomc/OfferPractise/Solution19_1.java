package com.stackatomc.OfferPractise;

/**
 * @File: Solution19_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/4 20:57
 * @Version: 1.0
 */
public class Solution19_1 {

    public boolean match(char[] str,char[] pattern){
        if(pattern==null){
            return false;
        }
        //.*? 0001 0*01
        int i=0,j=0;
        while(i<str.length){
            if(str[i]==pattern[j]){
                if(pattern[j+1]=='*'){
                    j=j+2;
                    while(str[i]==pattern[j]){
                        i=i+1;
                        j=j+1;
                    }
                }
                    while(str[i+1]!=str[i]){
                        i=i+1;
                    }
                }else{
                    i=i+1;
                    j=j+1;
                }
            }else if(str[i]!=pattern[j]){
                if(pattern[j]=='.'){
                    i=i+1;
                    j=j+1;
                }else if(pattern[j+1]=='?'){
                    j=j+2;
                }else if(pattern[j+1]=='*'){
                    j=j+2;
                }else{
                    return false;
                }
            }
        }
}
