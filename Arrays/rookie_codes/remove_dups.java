package Arrays.rookie_codes;

public class remove_dups {
    static int[] arr = { 1, 2, 3, 4, 4, 7, 7, 8 };

    static void remove(int[] arr) {
        int i = 0;
        int k = 0;
        int prev = Integer.MIN_VALUE;
        for (; i < arr.length; i++) {
            if (arr[i] != prev) {
                arr[k] = arr[i];
                k++;
                prev = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        remove(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
