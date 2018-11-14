/**
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        
        
        if(pre.length==0)
        {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        //停止条件
        if (pre.length==1){
            root.left=null;
            root.right=null;
            return root;
        }
        if (pre.length==2){
            if(pre[0]==in[0]){
                root.left=null;
                root.right=new TreeNode(in[1]);
                root.right.left=null;
                root.right.right=null;
            }
            else{
                root.right=null;
                root.left=new TreeNode(in[0]);
                root.left.left=null;
                root.left.right=null;
            }
            return root;
        }
        int i=0;
        //找到后序遍历的根节点位置
        for (int m=0;m<pre.length;m++){
            if (pre[0]==in[m]){
                i=m;
            }
        }
        //创建数组
        int size_left=i;
        int size_right=pre.length-i-1;
        int [] pre_left=new int[size_left];
        int [] in_left=new int[size_left];
        
        int [] pre_right=new int[size_right];
        int [] in_right=new int[size_right];
        
        //给新的数组赋值
        for(int j=0;j<pre.length-1;j++){
            if(j<i){
                pre_left[j]=pre[j+1];
                in_left[j]=in[j];
            }
            else{
                pre_right[j-i]=pre[j+1];
                in_right[j-i]=in[j+1];
            }
        }
        //递归 
        root.left=reConstructBinaryTree(pre_left,in_left);
        root.right=reConstructBinaryTree(pre_right,in_right);
        return root;
    }
}
