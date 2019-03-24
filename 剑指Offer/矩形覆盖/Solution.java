public class Solution {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        int[] rect = {1,2};
        if(target<3)
            return rect[target-1];
        target -= 2;
        while(target>0){
            target -= 1;
            int tmp = rect[1];
            rect[1] = rect[0]+rect[1];
            rect[0] = tmp;
        }
        return rect[1];
    }
}