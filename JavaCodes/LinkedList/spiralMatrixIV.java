package LinkedList;

import java.util.*;

// Definition for singly-linked list.
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

public class spiralMatrixIV {

    public static void main(String[] args) {
        int[] arr = { 3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 };
        ListNode head = arr2ll(arr);

        spiralMatrix(3, 5, head);
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

    private static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }
        ListNode temp = head;
        int l = 0, r = n - 1;
        int t = 0, b = m - 1;

        while (l <= r && t <= b) {
            // l -> r
            for (int i = l; i <= r; i++) {
                ans[t][i] = temp.val;
                temp = temp.next;
            }
            t++;
            // t -> b
            for (int i = t; i <= b; i++) {
                ans[i][r] = temp.val;
                temp = temp.next;
            }
            r--;

            // r -> l
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    ans[b][i] = temp.val;
                    temp = temp.next;
                }
                b--;
            }

            // b -> t
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    ans[i][l] = temp.val;
                    temp = temp.next;
                }
                l++;
            }
        }

        return ans;
    }
}