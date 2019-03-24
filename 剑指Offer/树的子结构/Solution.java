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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoseTree1HasTree2(root1,root2);
            }
            //左子树
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            //右子树
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        
        return result;
    }
    
    private boolean DoseTree1HasTree2(TreeNode root1,TreeNode root2){
            if(root1 == null && root2 != null)
                 return false;
            if(root2 == null)
                return true;
            if(root1.val != root2.val)
                return false;
        return DoseTree1HasTree2(root1.left,root2.left) && DoseTree1HasTree2(root1.right,root2.right);
        
    }
}