package A7이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class A02이분탐색활용문제 {
    public static void main(String[] args) {
//        예산 : 백준
//        int[] budgets = {120, 110, 140, 150};
//        int target = 485;
//
//        Arrays.sort(budgets);
//        int start = 0;
//        int end = budgets[budgets.length-1];
//        int answer = 0;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            long sum = 0;
//            for (int b : budgets) {
//                //핵심 코드 : 상한선과 각 국가예산을 비교해서 예산 배정을 상한선을 넘지 않도록 하는 코드
//                sum += Math.min(b, mid);
//            }
//
//            if (sum <= target) {    // sum이 전체예산 target을 넘지 않으면 상한선 +, 아니면 상한선 -
//                answer = mid;
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        System.out.println(answer);

//        과자나눠주기 : 백준 - answer 찾은 후에도 계속 탐색
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int M = Integer.parseInt(line1[0]); //조카의 수
        int N = Integer.parseInt(line1[1]); //과자의 수

        String[] line2 = sc.nextLine().split(" ");
        int[] snacks = new int[N];
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(snacks);

        int start = 1;
        int end = snacks[snacks.length - 1];
        long maxLength = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            long total = 0;
            for (int snack : snacks) {
                total += snack / mid;
            }

            if (total >= M) {
//                maxLength = total;
                maxLength = mid;    //과자수가 아니라 나눈 최대길이를 저장
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(maxLength);


//        입국심사 : 백준
    }
}
