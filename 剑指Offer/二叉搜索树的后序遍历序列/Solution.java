public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        //检查
        if(sequence==null || sequence.length<=0)
            return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    
    public boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if(start>=end)
            return true;
        int root = sequence[end];
        int i=0;
        //左子树
        while(sequence[i]<root){
            i++;
        }
        //右子树
        int j=i;
        while(i<=end){
            if(sequence[i]<root)
                return false;
            i++;
        }
        
        return VerifySquenceOfBST(sequence,0,j-1) && VerifySquenceOfBST(sequence,j,end-1);
    }
}