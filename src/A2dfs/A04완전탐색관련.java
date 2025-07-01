package A2dfs;

import java.util.HashSet;
import java.util.Set;

public class A04완전탐색관련 {
    static int[][] arr = {{1,1,1,1,1},
                          {1,1,1,1,1},
                          {1,1,1,1,1},
                          {1,1,1,2,1},
                          {1,1,1,1,1}};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Set<String> dfsSet = new HashSet<>();
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, String.valueOf(arr[i][j]));
            }
        }
        System.out.println(dfsSet);
        System.out.println(dfsSet.size());
//        피로도 : 프로그래머스 - 백트래킹
    }

    static void dfs(int x, int y, int depth, String path) {
        if (depth == 6) {
            dfsSet.add(path);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                dfs(nx, ny, depth + 1, path + arr[nx][ny]);
            }
        }
    }
}
