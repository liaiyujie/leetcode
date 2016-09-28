package ljt.bupt.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
//	Stack<Integer> stack = null;
//	List<Integer> list = null;
	 // stack: store the stack numbers
    private Stack<Integer> stack = new Stack<Integer>();
    // minStack: store the current min values
    private Stack<Integer> minStack = new Stack<Integer>();


	  /** initialize your data structure here. */
    public void push(int x) {
        // store current min value into minStack
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        // use equals to compare the value of two object, if equal, pop both of them
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

//    public MinStack() {
//    	stack = new Stack<Integer>();
//    }
//    
//    public void push(int x) {
//        stack.add(x);
//    }
//    
//    public void pop() {
//        stack.pop();
//    }
//    
//    public int top() {
//        int x = stack.peek();
//    	return x;
//    }
//    
//    public int getMin() {
//    	int len = stack.size();
//    	Integer[] anArray = new Integer[len];
//        stack.copyInto(anArray);
//        Arrays.sort(anArray);
//    	return anArray[0];
//    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

}
