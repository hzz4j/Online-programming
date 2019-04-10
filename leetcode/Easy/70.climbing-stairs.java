/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (43.83%)
 * Total Accepted:    379.9K
 * Total Submissions: 866.7K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
//TODO 旧代码
 /* 
class Solution {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }

        n = n -2;
        int f1=1,f2=2,result=0;
        while(n>0){
            result = f2+f1;
            f1 = f2;
            f2 = result;
            n--;
        }
        return result;

    }
} */

//动态规划，是需要一个table的，以空间换时间

class Solution{
    public int climbStairs(int n){
        if(n == 0 || n == 1 || n == 2)
            return n;
        int[] tab = new int[n+1];
        tab[1] = 1;
        tab[2] = 2;
        for(int i=3;i<=n;i++){
            tab[i] = tab[i-1]+tab[i-2];
        } 
        return tab[n];
    }
}



