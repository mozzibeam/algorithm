package A6투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class A03두수의합또는차 {
    public static void main(String[] args) {
//        두용액(2470) : 백준
//        int N = 5;  //전체 용액의 수
//        int[] nums = {-2, 4, -99, -1, 98};
//        Arrays.sort(nums);
//
//        int start = 0;
//        int end = nums.length-1;
//        int result = Integer.MAX_VALUE;
//
//        int ans1 = 0;
//        int ans2 = 0;
//        while (start < end) {
//            int total = nums[start] + nums[end];
//
//            if (Math.abs(total) < result) {
//                result = Math.abs(total);
//                ans1 = nums[start];
//                ans2 = nums[end];
//            }
//            if (total < 0) {
//                start++;
//            }else
//                end--;
//        }
//        System.out.println(ans1 + " " + ans2);

//        수고르기 : 백준
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int start = 0;
        int end = 0;
        int minTarget = Integer.MAX_VALUE;

        while (end < N) {
            if (start == end) {
                end++;
                continue;
            }
            int diff = A[end] - A[start];

            if (diff >= M) {
                minTarget = Math.min(minTarget, diff);
                start++;    // 차이 더 줄여보기
            } else {
                end++;
            }
        }
        System.out.println(minTarget);
    }
}
