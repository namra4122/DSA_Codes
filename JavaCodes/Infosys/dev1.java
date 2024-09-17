package Infosys;

import java.util.*;
import static java.util.stream.Collectors.toList;

class TreeNode {
    List<Integer> children = new ArrayList<>();
}

public class dev1 {
    public static int get_ans(int n, int m, int cols, List<List<Integer>> edges) {
        List<TreeNode> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new TreeNode());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            tree.get(u).children.add(v);
            tree.get(v).children.add(u);
        }

        int totalUsefulness = 0;
        for (int node = 1; node <= n; node++) {
            totalUsefulness += countDivisibleNodes(tree, node, -1);
        }

        return totalUsefulness - 1;
    }

    private static int countDivisibleNodes(List<TreeNode> tree, int node, int parent) {
        int count = 1; // Count the node itself
        for (int child : tree.get(node).children) {
            if (child != parent && node % child == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());
        int m = Integer.parseInt(scan.nextLine().trim());
        int cols = Integer.parseInt(scan.nextLine().trim());
        List<List<Integer>> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            edges.add(
                    Arrays.asList(scan.nextLine().trim().split(" "))
                            .stream()
                            .map(s -> Integer.parseInt(s))
                            .collect(toList()));
        }
        int result = get_ans(n, m, cols, edges);
        System.out.println(result);
        scan.close();
    }
}