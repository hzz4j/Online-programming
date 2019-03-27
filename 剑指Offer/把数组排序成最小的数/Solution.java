package four;

import java.util.Comparator;

public class Solution {
	
	private static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String s1 = o1+o2;
			String s2 = o2+o1;
			return s1.compareTo(s2);
		}
		
	}
	public static void main(String[] args) {
		int[] nums = {3,32,321};
		//System.out.println("32".compareTo("321"));
		System.out.println(PrintMinNumber(nums));
		
	}
	
    public static String PrintMinNumber(int [] numbers) {
    		//转为字符串数组
    		String[] str = new String[numbers.length];
    		for(int i=0;i<numbers.length;i++) {
    			str[i] = String.valueOf(numbers[i]);
    		}
    		
    		//排序
    		MyComparator comparator = new MyComparator();
    		quickSort(str,0,str.length-1,comparator);
    		StringBuilder result = new StringBuilder();
    		for(String s: str)
    			result.append(s);
    		return result.toString();
    }
    
    private static void quickSort(String[] strs,int start,int end,Comparator comparator) {

    	if(start>=end)
    		return;
    	String pivot = strs[start];
    	int left = start;
    	int right = end;
    	while(start<end) {
    		//deal end
    		while(start<end && comparator.compare(strs[end],pivot)>=0) {
    			end--;
    		}
    		strs[start] = strs[end];
    		
    		//deal start
    		while(start<end && comparator.compare(strs[start], pivot)<=0) {
    			start++;
    		}
    		strs[end] = strs[start];
    	}
    	
    	strs[start] = pivot;

    	quickSort(strs,left,start-1,comparator);
    	quickSort(strs,start+1,right,comparator);
    }
}
