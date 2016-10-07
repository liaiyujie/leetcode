package ljt.bupt.leetcode.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_18 {

	public static void main(String[] args) {
		// int[] nums = { -500, -495, -489, -472, -466, -449, -439, -435, -435,
		// -413, -406, -381, -369, -353, -335, -311,
		// -306, -260, -258, -231, -205, -189, -180, -165, -165, -164, -146,
		// -141, -126, -121, -116, -100, -83,
		// -23, -17, 18, 53, 65, 91, 124, 139, 140, 164, 168, 200, 202, 211,
		// 216, 221, 224, 249, 251, 280, 282,
		// 300, 314, 323, 348, 355, 373, 401, 416, 428, 443, 443, 445, 462, 491,
		// 497 };
		// int target = -1864;
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		long startTime = System.currentTimeMillis();
		List<List<Integer>> res = fourSum(nums, target);
		for (List<Integer> l : res)
			System.out.println(l);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
	
//	The first time win over 100%. Basic idea is using subfunctions for 3sum and 2sum, and keeping throwing all impossible cases. 
//	O(n^3) time complexity, O(1) extra space complexity.
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}
	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public static void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}

	private static List<List<Integer>> fourSum3(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return result;
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) { // 4sum
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip
			int target1 = target - nums[i];
			for (int j = i + 1; j < len - 2; j++) { // 3sum
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue; // skip
				int target2 = target1 - nums[j];
				int k = j + 1, m = len - 1;
				while (k < m) { // 2sum
					if (nums[k] + nums[m] == target2) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
						while (k < m && nums[k + 1] == nums[k])
							k++; // skip
						while (k < m && nums[m - 1] == nums[m])
							m--; // skip
						k++;
						m--;
					} else if (nums[k] + nums[m] < target2)
						k++;
					else
						m--;

				}
			}
		}
		return result;
	}

	private static List<List<Integer>> fourSum2(int[] nums, int target) {
		// 先用两重循环定下两个数，然后在剩下的找两个数
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		if (nums.length < 4)
			return res;
		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
						int sum = nums[i] + nums[j];
						int start = j + 1;
						int end = nums.length - 1;
						while (start < end) {
							if (sum + nums[start] + nums[end] == target) {
								List<Integer> tmp = new ArrayList<>();
								tmp.add(nums[i]);
								tmp.add(nums[j]);
								tmp.add(nums[start]);
								tmp.add(nums[end]);
								res.add(tmp);
								while (start < end && nums[start] == nums[start + 1])
									start++;
								while (start < end && nums[end] == nums[end - 1])
									end--;
								start++;
								end--;
							} else if (sum + nums[start] + nums[end] < target) {
								start++;
							} else {
								end--;
							}
						}
					}
				}
			}

		}

		return res;
	}

	// 这道题 用回溯法超时o(╯□╰)o
	private static List<List<Integer>> fourSum1(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		boolean[] used = new boolean[nums.length];

		backtracking(res, list, used, nums, target, 0, 0, 0);

		return res;
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, boolean[] used, int[] nums,
			int target, int depth, int sum, int start) {
		if (depth == 4) {
			if (sum == target) {
				List<Integer> tmp = new ArrayList<>(list);
				res.add(tmp);
			}
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
				continue;
			used[i] = true;
			sum += nums[i];
			list.add(nums[i]);
			backtracking(res, list, used, nums, target, depth + 1, sum, i + 1);
			sum -= nums[i];
			list.remove(list.size() - 1);
			used[i] = false;
		}

	}

}
