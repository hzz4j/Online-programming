```java
public class Solution {
    public int NumberOf1(int n) {
        //不用造轮子
        String str = Integer.toBinaryString(n);
        int cnt =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                cnt++;
        }
        return cnt;
    }
}
```