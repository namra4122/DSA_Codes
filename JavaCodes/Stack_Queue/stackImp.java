package Stack_Queue;

import java.util.Stack;

class App1 {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void push(int i) {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.push(i);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    void top() {
        System.out.println("TOP: " + s1.peek());
    }

    void pop() {
        System.out.println("POP: " + s1.pop());
    }

    void print() {
        System.out.println(s1);
    }

}

class App2 {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void push(int i) {
        s1.push(i);
    }

    void top() {
        if (!s2.empty()) {
            System.out.println("TOP: " + s2.peek());
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            System.out.println("TOP: " + s2.peek());
        }
    }

    void pop() {
        if (!s2.empty()) {
            System.out.println("POP: " + s2.pop());
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s2.pop();
        }
    }
}

public class stackImp {
    public static void main(String[] args) {
        // App1 queue_1 = new App1();
        // queue_1.push(1);
        // queue_1.push(2);
        // queue_1.push(3);
        // queue_1.push(4);
        // queue_1.push(5);
        // queue_1.top();
        // queue_1.pop();
        // queue_1.pop();
        // queue_1.pop();
        // queue_1.push(6);
        // queue_1.top();
        // queue_1.print();

        App2 queue_2 = new App2();
        queue_2.push(1);
        queue_2.push(2);
        queue_2.push(3);
        queue_2.push(4);
        queue_2.push(5);
        queue_2.top();
        queue_2.pop();
        queue_2.pop();
        queue_2.pop();
        queue_2.push(6);
        queue_2.top();
    }
}
