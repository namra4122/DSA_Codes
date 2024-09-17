package Stack_Queue;

import java.util.*;

public class valid_Paranthes {
    static boolean checkBalance(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (s.isEmpty())
                    return false;
                char temp = stack.peek();
                stack.pop();

                if (i == ')' && temp == '(') {
                    continue;
                } else if (i == ']' && temp == '[') {
                    continue;
                } else if (i == '}' && temp == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(checkBalance("()[]{})"));
    }
}
