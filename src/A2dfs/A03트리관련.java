package A2dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A03트리관련 {
//    트리의부모찾기 : 백준
//    방문 여부 체크 배열
    static boolean[] visited;

//   인접 리스트로 트리 표현 (1번 노드부터 사용)
    static List<List<Integer>> adjList;

//    각 노드와 부모 노드를 저장
    static int[] parent;

    public static void main(String[] args) {
        adjList = new ArrayList<>();
        visited = new boolean[8];   // 노드 번호는 1~7까지 사용 (0번 미사용)
        parent = new int[8];    // 부모 노드 결과 저장
//
////        트리 간선 정보
        int[][] nodes = {{1, 6}, {6, 3}, {3, 5}, {4, 1}, {2, 4}, {4, 7}};
//
////        인접 리스트 초기화 (노드 수 + 1만큼 리스트 생성
        for (int i = 0; i <= 7; i++) {
            adjList.add(new ArrayList<>());
        }
//
////        무방향 그래프이므로 양쪽에 모두 간선 추가
        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }
//
////        1번 노드를 루트로 DFS시작
//        dfs(1);

//        1번 노드를 루트로 BFS시작
        bfs(1);
//
////        부모 정보 출력 (2번 노드부터 출력, 1번은 루트)
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
//    }
//
//    static void dfs(int current) {
//        visited[current] = true; // 방문하는 노드 표시
////        현재 노드에 인접한 노드 순회하여 접근
//        for (int neighbor : adjList.get(current)) {
//            if (!visited[neighbor]) {   // 인접 노드 방문 여부 확인
//                parent[neighbor] = current; // 현재 노드가 인접 노드의 부모인 것을 저장
//                dfs(neighbor);  // 재귀 호출로 다음 노드 탐색
//            }
//        }
    }

    static void bfs(int start) {
        Queue<Integer> myQueue = new LinkedList<>();
        visited[start] = true;
        myQueue.add(start);
        while (!myQueue.isEmpty()) {
            int current = myQueue.poll();
            for (int a : adjList.get(current)) {
                if (!visited[a]) {
                    parent[a] = current;    // 부모 노드 등록
                    myQueue.add(a); // 다음 탐색 대상 추가
                    visited[a] = true;  // 방문 표시(재탐색 방지)
                }
            }
        }
    }
}
