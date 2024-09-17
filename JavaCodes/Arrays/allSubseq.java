package Arrays;

import java.util.*;

/**
 * allSubseq
 */
public class allSubseq {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(printAll(arr));
    }

    private static List<List<Integer>> printAll(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), arr, 0);
        return ans;
    }

    private static void helper(List<List<Integer>> ans, List<Integer> num, int[] arr, int st) {
        if (st == arr.length) {
            ans.add(new ArrayList<>(num));
            return;
        }
        num.add(arr[st]);
        helper(ans, num, arr, st + 1);
        num.remove(num.size() - 1);
        helper(ans, num, arr, st + 1);
    }
}