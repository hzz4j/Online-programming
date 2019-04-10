/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.90%)
 * Total Accepted:    407.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

 //参考： https://blog.csdn.net/chen_xinjia/article/details/69258706
 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int cut1=0,cut2=0;
        int size = nums1.length+nums2.length;
        int cutL=0,cutR=nums1.length;
        while(true){
            cut1 = (cutL+cutR)/2;
            cut2 = size/2-cut1;
            int L1 = (cut1>0)? nums1[cut1-1]:Integer.MIN_VALUE;
            int L2 = (cut2>0)? nums2[cut2-1]:Integer.MIN_VALUE;
            int R1 = (cut1<nums1.length)? nums1[cut1]:Integer.MAX_VALUE;
            int R2 = (cut2<nums2.length)? nums2[cut2]:Integer.MAX_VALUE;
            
            if(L1>R2){
                cutR = cut1-1;
            }else if(L2>R1){
                cutL = cut1+1;
            }else{
                //find the answer
                if(size % 2 == 1)
                    return Math.min(R1,R2);
                else
                    return ((double)(Math.max(L1,L2)+Math.min(R1,R2)))/2;
            }
            
        }
        
    }
}

