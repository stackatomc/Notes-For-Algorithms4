package com.stackatomc.OfferPractise;

import java.util.Arrays;

/**
 * @author MayerFang
 * @file Solution42_21
 * @Description
 * @date 2018/9/14
 */
public class Solution42_21 {

    // 1 基于快速排序法,无序数组//O(1)插入
    // 思路是以一个为判断数字，进行排序分别得到左边比它小的和右边大值，判断下标是否为length/2，继续排序
    public int[] insert1(int[] nums,int sbnum){
        //判断是否已满，通过增加一个count来计数
        int count=nums[nums.length-1]+1;
        System.out.println(nums.length+"    "+count);
        if(count>=nums.length){
            nums=Arrays.copyOf(nums,nums.length+1);
            System.out.println("nums.length="+nums.length);
        }
        nums[nums.length-2]=sbnum;
        nums[nums.length-1]=count;
        return nums;
    }

    //O(n)排序得中位数
    public int GetMiddle(int[] nums){
        if(nums.length<=0)return -1;
        return GetMiddle(nums,0,nums.length-2, nums.length-1);
    }

    public int GetMiddle(int[] nums,int h0,int h1,int length){
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
        //System.out.println("nums[start]="+start);
        if((length&1)==1){
            if(start==length/2)
                return nums[start];
            else if(start<length/2)
                return GetMiddle(nums,start+1,h1,length);
            else return GetMiddle(nums,h0,start-1,length);
        }else{
            if(start==length/2){
                return (nums[start]+GetMiddle(nums,h0,start-1,length-1))/2;
            }else if(start==length/2-1)
                return (nums[start]+GetMiddle(nums,start+1,h1,length+1))/2;
            else if(start>length/2)
                return GetMiddle(nums,h0,start-1,length);
            else
                return GetMiddle(nums,start+1,h1,length);
        }
    }

    static int[] numstore;

    //2 向排好序的数组中插O(n)，但获取中位数为O(1)
    public int insertAndGetMiddle2(int num){
        numstore=Arrays.copyOf(numstore,numstore.length+1);
        numstore[numstore.length-1]=num;
        Arrays.sort(numstore);
        if((numstore.length&1)==1)
            return numstore[numstore.length/2];
        else return (numstore[numstore.length/2]+numstore[numstore.length/2-1])/2;
    }

    static ListNode head,preindex,fastindex;
    //3 用有序链表实现插入是O(n),得到中位数是O(n)
    public int insertAndGetMiddle3(int num){
        if(head.val==-1){
            head.val=num;
            preindex=head;
            fastindex=head;}
        else{
            ListNode curhead=head;
            ListNode nexthead=new ListNode(num);
            while(num>curhead.val&&curhead.next!=null){
                curhead=curhead.next;
            }
            if(num>curhead.val&&curhead.next==null){
                curhead.next=nexthead;
            }else{
                nexthead.next=curhead;
            }
            if(preindex==fastindex)fastindex=fastindex.next;
            else preindex=preindex.next;
        }
        if(preindex!=null&&fastindex!=null&&preindex==fastindex){
            return preindex.val;
        }else if(preindex!=null&&fastindex!=null&&preindex!=fastindex){
            return (preindex.val+fastindex.val)/2;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution42_21 s4221=new Solution42_21();
        int[] testnums={3,33,44,23,2,3};
        int[] testempty=new int[1];
        testempty[0]=0;

        //1 test O(1)插入
        for(int i=0;i<testnums.length;++i){
            testempty=s4221.insert1(testempty,testnums[i]);
            for(int j=0;j<testempty.length;++j){
                System.out.println("testempty["+j+"]="+testempty[j]);
            }
        }

        //O(n)排序得中位数
        System.out.println(s4221.GetMiddle(testempty));


        //2 test
        numstore=new int[0];
        for(int i=0;i<testnums.length;++i){
            System.out.print(s4221.insertAndGetMiddle2(testnums[i])+"   ");
        }

        //3 test
        head=new ListNode(-1);
        for(int i=0;i<testnums.length;++i){
            System.out.print(s4221.insertAndGetMiddle3(testnums[i])+"   ");
        }
    }

}
