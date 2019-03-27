/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode head = null;
    TreeNode end = null;
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Convert(pRootOfTree.left);
        //first time fine the first element
        if(head == null && end == null){
            head = pRootOfTree;
            end = pRootOfTree;
        }else{
            end.right = pRootOfTree;
            pRootOfTree.left = end;
            end = end.right;
        }
        Convert(pRootOfTree.right);
        
        return head;
    }
}