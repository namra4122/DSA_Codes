package LinkedList;

class Node {
    int val;
    Node next;
    Node prev;

    Node() {
    };

    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    };

    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    };

}

public class doublylinkList {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 8, 9, 5, 10 };

        Node dll = arr2dll(arr);
        System.out.println("BEFORE ANY OPERATION:");
        print(dll);
        System.out.println();
        System.out.println("AFTER DELETE HEAD:");
        dll = deleteHead(dll);
        print(dll);
        System.out.println();
        System.out.println("AFTER DELETE TAIL:");
        dll = deleteTail(dll);
        print(dll);
        System.out.println();
        System.out.println("AFTER DELETE POS:");
        dll = deletePos(dll, 2);
        print(dll);
        System.out.println();
        System.out.println("AFTER DELETE ELE:");
        dll = deleteEle(dll, 8);
        print(dll);
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

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;
        head = head.next;
        head.prev = null;

        return head;

    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        return head;
    }

    private static Node deletePos(Node head, int k) {
        if (head == null)
            return null;

        if (k == 0) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;

            return head;
        }
        Node temp = head;
        int ct = 0;
        while (temp.next != null && ct != k) {
            ct++;
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = temp.prev = null;

        return head;
    }

    private static Node deleteEle(Node head, int i) {
        if (head == null) {
            return null;
        }

        if (head.val == i) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;

            return head;
        }

        Node temp = head;
        while (temp.next != null && temp.val != i) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;

        return head;
    }
}