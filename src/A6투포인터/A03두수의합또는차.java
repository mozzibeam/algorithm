package A6투포인터;

import java.util.Arrays;
import java.util.Map;

public class A03두수의합또는차 {
    public static void main(String[] args) {
//        두용액(2470) : 백준
        int N = 5;  //전체 용액의 수
        int[] nums = {-2, 4, -99, -1, 98};
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        int result = Integer.MAX_VALUE;

        int ans1 = 0;
        int ans2 = 0;
        while (start < end) {
            int total = nums[start] + nums[end];

            if (Math.abs(total) < result) {
                result = Math.abs(total);
                ans1 = nums[start];
                ans2 = nums[end];
            }
            if (total < 0) {
                start++;
            }else
                end--;
        }
        System.out.println(ans1 + " " + ans2);

//        수고르기 : 백준
    }
}
