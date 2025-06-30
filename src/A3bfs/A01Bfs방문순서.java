package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
//        방문할 수 있는 점이 여러개인 경우, 정점번호가 작은것을 먼저 방문
//        출발은 0부터 dfs로 방문시 방문순서 : 0->1->2->3->4
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};
//        인접리스트를 활용해서 인접해있는 노드를 빠르게 접근.
        adjList = new ArrayList<>();    //원본 데이터
        visited = new boolean[5];   //방문 여부 확인

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
//            단방향
            adjList.get(nodes[i][0]).add(nodes[i][1]);
//            양방향의 경우
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }
//        정렬번호가 작은것부터 방문하기 위한 정렬
        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0] = true;
        while (!myQueue.isEmpty()) {
            int temp = myQueue.poll();
            System.out.println(temp);
            for (int a : adjList.get(temp)) {
                if (!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true;  //queue에 담는 시점에 true 세팅해야, 중복해서 queue에 안 담김
                }
            }
        }
    }
}
