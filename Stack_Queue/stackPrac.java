package Stack_Queue;

import java.util.Stack;

public class stackPrac {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);
        stk.push(7);
        stk.pop();
        stk.pop();
        stk.pop();
        int n = stk.search(3);
        System.err.println(n);
        System.err.println(stk.empty());
        System.out.println(stk);
    }
}
