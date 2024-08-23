package Stack_Queue;

import java.util.*;

public class queueImp {
    static Queue<Integer> stack = new PriorityQueue<Integer>();

    static void push(int i) {
        int n = stack.size();
        stack.add(i);
        for (int j = 1; j < n; j++) {
            stack.add(stack.peek());
            stack.poll();
        }
    }

    static void pop() {
        System.out.println("POP: " + stack.poll());
    }

    static void top() {
        System.out.println("TOP: " + stack.peek());
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        pop();
        pop();
        pop();
        top();
        pop();
        top();
    }
}
