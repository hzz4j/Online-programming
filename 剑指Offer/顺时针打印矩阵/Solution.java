import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int up = 0,left = 0;
       int right = matrix[0].length-1;
       int down = matrix.length-1;
       ArrayList<Integer> result = new ArrayList<Integer>();
       while(up <= down && left<=right){
           //up
           for(int i=left;i<=right;i++){
               result.add(matrix[up][i]);
           }
           up++;
           
           //right
           for(int i=up;i<=down;i++){
               result.add(matrix[i][right]);
           }
           right--;
           
           //注意这个条件
           if(down<up)
               break;
           //down
           for(int i=right;i>=left;i--){
               result.add(matrix[down][i]);
           }
           down--;
           //注意这个条件以防right已经是-1,left是0
           if(right<left)
               break;
           //left
           for(int i=down;i>=up;i--){
               result.add(matrix[i][left]);
           }
           left++;
       }
       
       return result;
    }
}