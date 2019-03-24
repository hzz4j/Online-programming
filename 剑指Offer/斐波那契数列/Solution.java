public class Solution {
    public int Fibonacci(int n) {
        int[] array = {0,1};
        if(n<2){
            return array[n];
        }
        //n must be assign
        while((n -= 1)>0){
            
            int tmp = array[1];
            array[1] = array[0]+array[1];
            array[0] = tmp;
        }
        return array[1];
    }
}