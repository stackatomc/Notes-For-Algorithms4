/**
 * @File: Solution4
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/26 0:01
 * @Version: 1.0
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}


public class Solution4 {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

    }
    public static TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

        if(startPre>endPre||startIn>startPre)
            return null;

        TreeNode treeNode=new TreeNode(pre[startPre]);


        for(int i=startIn;i<=endIn;++i){
            if(in[i]==pre[startPre]){
                //左边建树
                treeNode.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //右边建树
                treeNode.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return treeNode;
    }

    public static void preTree(TreeNode treeNode){
        if(treeNode==null)return;
        System.out.print(treeNode.val+"   ");
        preTree(treeNode.left);
        //System.out.print(treeNode.val+"   ");
        preTree(treeNode.right);
    }

    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode tree=reConstructBinaryTree(pre,in);
        preTree(tree);
    }
}