package Searching;

public class twoPointer {
    static int[] arr = { 2, 5, 6, 0, 0, 1, 2 };

    static boolean twoPointer_search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (arr[l] == target) {
                return true;
            } else if (arr[r] == target) {
                return true;
            } else {
                l++;
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        twoPointer_search(arr, 0);
    }
}
