/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
         TreeNode head = null;
         head = buildTree(pre,in);
         return head;
    }
    
    private TreeNode buildTree(int[] pre,int[] in){
            if(pre.length == 0)
                return null;
            TreeNode node = new TreeNode(pre[0]);
            //左子树
            int i = 0;

            while(in[i] != pre[0]){
                i++;
            }
            if(i != 0){
                int[] leftTreeIn = new int[i];
                int[] leftTreePre = new int[i];
                for(int k=0;k<i;k++){
                    leftTreeIn[k] = in[k];
                    leftTreePre[k] = pre[k+1];
                }
                node.left = buildTree(leftTreePre,leftTreeIn);
            }

           //右子树
            int j = in.length-i-1;
            if( j!= 0){
                int[] rightTreeIn = new int[j];
                int[] rightTreePre = new int[j];
                for(int k=i+1,z=0;k<in.length;k++,z++){
                    rightTreeIn[z] = in[k];
                    rightTreePre[z] = pre[k];
                }
                node.right = buildTree(rightTreePre,rightTreeIn);
            }
            return node;
        }
}