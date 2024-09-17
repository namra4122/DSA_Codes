package Stack_Queue;

import static java.util.stream.Collectors.partitioningBy;

class custStack {
    private int[] arr;
    private int top;
    private int capacity;

    public custStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.err.println("STACK FULL");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        System.out.println("POP: " + arr[top]);
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        System.out.println("PEEK: " + arr[top]);
        return arr[top];
    }

    public void search(int t) {
        for (int i = 0; i <= top; i++) {
            if (arr[i] == t) {
                System.out.println("FOUND at " + i);
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}

class custQueue {
    private int[] arr;
    private int start;
    private int end;
    private int countSize;
    private int capacity;

    public custQueue(int size) {
        capacity = size;
        arr = new int[size];
        start = -1;
        end = -1;
        countSize = 0;
    }

    public void add(int i) {
        if (countSize == capacity) {
            System.out.println("QUEUE IS FULL");
            return;
        }

        if (countSize == 0) {
            start = end = 0;
        } else {
            end = (end + 1) % capacity;
        }

        arr[end] = i;
        countSize++;
    }

    public void remove() {
        if (countSize == 0) {
            System.out.println("QUEUE IS EMPTY");
            return;
        }

        if (countSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % capacity;
        }
        countSize--;
        System.out.println("Remove: " + arr[start]);
        return;

    }

    public void top() {
        if (countSize == 0) {
            System.out.println("QUEUE IS EMPTY");
            return;
        }
        System.out.println("TOP: " + arr[start]);
        return;
    }

    public void size() {
        if (countSize == 0) {
            System.out.println("QUEUE IS EMPTY");
            return;
        }
        System.out.println("TOP: " + arr[start]);
        return;
    }

}

public class array_imp {
    public static void main(String[] args) {
        custStack stack = new custStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.search(1);
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("----------------------");
        custQueue queue = new custQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.top();
        queue.remove();
        queue.remove();
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.add(11);
        queue.add(12);

    }
}