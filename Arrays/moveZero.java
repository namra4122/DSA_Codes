package Arrays;

public class moveZero {
    static int arr[] = { 1, 2, 3, 5, 4, 0, 0, 6 };

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void move(int[] arr) {
        int i = 0;
        int k = 0;

        for (; i < arr.length; i++) {
            if (arr[i] == 0 && arr[k] == 0) {
                continue;
            } else if (arr[i] != 0 && arr[k] == 0) {
                swap(i, k);
                k++;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        move(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}