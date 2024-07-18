package Arrays.rookie_codes;

public class check_sort {
    static void check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[i + 1]) {
                System.out.println("NOT SORTED");
                return;
            }
            System.out.println("SORTED");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 3 };
        check(arr);
    }
}
