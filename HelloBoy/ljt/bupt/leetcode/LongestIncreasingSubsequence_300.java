package ljt.bupt.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		int[] nums = { 10 };
		int re = lengthOfLIS(nums);
		System.out.println(re);
	}

	private static int lengthOfLIS(int[] nums) {
		if(nums.length==0||nums==null)
			return 0;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		return dp[nums.length - 1];
	}

}
