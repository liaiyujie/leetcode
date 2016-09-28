package ljt.bupt.leetcode;

import java.util.Arrays;

public class LISProblemTest {

	public static void main(String[] args) {
		int[] nums = {300,207,155,300,299,170,158,65};
		int re = DP_LIS(nums);
		System.out.println(re);
	}

	private static int DP_LIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len+1];
		for(int i =0; i<len ;i++){
			int tmax = 1;
			for(int j = 0;j<i;j++){
				if(nums[j]>=nums[i]){
					tmax = Math.max(tmax, dp[j]+1);
				}
			}
			dp[i]= tmax;
		}
		Arrays.sort(dp);
		return dp[len];
	}
}
