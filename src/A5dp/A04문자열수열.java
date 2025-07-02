import java.util.*;

public class A04문자열수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] trace = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            dp[i] = 1;
            trace[i] = -1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    trace[i] = j;
                }
            }
        }

        int maxLen = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (maxIndex != -1) {
            list.add(A[maxIndex]); // 수열 원소 출력
            maxIndex = trace[maxIndex];
        }

        Collections.reverse(list);

        System.out.println("길이: " + maxLen);
        System.out.println("수열: " + list);
    }
//    import java.io.*;
//import java.util.*;
//
//    public class Ex14002 {
//        public static void main(String[] args) throws IOException {
//            // 입력 처리
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine()); // 수열 길이
//            int[] A = new int[N];                    // 원본 수열
//            int[] dp = new int[N];                   // dp[i]: A[i]까지의 LIS 길이
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            for (int i = 0; i < N; i++) {
//                A[i] = Integer.parseInt(st.nextToken());
//                dp[i] = 1; // 자기 자신만으로도 길이 1의 수열 가능
//            }
//
//            // LIS DP 계산 (O(N^2))
//            for (int i = 1; i < N; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (A[j] < A[i]) { // 증가하는 조건
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//            }
//
//            // 가장 긴 부분 수열의 길이와 마지막 원소 인덱스 탐색
//            int answer = 0;
//            for (int i = 0; i < N; i++) {
//                answer = Math.max(answer, dp[i]);
//            }
//
//            // 가장 긴 수열 역추적 (뒤에서부터 dp 값 감소 확인)
//            Stack<Integer> progression = new Stack<>();
//            int len = answer;
//            for (int i = N - 1; i >= 0; i--) {
//                // 1. 현재 위치의 dp값이 len과 같고
//                // 2. progression이 비어있거나, 현재 값이 그 위에 올 값보다 작아야 함 (증가 수열 조건 보장)
//                if (dp[i] == len && (progression.isEmpty() || A[i] < progression.peek())) {
//                    progression.push(A[i]);
//                    len--;
//                }
//            }
//
//            // 결과 출력
//            System.out.println(answer); // LIS 길이
//            while (!progression.isEmpty()) {
//                System.out.print(progression.pop() + " "); // LIS 수열 출력
//            }
//        }
}
