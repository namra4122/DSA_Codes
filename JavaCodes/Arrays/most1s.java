package Arrays;

public class most1s {
    static int[] arr = { 1, 1, 0, 1, 1, 0, 1 };

    static void count(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i : arr) {
            count = (i == 1) ? (count + 1) : (0);
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        count(arr);
    }
}
