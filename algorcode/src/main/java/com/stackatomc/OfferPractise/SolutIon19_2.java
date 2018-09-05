package com.stackatomc.OfferPractise;

/**
 * @File: SolutIon19_2
 * @Description: 判断是否为标准数字
 * @Author: MayerFang
 * @Date: 2018/9/5 9:57
 * @Version: 1.0
 */
public class SolutIon19_2 {

    public boolean isNumeric(char[] chars){
        if(chars==null)return false;
        int i=0;
        if(chars[0]=='.'){
            return MinToZero(chars,i+1,chars.length-1);
        }
        for(;i<chars.length;++i){
            if(chars[i]=='.'){
                return MaxToZero(chars,0,i-1)&&MinToZero(chars,i+1,chars.length-1);
            }
        }
        return false;
    }

    // 正数
    public boolean MaxToZero(char[] chars,int i,int j){
        if(chars[j]=='*'||chars[j]=='-')
            return false;
        if(chars[i]=='+'||chars[i]=='-')
            i=i+1;
        while(i<=j){
            if((chars[i]-'0')>9||(chars[i]-'0')<0)
                return false;
            i=i+1;
        }
        return true;
    }

    // 小数
    public boolean MinToZero(char[] chars,int i,int j){
        if(chars[i]=='+'||chars[i]=='-')
            return false;
        boolean isE=true;
        while(i<=j){
            if(chars[i]=='e'||chars[i]=='E'){
                isE=MaxToZero(chars,i+1,j);
                i=i+1;
            }
            if((chars[i]-'0')>9||(chars[i]-'0')<0)
                return false;
            i=i+1;
        }

        return isE;
    }

    // eC|EC
    public boolean isEc(char[] chars,int i,int j){
        if(chars[j]=='*'||chars[j]=='-')
            return false;
        if(chars[i]=='+'||chars[i]=='-'){
            i=i+1;
        }
        while(i<=j){
            if((chars[i]-'0')>9||(chars[i]-'0')<0)
                return false;
            i=i+1;
        }
       return true;
    }

    //判断正负号

    //判断正数

    public static void main(String[] args) {
        SolutIon19_2 s12=new SolutIon19_2();
        char[] c={'.','2','E','3'};
        System.out.println(s12.isNumeric(c));
    }

}
