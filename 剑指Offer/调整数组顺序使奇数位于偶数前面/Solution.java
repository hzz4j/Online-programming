import java.util.ArrayList;
public class Solution {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> odd_list = new ArrayList<Integer>();
        ArrayList<Integer> even_list = new ArrayList<Integer>();
        for(int i:array){
            if(i%2==0){
                even_list.add(i);
            }else{
                odd_list.add(i);
            }
        }
        //合并
        //for(Integer i:even_list)
        //    odd_list.add(i);
        odd_list.addAll(even_list);
        for(int i=0;i<odd_list.size();i++){
            array[i] = odd_list.get(i).intValue();
        }
    }
}