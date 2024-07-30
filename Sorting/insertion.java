package Sorting;

public class insertion {
    static int[] arr = { 5, 12, 2, 62, 6 };

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sortArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(j - 1, j);
                j--;
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
