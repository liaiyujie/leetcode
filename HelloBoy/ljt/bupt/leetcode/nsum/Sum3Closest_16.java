package ljt.bupt.leetcode.nsum;

import java.util.Arrays;

public class Sum3Closest_16 {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		int target = 1;
		int res = threeSumClosest(nums, target);
		System.out.println(res);
	}

	// My solution does not need compare each sum ,just need to compare possible
	// sum ,so can save time.
	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		int low, high;
		for (int i = 0; i < nums.length - 1; i++) {
			low = i + 1;
			high = nums.length - 1;
			while (low < high) {
				if (nums[low] + nums[high] == target - nums[i])
					return target;
				else if (nums[low] + nums[high] > target - nums[i]) {
					while (low < high && nums[low] + nums[high] > target - nums[i])
						high--;
					if (Math.abs(nums[i] + nums[low] + nums[high + 1] - target) < Math.abs(closest - target))
						closest = nums[i] + nums[low] + nums[high + 1];
				} else {
					while (low < high && nums[low] + nums[high] < target - nums[i])
						low++;
					if (Math.abs(nums[i] + nums[low - 1] + nums[high] - target) < Math.abs(closest - target))
						closest = nums[i] + nums[low - 1] + nums[high];
				}
			}
		}
		return closest;
	}

	// two points
	private static int threeSumClosest2(int[] nums, int target) {
		if (nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int closet = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				if (nums[i] + nums[start] + nums[end] < target) {
					// 找到一个更加接近的
					if (Math.abs(nums[i] + nums[start] + nums[end] - target) < closet) {
						closet = Math.abs(nums[i] + nums[start] + nums[end] - target);
						sum = nums[i] + nums[start] + nums[end];
					}
					start++;
				} else {
					if (Math.abs(nums[i] + nums[start] + nums[end] - target) < closet) {
						closet = Math.abs(nums[i] + nums[start] + nums[end] - target);
						sum = nums[i] + nums[start] + nums[end];
					}
					end--;
				}
			}
		}
		return sum;
	}

	// 用回溯法暴力搜索
	private static int threeSumClosest1(int[] nums, int target) {
		int sum = 0;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtracking(sum, used, nums, target, target - sum, 0, 0);
		return sum;
	}

	private static void backtracking(int sum, boolean[] used, int[] nums, int target, int closet, int depth,
			int start) {
		if (depth == 3) {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					sum += nums[i];
			}

		}

	}

}
