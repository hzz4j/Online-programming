public class Solution {
    public int FirstNotRepeatingChar(String str) {
        //模拟哈希表
        int[] hashTable = new int[256];
        for(int i = 0;i<str.length();i++){
            hashTable[(int)str.charAt(i)] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(hashTable[(int)str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}