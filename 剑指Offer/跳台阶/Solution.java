public class Solution {
    public int JumpFloor(int target) {
        int[] step = {1,2};
        if(target<3)
            return step[target-1];
        //计算循环的次数
        target -= 2;
        while(target>0){
            target -= 1;
            int tmp = step[1];
            step[1] = step[0]+step[1];
            step[0] = tmp;
        }
        return step[1];
    }
}