package com.stackatomc.exercise01;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author MayerFang
 * @file Ex07
 * @Description
 * @date 2018/8/20
 */
public class Ex07 {

    /* a. 9.0 8 5.09
    *  b. 0+1+2+3+...+999=(0+999)*1000/2=499500
    *  c. 1+2+4+16+256+...
    * */
    public static void main(String[] args) {

        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
            sum++;
        StdOut.println(sum);


        int sum1 = 0;
        for (int i = 1; i < 1000; i*=2)
            for (int j = 0; j < i; j++)
                sum1++;
        StdOut.println(sum1);
    }

}
