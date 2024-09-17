package Arrays;

public class rotate {
    static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

    static void left_rotate(int[] arr) {
        int ele = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = ele;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void d_left_rotate(int[] arr, int d) {
        // BruteForce
        for (int i = 0; i < d; i++) {
            left_rotate(arr);
        }

        // Optimal Approach
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        // left_rotate(arr);
        d_left_rotate(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}