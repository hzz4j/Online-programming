import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length==0 || k<0 || k>input.length)
            return list;
        Arrays.sort(input);
        for(int i=0;i<k;i++)
            list.add(input[i]);
        return list;
    }
}