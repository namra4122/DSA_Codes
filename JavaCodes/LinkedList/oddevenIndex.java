package LinkedList;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class oddevenIndex {

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 2, 5, 6 };
        int[] arr2 = { 2, 1, 3, 5, 6, 4, 7 };

        ListNode head1 = arr2ll(arr1);
        ListNode head2 = arr2ll(arr2);

        ListNode ans = oddevenGrp(head2);
        print(ans);
    }

    private static ListNode arr2ll(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    private static ListNode oddevenGrp(ListNode head) {
        // Approach 1: TC O(n) SC O(n)
        // List<Integer> list = new ArrayList<Integer>();
        // // odd loop
        // ListNode temp = head;
        // while (temp != null && temp.next != null) {
        // list.add(temp.val);
        // temp = temp.next.next;
        // }
        // if (temp != null) {
        // list.add(temp.val);
        // }
        // // even loop
        // temp = head.next;
        // while (temp != null && temp.next != null) {
        // list.add(temp.val);
        // temp = temp.next.next;
        // }
        // if (temp != null) {
        // list.add(temp.val);
        // }
        // System.out.println(list);

        // Approach 2: TC O(n/2) SC 0(1)
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        // bcoz even is always ahead of odd
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}