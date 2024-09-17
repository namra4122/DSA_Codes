package LinkedList;

/**
 * reverseDll
 */

class Node {
    int val;
    Node next;
    Node prev;

    Node() {
    }

    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class reverseDll {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 8, 9, 5, 10 };
        Node head = arr2dll(arr);
        System.out.println("BEFORE REVERSE");
        print(head);
        System.out.println();
        Node revHead = reverse(head);
        System.out.println("AFTER REVERSE");
        print(revHead);
        System.out.println();
    }

    private static Node arr2dll(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + "<=>");
            head = head.next;
        }
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node last = null;
        Node i = head;

        while (i != null) {
            last = i.prev;
            i.prev = i.next;
            i.next = last;
            i = i.prev;
        }

        return last.prev;
    }
}