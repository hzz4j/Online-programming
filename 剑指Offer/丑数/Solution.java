public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0)
            return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int current_index = 0;
        int multiply_2_index = 0;
        int multiply_3_index = 0;
        int multiply_5_index = 0;
        while(current_index<index-1){
            
            int min = min_ugly_number(arr[multiply_2_index]*2,
                                      arr[multiply_3_index]*3,arr[multiply_5_index]*5);
            current_index++;
            arr[current_index] = min;
            
            //update
            while(arr[multiply_2_index]*2<=arr[current_index]){
                multiply_2_index++;
            }
            
            while(arr[multiply_3_index]*3<=arr[current_index]){
                multiply_3_index++;
            }
            
            while(arr[multiply_5_index]*5<=arr[current_index]){
                multiply_5_index++;
            }
            
           
        }
        
        return arr[current_index];
    }
    
    public int min_ugly_number(int a,int b,int c){
        int num = (a<b)? a:b;
        return (num<c)?num:c;
    }
}