package com.stackatomc.OfferPractise;

/**
 * @File: Solution15_1
 * @Description: 二进制中1的个数
 * @Author: MayerFang
 * @Date: 2018/9/1 22:09
 * @Version: 1.0
 */
public class Solution15_1 {

    // 思考
    // 本来以为1的位数与奇数或者是偶数有关，经过思考，只与最后一位是否为1有关所以判断奇数/偶数用(n&1)
    // 而1的个数仅仅是每一轮存储2的次方剩的余数，不管前面有几个1，都经过分解会乘2的倍数变为偶数，最后决定奇数或者是偶数的是最后一位数


    // 1. 不推荐的做法，无法处理当n为负数时无限向右移会引起死循环，因为左边置为1
    public int counOne(int n){
        int count=0;
        while(n!=0){
            if((n&1)==1){ //仅仅是判断其中有几个1存在，用1做与操作
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    // 2. 常规解法,需要循环32次
    public int countOne2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0){ //仅仅是判断其中有几个1存在，用1做与操作
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    //3.  另一种二进制的运用，对该值减1与原值进行与操作，可逐次将原值右边单个1置为0
    //用该性质进行迭代操作
    public int countOne3(int n){
        if(n==0)return 0;
        int count=0;
        while(n!=0){
            n=n&(n-1);//经过思考，负数也是
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution15_1 s15=new Solution15_1();
        System.out.println(s15.countOne3(13));
    }

}
