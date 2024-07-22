package Searching;

import java.util.*;

public class binarySearch {
    static int[] arr = { 4, 5, 6, 7, 0, 1, 2 };

    static void bSearch(int[] arr, int target) {
        Arrays.sort(arr); // Array must be sorted
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            /*
             * one way to find mid It fails for large values of l and r. it fails if the sum
             * of l and r is greater than the 2^31 - 1
             */
            // int mid = (l + r) / 2;

            /*
             * other way of finding mid works for all large l and r
             */
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                System.out.println("miracle miracle milgya milgya -> Index: " + mid);
                return;
            }
            if (target > mid) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }

    // l and r isliye pass kiya bcoz recursion hai
    static int recursive_bsearch(int[] arr, int l, int r, int target) {
        // base case
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            System.out.println("miracle miracle milgya milgya -> Index: " + mid);
            return 1;
        } else if (arr[mid] > target) {
            recursive_bsearch(arr, l, mid - 1, target);
        } else {
            recursive_bsearch(arr, mid + 1, r, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        bSearch(arr, 0);
        recursive_bsearch(arr, 0, arr.length - 1, 25);
    }
}