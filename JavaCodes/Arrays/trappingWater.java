package Arrays;

public class trappingWater {
    static int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    // brute-force -> T: O(n^2) space: O(1)
    static void sol1(int[] height) {
        int collect = 0;

        for (int i = 0; i < height.length; i++) {
            int lH = 0;
            int rH = 0;

            for (int j = i; j >= 0; j--) {
                lH = Math.max(height[j], lH);
            }

            for (int j = i; j < height.length; j++) {
                rH = Math.max(height[j], rH);
            }

            collect += Math.min(lH, rH) - height[i];
        }

        System.err.println("Water Collected is: " + collect);
    }

    // Time Optimal soultion -> T: O(3*N) space: O(2*N)
    static void sol2(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0]; // leftMax of first element of height is itself
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1]; // rightMax of last element of height is itself
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int collect = 0;
        for (int i = 0; i < height.length; i++) {
            collect += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.err.println("Water Collected is: " + collect);
    }

    // Two-pointer optimal solution -> T: O(N) space: O(1)
    static void sol3(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int collect = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    collect += (leftMax - height[l]);
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    collect += (rightMax - height[r]);
                }
                r--;
            }
        }
        System.err.println("Water Collected is: " + collect);
    }

    public static void main(String[] args) {
        // sol1(height);
        // sol2(height);
        sol3(height);
    }
}
