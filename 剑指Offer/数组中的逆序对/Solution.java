
import java.util.Arrays;

public class Solution {

	static int count = 0;
	
	public  int InversePairs(int [] array) {
		merge_sort(array,0,array.length-1);
		return count;
	}

	public  void  merge_sort(int[] numbers,int start,int end) {
		if(end<=start)
			return;
		
		int mid = (start+end)/2;
		merge_sort(numbers,start,mid);
		merge_sort(numbers,mid+1,end);
		
		merge(numbers,start,mid,end);

	}
	
	public  void merge(int[] numbers,int start,int mid,int end) {
		
		
		int[] right = new int[end-mid];
		int[] left = new int[mid-start+1];
		
		for(int i = 0;i<left.length;i++) {
			left[i] = numbers[start+i];
		}
		
		for(int j=0;j<right.length;j++) {
			right[j] = numbers[j+mid+1];
		}
		
		//处理逆序对
		countPairs(left,right);
		
		
		int index=start;
		int l_i = 0,r_i=0;
		while(l_i<left.length && r_i<right.length) {
			if(left[l_i]<=right[r_i]) {
				numbers[index] = left[l_i];
				l_i++;
			}else {
				numbers[index] = right[r_i];
				r_i++;
			}
			index++;
		}
		
		while(l_i<left.length) {
			numbers[index] = left[l_i];
			l_i++;
			index++;
		}
		
		while(r_i<right.length) {
			numbers[index] = right[r_i];
			r_i++;
			index++;
		}
		
	}
	
	
	private void countPairs(int[] left,int[] right) {
		int pl = left.length-1;
		int pr = right.length-1;
		while(pl>=0 && pr>=0) {
			if(left[pl]<=right[pr]) {
				pr--;
			}else {
				//左边的大值大于右边的大值，则右边到大值的都算，这时pl--才不会漏掉计数
				count += pr+1;
				count %= 1000000007;
				pl--;
			}
		}
	}
}
