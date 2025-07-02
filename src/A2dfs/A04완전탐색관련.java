package A2dfs;

import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class A04완전탐색관련 {
    static int[][] arr = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 2, 1},
            {1, 1, 1, 1, 1}};
    //    방향 벡터 : 상, 하, 우, 좌
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    //    중복 제거를 위한 Set : 6자리 숫자 문자열 저장
    static Set<String> dfsSet = new HashSet<>();
    static Set<String> bfsSet = new HashSet<>();

    public static void main(String[] args) {
//        숫자판점프 : 백준 - DFS, 상하좌우
//        int[][] arr = {{1,1,1,1,1},
//                       {1,1,1,1,1},
//                       {1,1,1,1,1},
//                       {1,1,1,2,1},
//                       {1,1,1,1,1}};
//        int[] current = {1, 1};
//        위로 이동
//        int[] up = {current[0] - 1, current[1]};
//        아래로 이동
//        int[] down = {current[0] + 1, current[1]};
        //        왼쪽 이동
//        int[] left = {current[0], current[1] - 1};
        //        오른쪽 이동
//        int[] right = {current[0], current[1] + 1};
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, 1, -1};
//        for (int i = 0; i < 4; i++) {
//            int nx = current[0] + dx[i];
//            int ny = current[1] + dy[i];
//            System.out.println(nx + " " + ny);
//        }
//        모든 좌표 (i, j)에서 DFS 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
//                시작 좌표 (i, j), 깊이 1, 경로 문자열 초기값은 현재 숫자
                dfs(i, j, 1, String.valueOf(arr[i][j]));
            }
        }
        System.out.println(dfsSet);
        System.out.println(dfsSet.size());  // 서로 다른 모든 6자리 수 개수

//        bfs 풀이법 : DFS에서 재귀로 넘기던 매개변수의 필요성은 동일하다.
//        BFS에선 큐에 담긴 객체 속 필드로 옮겨갈 뿐이다.
        Queue<Node> myQueue = new LinkedList<>();

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
//                시작 좌표 (x, y), 깊이 1, 경로 문자열 초기값은 현재 숫자
                myQueue.offer(new Node(x, y, 1, String.valueOf(arr[x][y])));
                while (!myQueue.isEmpty()) {
                    Node current = myQueue.poll();
                    if (current.depth == 6) {
                        bfsSet.add(current.path);
                        continue;
                    }
                    
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = current.x + dx[dir];
                        int ny = current.y + dy[dir];
                        if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                            myQueue.offer(new Node(nx, ny, current.depth + 1, current.path + arr[nx][ny]));
                        }
                    }
                }
            }
        }
        System.out.println(bfsSet);
        System.out.println(bfsSet.size());
//        피로도 : 프로그래머스 - 백트래킹
        class Solution {
            static boolean[] visited;
            static int answer;

            public int solution(int k, int[][] dungeons) {
                visited = new boolean[dungeons.length];
                answer = 0;

                dfs(0, k, dungeons);  // depth = 0부터 시작

                return answer;
            }

            static void dfs(int depth, int fatigue, int[][] dungeons) {
                // 현재까지 탐험한 던전 수(depth)를 최대값으로 갱신
                answer = Math.max(answer, depth);

                for (int i = 0; i < dungeons.length; i++) {
                    int minNeed = dungeons[i][0]; // 최소 필요 피로도
                    int cost = dungeons[i][1];    // 소모 피로도

                    // 아직 방문 안 했고, 현재 피로도로 갈 수 있는 던전이라면
                    if (!visited[i] && fatigue >= minNeed) {
                        visited[i] = true;                         // 방문 체크
                        dfs(depth + 1, fatigue - cost, dungeons); // 다음 던전 탐색
                        visited[i] = false;                        // 백트래킹
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, depth;
        String path;

        Node(int x, int y, int depth, String path) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.path = path;
        }
    }

    static void dfs(int x, int y, int depth, String path) {
//        6자리 완성되면 Set에 추가 후 종료
        if (depth == 6) {
            dfsSet.add(path);
            return;
        }
//        상하좌우 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 다음 x 좌표
            int ny = y + dy[i]; // 다음 y 좌표
//            범위 안이면 DFS 계속 진행
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
//                현재 경로에 다음 숫자 추가하고 깊이 1 증가
                dfs(nx, ny, depth + 1, path + arr[nx][ny]);
            }
        }
    }
}