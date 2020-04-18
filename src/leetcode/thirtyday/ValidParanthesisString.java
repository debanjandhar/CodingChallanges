package leetcode.thirtyday;

import java.util.Stack;

public class ValidParanthesisString {
	public boolean checkValidString(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case ')':
				Character nextChar = ')';
				int stars = 0;
				while (!stack.isEmpty()) {
					nextChar = stack.pop();
					if (nextChar == '(') {
						break;
					} else {
						stars++;
					}
				}

				if (nextChar != '(' && stack.isEmpty()) {
					if (stars == 0) {
						// Neither do we have an opening brace nor star to close the current brace.
						return false;
					}
					// We did not get a opening brace, use a star
					stars--;
				}

				for (int i = 0; i < stars; i++) {
					stack.push('*');
				}
				break;
			case '(':
				stack.push('(');
				break;
			case '*':
				stack.push('*');

			}
		}

		int stars = 0;
		while (!stack.isEmpty()) {
			Character currEle = stack.pop();
			switch (currEle) {
			case '(':
				if (stars == 0) {
					return false;
				}
				stars--;
				break;
			case '*':
				stars++;
			}
		}

		return true;
	}

	public static void main(String[] args) {
//		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
//		String s = "()";
//		String s = "(*)";
//		String s = "(*))";
		String s = "(*()";
//		String s = ")(";
		System.out.println(new ValidParanthesisString().checkValidString(s));
	}
}
