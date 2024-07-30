package PathFinding;

public class floyWarshall {
    static void getCityWithFewestRead(int n, int[][] distMatrix, int distThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (distMatrix[i][j] <= distThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                cityWithFewestReachable = (cityWithFewestReachable > i) ? (cityWithFewestReachable) : (i);
                fewestReachableCount = reachableCount;
            }
        }

        System.out.println(cityWithFewestReachable);
    }

    static void floyd(int n, int[][] distMatrix) {
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (distMatrix[i][j] > (distMatrix[i][k] + distMatrix[k][j])) {
                        distMatrix[i][j] = distMatrix[i][k] + distMatrix[k][j];
                    }
                }
            }
        }
    }

    static void findShortest(int n, int[][] edges, int distThreshold) {
        int INF = 100000;
        int[][] distMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            distMatrix[i][i] = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                distMatrix[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int w = edges[i][2];

            distMatrix[start][end] = w;
            distMatrix[end][start] = w;
        }

        floyd(n, distMatrix);
        getCityWithFewestRead(n, distMatrix, distThreshold);
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int distanceThreshold1 = 4;

        int n2 = 5;
        int[][] edges2 = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int distanceThreshold2 = 2;

        // findShortest(n1, edges1, distanceThreshold1);
        findShortest(n2, edges2, distanceThreshold2);
    }
}