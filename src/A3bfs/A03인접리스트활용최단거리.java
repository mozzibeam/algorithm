package A3bfs;

import java.util.*;

public class A03인접리스트활용최단거리 {
    static int[] distance;

    public static void main(String[] args) {
        int n = 6; // 전체 노드 수
        int[][] nodes = { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2} };

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : nodes) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); // 양방향
        }

        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.get(current)) {
                if (distance[neighbor] == -1) {
                    queue.add(neighbor);
                    distance[neighbor] = distance[current] + 1;
                }
            }
        }

        int max = Arrays.stream(distance).max().getAsInt();
        long count = Arrays.stream(distance).filter(d -> d == max).count();

        System.out.println("거리 배열: " + Arrays.toString(distance));
        System.out.println("가장 먼 노드 개수: " + count);
    }
}
