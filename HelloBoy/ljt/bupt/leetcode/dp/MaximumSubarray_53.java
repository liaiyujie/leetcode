package ljt.bupt.leetcode.dp;

public class MaximumSubarray_53 {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int res = maxSubArray(nums);
		System.out.println(res);
	}

	
	
//	思路：subarray sum 这种问题就考虑用前n项和。 所以先得到前n项和数组，然后求他们能存在的最大差值。
//	就变成了Best Time to Buy and Sell Stock(121)一样的问题。 从左向右扫描， 更新差值使其保持最大， 
//	然后更新min。
//
//	时间复杂度： O(N)空间复杂度： O(N)
	private static int maxSubArray(int[] nums) {
		// 找到subarray sum 的最大差
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		int min = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i <= nums.length; i++) {
			largest = sum[i] - min > largest ? sum[i] - min : largest;
			min = sum[i] < min ? sum[i] : min;
		}
		return largest;
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
