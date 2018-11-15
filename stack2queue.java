/*
入队时，将元素压入stack1。
出队时，判断stack2是否为空，如不为空，则直接弹出顶元素；如为空，则将s1的元素逐个“倒入”stack2，把最后一个元素弹出并出队。
这个思路，避免了反复“倒”栈，仅在需要时才“倒”一次。
*/


import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
         
    }
    
    public int pop() {
        int front;
        if(!stack2.empty()){
            front=stack2.peek();
            stack2.pop();
            
        }
        else{
            while (!stack1.empty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
            front=stack2.peek();
            stack2.pop();
        }
        return front;
    }
}
