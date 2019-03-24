import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      int index_A = 0,index_B = 0;
      Stack<Integer> stack = new Stack<Integer>();
       while(index_A<pushA.length){
           //入栈
           stack.push(pushA[index_A]);
           index_A++;
           if(stack.peek() != popA[index_B]){
               continue;
           }else{
               while( !stack.isEmpty() && stack.peek() == popA[index_B]){
                   index_B++;
                   stack.pop();
               }
           }
       }
        return stack.isEmpty();
    }
}