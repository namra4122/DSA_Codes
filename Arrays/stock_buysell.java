package Arrays;

public class stock_buysell {
    static int[] arr = { 7, 6, 4, 3, 1 };

    // brute-force
    static void maxProfit(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if ((arr[j] - arr[i]) > max) {
                    max = arr[j] - arr[i];
                }
            }
        }

        System.err.println("Profit: " + max);
    }

    // optimal
    static void optimalProfit(int[] arr) {
        int maxPro = 0;
        int minEle = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minEle = Math.min(minEle, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minEle);
        }

        System.err.println("Max: " + maxPro);
    }

    public static void main(String[] args) {
        // maxProfit(arr);
        optimalProfit(arr);
    }
}
