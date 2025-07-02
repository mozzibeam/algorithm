package A3bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A05비노드형식의최단거리 {
//    숨바꼭질 : 백준
/*
수빈이는 현재 위치 N에 있고, 동생은 K에 있다.
수빈이는 1초에 한 번, 다음 세 가지 중 하나를 할 수 있다:
X - 1로 이동
X + 1로 이동
2 * X로 순간이동
목적: N에서 K로 이동하는 데 걸리는 "최소 시간"을 구하라
*/
    public static void main(String[] args) {
        int max = 100001;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] visited = new int[max];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(visited[current] - 1);
                return;
            }

//            이동 가능한 세 방향
            int[] next = {current - 1, current + 1, current * 2};
            for (int nx : next) {
                if (nx >= 0 && nx < max && visited[nx] == 0) {
                    visited[nx] = visited[current] + 1;
                    queue.offer(nx);
                }
            }
        }
    }
}
