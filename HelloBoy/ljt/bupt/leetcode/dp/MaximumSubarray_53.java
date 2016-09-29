package ljt.bupt.leetcode.dp;

public class MaximumSubarray_53 {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int res = maxSubArray(nums);
		System.out.println(res);
	}

	private static int maxSubArray(int[] nums) {
		
		return 0;
	}

	// 使用数学分析出来的贪心规律
	private static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int sum = 0, maxSub = Integer.MIN_VALUE;
		for (int num : nums) {
			// drop negtive sum
			sum = Math.max(sum, 0);
			sum += num;
			// update maxSub
			maxSub = Math.max(maxSub, sum);
		}

		return maxSub;
	}

	// 先用暴力求解 O(n2) 93ms
	private static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
			sum = 0;
		}

		return max;
	}

}
