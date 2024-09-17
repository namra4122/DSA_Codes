package Arrays;

import java.util.*;

public class freqArray {
    static int[] arr = { 10, 10, 10, 25, 30, 30 };

    static void freq(int[] arr) {
        Arrays.sort(arr);
        int freq = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                freq++;
            } else {
                System.out.println(arr[i] + "->" + freq);
                freq = 1;
            }
        }
    }

    public static void main(String[] args) {
        freq(arr);
    }
}