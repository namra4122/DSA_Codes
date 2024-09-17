package Arrays;

public class reverse_arr {
    static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    // TWO POINTER APPROACH
    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(int[] arr) {
        int r = arr.length - 1;
        int l = 0;
        while (l <= r) {
            swap(r, l);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        reverse(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}