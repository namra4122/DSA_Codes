package Arrays.rookie_codes;

import java.util.*;

public class leader {
    static int arr[] = { 10, 2, 2, 4, 4, 6, 6, 2, 2, 1 };

    static void find_lead(int[] arr) {
        List<Integer> lead_arrlist = new ArrayList<Integer>();
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                lead_arrlist.add(arr[i]);
                max = arr[i];
            }
        }

        System.out.print(lead_arrlist);
    }

    public static void main(String[] args) {
        find_lead(arr);
    }
}
