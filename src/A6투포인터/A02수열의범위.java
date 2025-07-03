package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A02수열의범위 {
    public static void main(String[] args) {
//        숫자의 표현 : 프로그래머스
//        int n = 15;
//        int start = 1;
//        int end = 1;
//        int total = 1;
//        int count = 0;
//        while (start <= end && end <= n) {
//            if (total == n) {
//                count++;
//                end++;  //또는 start++;
//                total += end;
//            } else if (total < n) {
//                end++;
//                total += end;
//            } else {
//                total -= start;
//                start++;
//            }
//        }
//        System.out.println(count);

//        연속된 부분수열의 합 : 프로그래머스
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int start = 0;
        int end = 0;

        int sum = sequence[0];

        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (start <= end && end < sequence.length) {
            if (sum == k) {
                int len = end - start;
                if (len < minLen) {
                    minLen = len;
                    answer[0] = start;
                    answer[1] = end;
                }
                // 다음 후보를 위해 구간 확장
                end++;
                if (end < sequence.length) sum += sequence[end];
            } else if (sum < k) {
                end++;
                if (end < sequence.length) sum += sequence[end];
            } else { // sum > k
                sum -= sequence[start];
                start++;
                // 포인터 역전 방지
                if (start > end && start < sequence.length) {
                    end = start;
                    sum = sequence[start];
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
