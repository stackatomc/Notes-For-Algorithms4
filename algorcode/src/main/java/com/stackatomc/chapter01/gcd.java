package com.stackatomc.chapter01;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Description: Calculate the greatest common divisor gcd is
 * @User: stackc
 * @Date: 2018/7/21 0:51
 * @Version: 1.0
 *
 * @Notes:
 * 1.keep calculate the remainder 余数 ,seems to do divided again and again on both of them
 * 2.use the remainder and smaller one to repeat this function
 * 3.until one variable become 0 which mean they cannot divide each other on next turn, then break the gcd function
 */
public class gcd {

    public int gcdfunc(int p,int q){

        if(q==0) return p;
        int r=p%q;

        /* 1 Wrong: This is not direct to use a function, instead of return a function */
        //gcdfunc(q,r);
        return gcdfunc(q,r);
    }

    public static void main(String[] args) {

        gcd gcdTest=new gcd();

        System.out.println(" the greatest common divisor gcd is :" + gcdTest.gcdfunc(1111111,1234567));
    }
}
