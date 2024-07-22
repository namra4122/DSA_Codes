package Sorting;

/**
 * bubble
 */
public class bubble {
    static int[] arr = { 5, 12, 2, 62, 6 };

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                swap(i, j);
            }
        }
    }

    public static void main(String[] args) {
        sortArr(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}