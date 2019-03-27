public class Solution {
    
    public int FindGreatestSumOfSubArray(int[] array) {
        int max_value = Integer.MIN_VALUE;
        //目前发现连续中求和最大的值
        int current_value=0;
        for(int i=0;i<array.length;i++){
            if(i==0){
                current_value = array[i];
                max_value = array[i];
            }else{
                current_value = Math.max(current_value+array[i],array[i]);
                max_value = Math.max(max_value,current_value);
            }
            
        }
        return max_value;
    }
}