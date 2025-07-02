package A5dp;

import java.util.Arrays;

public class A01계단관련 {
    public static void main(String[] args) {
//        멀리 뛰기 : 프로그래머스
//        int n = 4;
//        int[] sector = new int[n];
//        long answer = 0;
//        sector[0] = 1;
//        sector[1] = 2;
//        for (int i = 2; i < n; i++) {
//            sector[i] = sector[i - 1] + sector[i - 2];
//        }
//        System.out.println(sector[n-1]);
//        answer = sector[n-1] % 1234567;
//        System.out.println(answer);

//        계단오르기 : 백준
//        계단의 개수 n
        int n = 6;
        int[] arr = {0, 10, 20, 15, 25, 10, 20,};
        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        if (n == 1) {
            maxArr[1] = arr[1];
        } else if (n == 2) {
            maxArr[2] = arr[1] + arr[2];
        } else {
            maxArr[1] = arr[1];
            maxArr[2] = arr[1] + arr[2];
            for (int i = 0; i < maxArr.length; i++) {
                int a = maxArr[i - 2] + arr[i];
                int b = maxArr[i - 3] + arr[i - 1] + arr[i];
                maxArr[i] = Math.max(a, b);
            }
        }
        System.out.println(Arrays.toString(maxArr));
    }
}
