package A5dp;

//주워진 데이터를 중복해서 서용할 수 있는지 구분 필요

import java.util.Arrays;
import java.util.Scanner;

public class A05배낭문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        평범한 배낭 : 백준
        String[] line1 = sc.nextLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);
        int[] dp = new int[K + 1];
        Arrays.fill(dp, 0);

        String[] line2;
        int weights, value;
        for (int i = 0; i < N; i++) {
            line2 = sc.nextLine().split(" ");
            weights = Integer.parseInt(line2[0]);
            value = Integer.parseInt(line2[1]);

            for (int j = K; j >= weights; j--) {    //각 물건은 한번만 배낭에 담을 수 있기 때문에 역방향 접근을 해야함
                    dp[j] = Math.max(dp[j], dp[j - weights] + value);
            }
        }
        System.out.println(Arrays.toString(dp));

        int maxValuePackage = 0;
        for (int i = N; i < dp.length; i++) {
            maxValuePackage = Math.max(maxValuePackage, dp[i]);
        }
        System.out.println(maxValuePackage);


//        호텔 : 백준
//        String[] line1 = sc.nextLine().split(" ");
//        int C = Integer.parseInt(line1[0]);
//        int N = Integer.parseInt(line1[1]);
//        int[] dp = new int[C + 101];    //여유공간 확보
//        Arrays.fill(dp, Integer.MAX_VALUE);  //초기값 지정
//        dp[0] = 0;  //고객 0명을 확보하는 데 비용은 0
//
//        String[] line2;
//        int cost, customer;
//        for (int i = 0; i < N; i++) {
//            line2 = sc.nextLine().split(" ");
//            cost = Integer.parseInt(line2[0]);
//            customer = Integer.parseInt(line2[1]);
//            for (int j = customer; j < dp.length; j++) {
//                if (dp[j - customer] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
//                }
//            }
//        }
//
//        int minCost = Integer.MAX_VALUE;
//        for (int i = C; i < dp.length; i++) {
//            minCost = Math.min(minCost, dp[i]);
//        }
//        System.out.println(minCost);
    }
}