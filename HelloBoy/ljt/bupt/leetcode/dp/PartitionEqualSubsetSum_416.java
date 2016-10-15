package ljt.bupt.leetcode.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {
//		int[] nums = { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//				1, 1, 1, 1, 100, 99, 100 };
		int[] nums = {1,2,3,4,4};
		long start = System.currentTimeMillis();
		boolean res = canPartition(nums);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}

	// dp
	private static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 == 1)
			return false;
		else {
			sum /= 2;
			int n = nums.length;
			// dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
			int dp[][] = new int[n][sum + 1];
			// dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
			for (int i = nums[0]; i <= sum; i++) {
				dp[0][i] = nums[0];
			}
			// 遍历n个数字，即视为n个产品
			for (int i = 1; i < n; i++) {
				// 加入了这种物品后更新状态
				for (int j = nums[i]; j <= sum; j++) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
				}
			}
			// 放满了才能表示正好1/2
			if (dp[n - 1][sum] == sum)
				return true;
			else
				return false;
		}
	}

	// 回溯版本2 参照网上写的版本
	private static boolean canPartition2(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 == 1)
			return false;
		sum /= 2;
		return dfs(0, sum, nums);
	}

	public static boolean dfs(int index, int sum, int[] nums) {
		sum -= nums[index];
		if (sum == 0)
			return true;
		for (int i = index + 1; i < nums.length; i++) {
			if (sum < nums[i])
				break;
			if (dfs(i, sum, nums))
				return true;
		}
		return false;
	}

	// 自己写的回溯法1 这道题用回溯法暴力搜索特别耗时
	private static boolean canPartition1(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1)
			return false;
		sum /= 2;

		Arrays.sort(nums);

		// 回溯法搜索是否有几个数字相加等于sum
		boolean[] used = new boolean[nums.length];
		boolean res = backtracking(nums, used, sum, 0);
		return res;
	}

	static boolean flag = false;

	private static boolean backtracking(int[] nums, boolean[] used, int sum, int start) {
		if (sum <= 0) {
			if (sum == 0) {
				flag = true;
				return flag;
			}
			return false;
		}

		for (int i = start; i < nums.length; i++) {
			if (flag) {
				return flag;
			}
			used[i] = true;
			sum -= nums[i];
			backtracking(nums, used, sum, i + 1);
			sum += nums[i];
			used[i] = false;
		}
		return false;
	}

}
