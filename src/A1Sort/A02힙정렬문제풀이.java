package A1Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class A02힙정렬문제풀이 {
//    명에의 전당 : 프로그래머스
public int[] solution(int k, int[] score) {
    List<Integer> answer = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

    for (int s : score) {
        pq.add(s);
        if (pq.size() > k) {
            pq.poll(); // 가장 낮은 점수 제거
        }
        answer.add(pq.peek()); // 현재 리더보드 최하 점수 기록
    }

    // List → int[]
    return answer.stream().mapToInt(i -> i).toArray();
}
//    야근지수 : 프로그래머스

    public long solution2(int n, int[] works) {
        long answer = 0;
        Queue<Integer> myQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i=0; i<works.length; i++){
            myQ.add(works[i]);
        }

        while (n>0){
            myQ.add(myQ.poll()-1);
            n--;
        }

        while (!myQ.isEmpty()){
            int temp = myQ.poll();
            if (temp>0) {
                answer += temp * temp;
            }
        }
        return answer;
    }
}
