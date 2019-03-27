package one;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> result = new ArrayList<String>();
        
       if(str.length() == 0)
           return result;
       char[] str_char = str.toCharArray();
       char[] arr = new char[str_char.length];
       deal(result,str_char,arr,0);
       Collections.sort(result);
       return result;
    }
    
    public void deal(ArrayList<String> result,char[] str_char,char[] arr,int index){
        if(index>=str_char.length){
        	if(result.contains(String.valueOf(arr)))
        		return;
        	else {
	            result.add(String.valueOf(arr));
	            return;
        	}
        }
        
        for(int i=index;i<str_char.length;i++){
            arr[index] = str_char[i];
            swap(str_char,index,i);
            deal(result,str_char,arr,index+1);
            swap(str_char,index,i);
            
        }
        
        
    }
    
    public void swap(char[] arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 
    public static void main(String[] args){
        Solution s = new Solution();
        ArrayList<String> a = s.Permutation("baa");
        for(String str: a) {
        	System.out.println(str);
        }
    }
}