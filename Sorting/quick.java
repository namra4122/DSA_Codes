package Sorting;

public class quick {
    static int[] arr = { 1, 23, 4, 56, 7, 89 };

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int piv = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] >= piv && i <= high - 1) {
                i++;
            }
            while (arr[j] < piv && j >= low) {
                j--;
            }

            if (i < j) {
                swap(i, j);
            }
        }

        swap(low, j);

        return j;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
