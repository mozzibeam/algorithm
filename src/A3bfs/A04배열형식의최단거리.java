package A3bfs;

import java.util.*;

public class A04배열형식의최단거리 {
    public static void main(String[] args) {
//        게임 맵 최단거리 : 프로그래머스
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};

        Queue<int[]> myQueue = new LinkedList<>();
        int[][] distance = new int[maps.length][maps[0].length];
        myQueue.add(new int[]{0, 0});
        distance[0][0] = 1;
        while (!myQueue.isEmpty()) {
            int[] current = myQueue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && distance[nx][ny] == 0) { //이동해야 되는 경로가 벽인지 그리고 이미 들렀던 곳인지 검사
                        distance[nx][ny] = distance[x][y] + 1;
                        myQueue.add(new int[]{nx, ny});
                    }
                }
            }
        }
//        int max = Arrays.stream(distance).flatMapToInt(Arrays::stream).max().getAsInt(); //2차원 배열을 평탄화하여 stream 두번으로 max 색출
        int max = 0;
        for (int i = 0; i < distance.length; i++) { // 이중 for문을 돌면서 max값 찾기
            for (int j = 0; j < distance[0].length; j++) {
                max = Math.max(max, distance[i][j]);
            }
        }
        System.out.println(max);
    }
}
