package Arrays;

public class largest_num {
    static int maxVal(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static int secondLarge(int[] arr) {
        int max = 0;
        int secMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secMax = max;
                max = Math.max(max, arr[i]);
            }
        }
        return secMax;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 52, 5, 1, 5, 3, 5 };
        System.out.println(maxVal(arr));
        System.out.println(secondLarge(arr));
    }
}
