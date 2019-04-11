> Java编程中的细节问题


1. long是64位，int是32位
2. -123%10 等于-3，-123/10 -12  [code](../leetcode/Easy/7.reverse-integer.java)
3. 字符串可以加字符 “hello”+'a'
4. String.subString 获取指定下标的子字符串 [code](../leetcode/Medium/5.longest-palindromic-substring.java)
6. 转化代码 [code](../leetcode/Hard/4.median-of-two-sorted-arrays.java)
```java
    //推荐
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        //....
    }

    //自己以前的写法
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        //...
    }

```

7. 字符数字，9 = ‘9’-‘0’

8. 检查边界条件，如n<Integer.MIN_VALUE,n>Integer.MAX_VALUE: [code](../leetcode/Medium/8.string-to-integer-atoi.java)
```java
//推荐
for(int i=index;i<str.length();i++){
            char c = str.charAt(i);
            if(!Character.isDigit(c))
                break;

            int d = c-'0';
            if(tmp>(Integer.MAX_VALUE-d)/10){
                return (isnegtive)? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            tmp = tmp*10+d;

        }

//冗余代码，还有问题
for(int i=index;i<str.length();i++){
    char c = str.charAt(i);
    if(isNotNumber(c))
        break;
    tmp = tmp*10+c-48;
    if(isnagtive){
        tmp = tmp*-1;
        isnagtive=false;
    }
    if(tmp<Integer.MIN_VALUE) 
        return Integer.MIN_VALUE;
    if(tmp>Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
}

```

9. 检查是否是数字，Character.isDigit();

10. 双指针的更新not update by one step [code](../leetcode/Medium/TwoPoints/11.container-with-most-water.java)