package LinkedList;

import java.util.Scanner;

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

public class splitLinkedList {
    private static ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode[] ans = new ListNode[k];
        int spSize = count / k;
        int remSize = count % k;
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode newNode = new ListNode(0);
            ListNode tail = newNode;

            int size = spSize;

            if (remSize > 0) {
                remSize--;
                size++;
            }

            int j = 0;
            while (j < size) {
                tail.next = new ListNode(temp.val);
                tail = tail.next;
                temp = temp.next;
                j++;
            }
            ans[i] = newNode.next;
        }
        return ans;
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ListNode head = arr2ll(arr);

        ListNode[] ans = splitListToParts(head, 5);

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();
    }
}