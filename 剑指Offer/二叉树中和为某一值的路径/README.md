自己的解法有问题，但是没有看出来问题在哪
```java
import java.util.ArrayList;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    static ArrayList<Integer> path = new ArrayList<Integer>();
    static int sum = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        
        if(root==null ||root.val>target)
            return list;
        sum += root.val;
        path.add(root.val);
        FindPath(list,root,target);
        
        //排序
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).size()<list.get(j).size()){
                    ArrayList<Integer> tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        
        return list;
        
    }
    
    public void FindPath(ArrayList<ArrayList<Integer>> list,TreeNode root,int target){
        if(sum == target){
            list.add(new ArrayList(path));
            return;
        }
        if(sum>target){
            return ;
        }
        if(sum<target){
            if(root.left != null){
                sum += root.left.val;
                path.add(root.left.val);
                FindPath(list,root.left,target);
                sum -= root.left.val;
                path.remove(path.size()-1);
            }
            
            if(root.right != null){
                sum += root.right.val;
                path.add(root.right.val);
                FindPath(list,root.right,target);
                sum -= root.right.val;
                path.remove(path.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        
        TreeNode root =  new TreeNode(10);
        root.right = new TreeNode(12);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        Solution s = new Solution();
        s.FindPath(root,15);
    }
}
```