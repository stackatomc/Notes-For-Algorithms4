package com.stackatomc.tools;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @File: Solution17_1
 * @Description: 实现n位数从1递增输出数字排列（位运算+队列实现、char数组存储结合进位实现、单纯以全排列实现、StringBuilder.repalce（也可实现，同理字符串））
 * @Author: MayerFang
 * @Date: 2018/9/2 15:19
 * @Version: 1.0
 */
public class Solution17_1 {

    // 第一种方法：通过位运算结合队列数据结构实现递增
    public void PrintToMaxOf(int n){
        if(n<=0) System.out.println("wrong input");
        int onet=1;
        int ones=0;
        for(int i=0;i<n;++i){
            ones=ones+onet;
            onet=onet*10;
        }
        int maxt=9*ones;
        onet=1;
//        for(onet=1;onet<=maxt;++onet){
//            System.out.println(onet);
//        }
        Queue<Integer> qu=new LinkedList<Integer>();
        qu.offer(onet);
        PrintLeft(qu,maxt);
    }
    public  static void PrintLeft(Queue<Integer> q,int m){
        if((q.peek()<<1)>m)return;
        while(!q.isEmpty()&&(q.peek())<=m){
            int n1=q.poll();
            System.out.println(n1);
            q.offer(n1<<1);
            q.offer((n1<<1)+1);
        }
    }

    // 第二种方法：通过逐个位数判断是否进位实现数字排列
    public void printDigits(int n){
        if(n<0)return ;
        char[] chars=new char[n];
        for(int i=0;i<n;++i){
            chars[i]='0';
        }

        while(!Increament(chars)){
            PrintForDigit(chars);
        }
    }

    public boolean Increament(char[] c){
        boolean isOverflow=false;

        for(int i=c.length-1;i>=0;--i){
            char number=c[i];
            //System.out.println(number);
            int sunm=number-'0';
            // 将char类型取出来时ASCII码，转化为int类型的方法
            //int sunmc=c[i]-'0';
            sunm=sunm+1;
            //对sunm进行判断看是否需要进位
            if(sunm==10){
                //对位数的溢出计算判断条件
                if(i==0){
                    isOverflow=true;
                    return isOverflow;
                }else{
                    // 直接赋值char类型的方法
                    c[i]='0';
                }
            }else{
                // 将int类型转换为ASCII码存储为char类型的方法
                c[i]=(char)('0'+sunm);
                //System.out.println(c[i]);
                break;
            }
        }

        return isOverflow;
    }

    // 这个方法是实现了097如数字时避免将0打出，对第一个非零值进行确定定位
    public void PrintForDigit(char[] c){
        boolean isZero=true;
        for(int i=0;i<c.length;++i){
            // 加入isZero的判断可避免无效判断
            if(isZero&&c[i]!='0'){
                isZero=false;
            }
            if(!isZero){
                System.out.print(c[i]);
            }
        }
        System.out.println();
    }

    // 第三种方法：全排列实现数字排列
    public void PrintToMaxOfDigits(int n){
        if(n<=0)return ;
        char[] numbers=new char[n];
        for(int i=0;i<10;++i){
            numbers[0]=(char)('0'+i);
            PrintRestDigits(numbers,1);
        }

    }

    public void PrintRestDigits(char[] c,int index){
        if(index==c.length)
        {
            PrintForDigit(c);
            return;
        }
        for(int i=0;i<10;++i){
            c[index]=(char)('0'+i);
            PrintRestDigits(c,index+1);
        }
    }

    public static void main(String[] args) {
        Solution17_1 s17=new Solution17_1();
        s17.PrintToMaxOfDigits(2);
    }
}
