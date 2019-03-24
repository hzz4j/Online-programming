import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //检查
        if(array.length == 0)
            return 0;
        if(array.length == 1)
            return array[0];
        int j=0;
        for(int i=0;i<array.length-1;i++){
            j = i+1;
            if(array[i]>array[j])
                break;
        }
        return array[j];
    }
}