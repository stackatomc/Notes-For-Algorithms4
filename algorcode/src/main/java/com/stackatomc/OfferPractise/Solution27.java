package com.stackatomc.OfferPractise;

import java.util.ArrayList;

/**
 * @File: Solution27
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/29 17:19
 * @Version: 1.0
 */
public class Solution27 {

        public static ArrayList<String> Permutation(String str) {
            String strs[]=str.split("");
            StringBuilder stringBuilder=new StringBuilder();
            for(int weishu=0;weishu<strs.length;++weishu){
                for(int i=0;i<strs.length;++i){
                    stringBuilder.append(strs[i]);
                }
                for(int j=0;j<strs.length;++j)
                        stringBuilder.append(strs[j]);
                }

            int length=strs.length;

            ArrayList<String> arrayList=new ArrayList<String>();
            arrayList.add(strs[0]);
            return arrayList;
        }

        public static void main(String[] args) {
            Permutation("abc");
        }
}
