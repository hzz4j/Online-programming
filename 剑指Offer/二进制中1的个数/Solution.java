public class Solution {
    public int NumberOf1(int n) {
        if(n == 0)
            return 0;
        //用于负数取反，补码
        int[] bits = new int[32];
        boolean is_neg = (n < 0);
        int result=0;
        int index=0;
        n = Math.abs(n);
        while(n != 0){
            //负数取反
            bits[index] = (n%2 == 1)? 0:1;
            if(n%2 == 1)
                result++;
            n = n/2;
            index++;
        }
        //处理其他未取反的数
        while(index<32){
            bits[index] = 1;
            index++;
        }
        
        
        //正数
        if(!is_neg)
            return result;
        

        index = 0;
        //补码
        int forward = 1;
        //负数补码最高为1
        while(index<31 && forward == 1){
            if(bits[index]+forward>1){
                bits[index] = 0;
                forward = 1;
            }else{
                bits[index] = 1;
                forward = 0;
            }
            index++;
        }
        
         result = 0;
        for(int i:bits){
            if(i==1)
                result++;
        }
        return result;
        
    }
}