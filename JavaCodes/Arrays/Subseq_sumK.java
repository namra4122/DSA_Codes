package Arrays;

import java.util.*;;

/**
 * Subseq_sumK
 */
public class Subseq_sumK {
    public static int count = 0;

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 7 };
        numSubseq(arr, 9);
        System.out.println(count);
    }

    private static void numSubseq(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        helper(0, ans, nums, target, 0);
        System.out.println(ans);
    }

    private static void helper(int st, List<Integer> ans, int[] nums, int t, int sum) {
        if (st == nums.length - 1) {
            if (sum == t) {
                count++;
            }
            return;
        }

        ans.add(nums[st]);
        sum += nums[st];
        helper(st + 1, ans, nums, t, sum);
        ans.remove(ans.size() - 1);
        sum -= nums[st];
        helper(st + 1, ans, nums, t, sum);
    }
}