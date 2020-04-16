package leetcode.thirtyday;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> stack;
	List<Integer> minStack;
	int top;

	public MinStack() {
		stack = new ArrayList<Integer>();
		minStack = new ArrayList<Integer>();
		this.top = -1;
	}

	public void push(int x) {
		int minElement = x;
		if (top != -1) {
			minElement = minStack.get(top);
			if (x < minElement) {
				minElement = x;
			}
		}
		top++;
		stack.add(x);
		minStack.add(minElement);
	}

	public void pop() {
		stack.remove(top);
		minStack.remove(top--);
	}

	public int top() {
		return stack.get(top);
	}

	public int getMin() {
		return minStack.get(top);
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(3);
		obj.push(12);
		obj.push(1);
		obj.push(4);
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.pop();
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}
