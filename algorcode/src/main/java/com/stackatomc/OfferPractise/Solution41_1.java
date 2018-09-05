package com.stackatomc.OfferPractise;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @File: Solution41_1
 * @Description: 序列化和反序列化二叉树
 * @Author: MayerFang
 * @Date: 2018/9/5 20:24
 * @Version: 1.0
 */
public class Solution41_1 {

    public String Serialize(TreeNode head){
        if(head==null)
            return "#,";
        StringBuilder sb=new StringBuilder(head.val+",");
        sb.append(Serialize(head.left));
        sb.append(Serialize(head.right));
        return sb.toString();
    }

    public TreeNode Deserialize(String str){
        String[] strs=str.split(",");
        Queue<String> queue=new LinkedList<String>();
        for(int i=0;i<strs.length;++i){
            queue.offer(strs[i]);
        }
        return PreOrder(queue);
    }

    public TreeNode PreOrder(Queue<String> queue){
        String val=queue.poll();
        if(val.equals("#"))return null;
        TreeNode node=new TreeNode(Integer.valueOf(val));
        node.left=PreOrder(queue);
        node.right=PreOrder(queue);
        return node;
    }
}
