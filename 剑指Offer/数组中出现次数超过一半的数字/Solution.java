import java.util.HashMap;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        float target = array.length / 2 ;
        for(int i:array){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            if(map.get(i)>target)
                    return i;
        }
        return 0;
    }
}