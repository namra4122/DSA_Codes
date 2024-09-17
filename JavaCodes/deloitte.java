// import java.util.HashMap;

// public class deloitte {
//     private static void magicNum(int n, int[] arr) {
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == j)
//                     continue;

//                 HashMap<Integer, Integer> map = new HashMap<>();
//                 int n1 = arr[i];
//                 int n2 = arr[j];

//                 while (n1 > 0) {
//                     int temp = n1 % 10;
//                     map.put(temp, map.getOrDefault(temp, 0) + 1);
//                     n1 = n1 / 10;
//                 }

//                 while (n2 > 0) {
//                     int temp = n2 % 10;
//                     map.put(temp, map.getOrDefault(temp, 0) + 1);
//                     n2 = n2 / 10;
//                 }

//                 for (int k : map.values()) {
//                     if (k > 1) {
//                         count++;
//                     }
//                 }
//             }
//         }

//         System.out.println(count);
//     }

//     public static void main(String[] args) {
//         int[] arr1 = { 5, 12, 34, 4, 678 }; // 1
//         int[] arr2 = { 15, 12, 34, 45, 67, 85 }; // 5

//         magicNum(arr1.length, arr1);
//         magicNum(arr2.length, arr2);
//     }
// }

import java.util.Arrays;

public class deloitte {
    public static int countCommonDigits(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        return (int) Arrays.stream(strA.split("")).filter(c -> strB.indexOf(c) != -1).count();
    }

    public static int findMagicNumbers(int[] nums) {
        Arrays.sort(nums);
        int magicCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int commonDigits = countCommonDigits(nums[i], nums[i + 1]);
            if (commonDigits > 0) {
                magicCount++;
            }
        }
        return magicCount;
    }

    public static void main(String[] args) {
        System.out.println(findMagicNumbers(new int[] { 5, 12, 34, 4, 678 })); // Output: 1
        System.out.println(findMagicNumbers(new int[] { 15, 12, 34, 45, 67, 85 })); // Output: 5
    }
}