import java.util.Stack;

public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    //最小值在pop过程是会变化的，所以对应存储的数据都存一个当前状态的最小值
    //min_stack的顶部永远是stack当前存储的数据最小值
    Stack<Integer> min_stack = new Stack<Integer>();
    public void push(int node) {
        if(min_stack.empty() || min_stack.peek()>node){
            min_stack.push(node);
        }else{
            min_stack.push(min_stack.peek());
        }
        stack.push(node);
    }
    
    public void pop() {
        if(stack.empty() || min_stack.empty())
            return;
        stack.pop();
        min_stack.pop();
    }
    //栈顶元素
    public int top() {
        if(stack.empty())
            return 0;
        return stack.peek();
    }
    
    public int min() {
        if(min_stack.empty())
            return 0;
        return min_stack.peek();
    }
}