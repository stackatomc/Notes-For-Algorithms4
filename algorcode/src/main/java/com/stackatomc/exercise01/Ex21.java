//package com.stackatomc.exercise01;
//
//import edu.princeton.cs.algs4.StdOut;
//
//import java.util.Scanner;
//
///**
// * @author MayerFang
// * @file Ex21
// * @Description
// * @date 2018/8/21
// */
//public class Ex21 {
//
//
//    /*
//    * "XXX" 5 6 5/6
//    *
//    * */
//
//    public static void printName(){
//        Scanner sc=new Scanner(System.in);
//        try{
//            while(true) {
//                String name = sc.next();
//                double a = sc.nextDouble();
//                double b = sc.nextDouble();
//                double result = a / b;
//                System.out.print(name + " " + a + " " + b + " ");
//                // double类型格式化字符串用f或e
//                StdOut.printf("%.3f\n",result);
//                System.out.printf("%.3f\n",result);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void printNameLine(){
//        Scanner sc=new Scanner(System.in);
//        while(true){
//            String strLine=sc.nextLine();
//            String[] temp=strLine.split(" ");
//            double result=Double.parseDouble(temp[1])/Double.parseDouble(temp[2]);
//            System.out.print(temp[0]+" "+temp[1]+" "+temp[2]+" ");
//            System.out.printf("%.3f\n",result);
//        }
//    }
//
//    public static void main(String[] args) {
//        printNameLine();
//    }
//}
