package leetcode;

/**
 * Main
 */
class Solution {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a,b));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
                else{
                    double ad1 = Math.max(L1,L2);
                    int ad2 = Math.min(R1,R2);
                    double result = (ad1+ad2)/2;
                    return result;
                }
            }
            
        }
        
    }
}