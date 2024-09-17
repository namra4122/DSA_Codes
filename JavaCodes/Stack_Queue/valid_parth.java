package Stack_Queue;

import java.util.*;

public class valid_parth {
	static boolean checkBal(String parth) {
		Stack<Character> stack = new Stack<>();

		for (char i : parth.toCharArray()) {
			if (i == '(' || i == '{' || i == '[') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char temp = stack.pop();

				if (i == ')' && temp == '(')
					continue;
				else if (i == ']' && temp == '[')
					continue;
				else if (i == '}' && temp == '{')
					continue;
				else
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String args[]) {
		String par = "{}";
		String par1 = "{}[]()";
		String par2 = "{[]}";
		String par3 = "{}]";
		String par4 = "{}(";
		System.err.println(checkBal(par));
		System.err.println(checkBal(par1));
		System.err.println(checkBal(par2));
		System.err.println(checkBal(par3));
		System.err.println(checkBal(par4));
	}
}
