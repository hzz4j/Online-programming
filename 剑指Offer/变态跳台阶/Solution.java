public class Solution {
    public int JumpFloorII(int target) {
        int[] step = {1,2};
        if(target<3){
            return step[target-1];
        }
        target -= 2;
        while(target>0){
            target -= 1;
            step[1] = step[1]*2;
        }
        return step[1];
    }
}