package com.stackatomc.OfferPractise;

/**
 * @File: Solution6
 * @Description: 旋转数组的最小数字
 * 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Author: MayerFang
 * @Date: 2018/8/26 1:00
 * @Version: 1.0
 */
public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        //考察排序前后比较
        if(array.length==0) return 0;
        if(array.length==1) return array[0];
        int smallele=0;
        for(int i=1;i<array.length-1;++i){
            if(array[i+1]<array[i])
            {smallele=array[i+1];
                break;
            }
        }
        return smallele;
    }
}