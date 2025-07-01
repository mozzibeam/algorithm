package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A03트리관련 {
//    트리의부모찾기 : 백준
    static boolean[] visited;
    static List<List<Integer>> adjList;
    static int[] parent;
    public static void main(String[] args) {
        adjList = new ArrayList<>();
        visited = new boolean[8];
        parent = new int[8];
        int[][] nodes = {{1, 6}, {6, 3}, {3, 5}, {4, 1}, {2, 4}, {4, 7}};

        for (int i = 0; i <= 7; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int current) {
        visited[current] = true;
        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                parent[neighbor] = current;
                dfs(neighbor);
            }
        }
    }
}
