package A5dp;

public class A02동전관련 {
    public static void main(String[] args) {
        // 사용할 숫자들 (중복 사용 가능)
        int[] nums = {100, 400, 500};
        int target = 1300;
        // dp[i]는 숫자 i를 만드는 경우의 수
        int[] dp = new int[target + 1];
        // 아무것도 사용하지 않고 0을 만드는 경우의 수는 1가지
        dp[0] = 1;
        // 각 숫자(1, 4, 5)를 사용해서 dp 테이블 갱신
        for (int num : nums) {
            // num부터 target까지 확인
            for (int i = num; i <= target; i++) {
                // i를 만들 수 있는 방법의 수는
                // i - num을 만드는 방법에 num을 추가한 것
                dp[i] += dp[i - num];
            }
        }
        System.out.println("13을 만드는 경우의 수: " + dp[target]);
    }
}
