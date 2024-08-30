package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class singlelinkList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int arr[] = new int[n];

        // for (int i = 0; i < n; i++) {
        // arr[i] = scan.nextInt();
        // }

        Node y = arr2ll(new int[] { 9, 8, 7, 6, 5, 4, 3 });
        // Length
        System.out.println(llLength(y));
        // search
        System.out.println(search(y, 6));
        System.out.println("BEFORE");
        print(y);
        // delete
        y = deleteHead(y);
        System.out.println("AFTER REMOVING HEAD");
        print(y);

        y = deleteTail(y);
        System.out.println("AFTER REMOVING TAIL");
        print(y);

        y = deletePos(y, 2);
        System.out.println("AFTER REMOVING POS");
        print(y);

        y = deleteEle(y, 7);
        System.out.println("AFTER REMOVING ELE");
        print(y);

        // insert
        y = insertHead(y, 9);
        System.out.println("AFTER ADDING HEAD");
        print(y);

        y = insertTail(y, 3);
        System.out.println("AFTER ADDING TAIL");
        print(y);

        y = insertPos(y, 2, 6);
        System.out.println("AFTER ADDING POS");
        print(y);

        y = insertEle(y, 6, 7);
        System.out.println("AFTER ADDING ELE");
        print(y);
        scan.close();
    }

    private static void print(Node head) {
        // traverse
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node arr2ll(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static int llLength(Node head) {
        Node temp = head;
        int ct = 0;
        while (temp != null) {
            ct++;
            temp = temp.next;
        }

        return ct;
    }

    private static String search(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                return "FOUND";
            }
            temp = temp.next;
        }

        return "NOT FOUND";
    }

    private static Node deleteHead(Node head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head) {

        if (head == null || head.next == null)
            return head;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;

    }

    private static Node deletePos(Node head, int k) {
        if (head == null)
            return head;

        if (k == 0) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        int ct = -1;

        while (temp != null) {
            ct++;
            if (ct == k) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    private static Node deleteEle(Node head, int k) {
        if (head == null)
            return head;

        if (head.data == k) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == k) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    private static Node insertHead(Node head, int num) {
        Node temp = new Node(num);
        temp.next = head;
        return temp;
    }

    private static Node insertTail(Node head, int num) {
        if (head == null) {
            Node temp = new Node(num);
            return temp;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node y = new Node(num);
        temp.next = y;
        return head;

    }

    private static Node insertPos(Node head, int k, int num) {
        if (head == null) {
            if (k == 0) {
                Node temp = new Node(num);
                return temp;
            } else {
                System.out.println("GIVE CORRECT K");
                return new Node();
            }
        }

        if (k == 0) {
            Node temp = new Node(num, head);
            return temp;
        }

        Node temp = head;
        int ct = -1;

        while (temp != null) {
            ct++;
            if (ct == k - 1) {
                Node y = new Node(num, temp.next);
                temp.next = y;
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    private static Node insertEle(Node head, int k, int num) {
        if (head == null)
            return null;

        if (head.data == k) {
            return new Node(num, head);
        }

        Node temp = head;
        while (temp != null) {
            if (temp.next.data == k) {
                Node y = new Node(num, temp.next);
                temp.next = y;
                return head;
            }
            temp = temp.next;
        }

        return head;
    }
}