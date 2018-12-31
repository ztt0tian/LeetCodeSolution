package P151_P200;

import java.util.Stack;

public class P155 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

}
class MinStack {
    Stack<Integer> stack_element;//存储基本元素
    Stack<Integer> stack_min;//跟踪基本元素

    /** initialize your data structure here. */
    public MinStack() {
        stack_element = new Stack<Integer>();
        stack_min = new Stack<Integer>();
    }

    public void push(int x) {
        stack_element.push(x);
        if(stack_min.empty()){
            stack_min.push(x);
        }
        else if(x<=stack_min.peek()){
            stack_min.push(x);//有更小的值
        }
    }

    public void pop() {
        int pop_item = stack_element.pop();
        if (pop_item == stack_min.peek()) {
            stack_min.pop();//最小值也pop
        }
    }

    public int top() {
        return stack_element.peek();
    }

    public int getMin() {
        return stack_min.peek();
    }
}
