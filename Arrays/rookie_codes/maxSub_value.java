package Arrays.rookie_codes;

public class maxSub_value {
    static int[] arr1 = { 2, 3, 10, 6, 4, 8, 1 };
    static int[] arr2 = { 30, 10, 8, 2 };

    static void maxSub(int[] arr) {
        int max = 0;
        // brute force
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((arr[j] - arr[i]) > max) {
                    max = (arr[j] - arr[i]);
                }
            }
        }

        // optimal approach
        max = arr[1] - arr[0];
        int minVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        maxSub(arr1);
        maxSub(arr2);
    }
}