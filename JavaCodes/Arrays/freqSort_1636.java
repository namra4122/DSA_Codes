//LEETCODE 1636: Sort Array by Increasing Frequency 
package Arrays;

import java.util.*;

public class freqSort_1636 {
    static int[] arr = { 1, 1, 2, 2, 2, 3 };

    static int[] freqSort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> (map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b)));
        pq.addAll(map.keySet());

        int[] res = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll(), freq = map.get(val);
            for (int j = 0; j < freq; j++) {
                res[i++] = val;
            }
        }
        return res;
    }

    static String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort(
                (a, b) -> map.get(b) - map.get(b));

        StringBuilder res = new StringBuilder();
        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int[] res = freqSort(arr);
        String resStr = frequencySort("tree");
        System.err.println(resStr);
        for (int i : res) {
            System.err.print(i + " ");
        }
    }
}
