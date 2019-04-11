/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (43.55%)
 * Total Accepted:    344.1K
 * Total Submissions: 789.7K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */


 //我是从相邻的思考，暴力求解，没有对具体问题，具体的分析
 /* 
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<len-1;i++)
            for(int j=i+1;j<len;j++){
                int square = Math.abs(i-j)*Math.min(height[i],height[j]);
                if(square>max)
                    max = square;
            }

        return max;
    }
}
 */


//参考：　https://github.com/PengFTang/Algorithms-in-Java/commit/651f17dd408236aca5243ba4982f25672c4b1edb#diff-de0ccd04e686c117f3fbc87f8c22daf7
//双指针，全局思考
class Solution{
    public int maxArea(int[] height){
        int lo=0,hi=height.length-1;
        int max=Integer.MIN_VALUE;
        while(lo<hi){
            //calculate size
            int size = Math.min(height[lo], height[hi])*(hi-lo);
            if(size>max)
                max = size;
            
            int loCur = height[lo],hiCur = height[hi];
            //update lo or hi not just by one step
            if(height[lo]<height[hi]){
                while(lo<hi && height[lo]<=loCur)
                    lo++;
            }else{
                while(lo<hi && height[hi]<=hiCur)
                    hi--;
            }
        }
        return max;
    }
}

 
