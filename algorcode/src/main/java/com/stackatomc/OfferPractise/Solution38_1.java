package com.stackatomc.OfferPractise;

/**
 * @author MayerFang
 * @file Solution38_1
 * @Description 求出数组中出现一半的数字
 * @date 2018/9/14
 */
public class Solution38_1 {

    // 1 基于快速排序法
    // 思路是以一个为判断数字，进行排序分别得到左边比它小的和右边大值，判断下标是否为length/2，继续排序
    public int MoreThanHalfNum(int[] nums){
        if(nums.length<=0)return -1;
        return MoreThanHalfNum(nums,0,nums.length-1, nums.length);
    }

    public int MoreThanHalfNum(int[] nums,int h0,int h1,int length){
        if(h0>h1||length<=0)return -1;

        int startNum=nums[h0];
        int start=h0;
        int end=h1;
        while(start<end){
            while(start<end&&nums[end]>startNum){
                end=end-1;
            }
            nums[start]=nums[end];
            //System.out.println("end="+end);
//            for(int i=0;i<nums.length;++i)
//                System.out.print(nums[i]);
            while(start<end&&nums[start]<=startNum){
                start=start+1;
            }
            nums[end]=nums[start];
        }
        nums[start]=startNum;

            if(start==length/2)
                return nums[start];
            else if(start<length/2)
                return MoreThanHalfNum(nums,start+1,h1,length);
            else return MoreThanHalfNum(nums,h0,start-1,length);

    }

    //2 根据数组特点找出
    // 思路：该数出现次数大于其他数字出现的总和
    public int MoreThanHalfNums2(int[] nums){
        if(nums.length<=0)return -1;
        int times=1;
        int result=nums[0];
        for(int i=1;i<nums.length;++i){
            if(times==0){
                result=nums[i];
                times=1;
            }else if(nums[i]==result){
                times++;
            }else times--;
        }
        // 3 8 6 5 8 3 3 3
        return result;
    }

    public static void main(String[] args) {
        Solution38_1 s38=new Solution38_1();
        int[] testnums={3,3,4,2,3};
        System.out.println(s38.MoreThanHalfNums2(testnums));
    }
}
