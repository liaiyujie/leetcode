package ljt.bupt.leetcode.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3_15 {

	public static void main(String[] args) {
		int[] nums = { 7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6 };
		long startTime = System.currentTimeMillis();
		List<List<Integer>> res = threeSum(nums);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		for (List l : res) {
			System.out.println(l);
		}

	}

	// 我自己写的
	private static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		if (nums.length < 3)
			return res;
		for (int i = 0; i < nums.length - 2; i++) {
			// 定下一个数，查找后面是否有两个数相加为 -nums[i]
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int start = i + 1;
				int end = nums.length - 1;
				int sum = 0;
				while (start < end) {
					sum = nums[start] + nums[end];
					if (sum + nums[i] == 0) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[start]);
						tmp.add(nums[end]);
						res.add(tmp);
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						start++;
						end--;
					} else if (sum + nums[i] < 0) {
						start++;
					} else {
						end--;
					}
				}
			}

		}
		return res;
	}

	
	// 和下面的思想是一样的
	private static List<List<Integer>> threeSum3(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int j, k, sum;
		for (int i = 0; i < nums.length - 2; i++) {
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				// System.out.println("Checking " + nums[i] + " , " + nums[j] +
				// " , " + nums[k]);
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> ls = new ArrayList<Integer>();
					ls.add(nums[i]);
					ls.add(nums[j]);
					ls.add(nums[k]);
					res.add(ls);
					j++;
					k--;
					while (j < k && nums[k] == nums[k + 1])
						k--;// to avoid duplicates
					while (j < k && nums[j] == nums[j - 1])
						j++;// to avoid duplicates
				} else if (sum > 0) {
					k--;
					while (j < k && nums[k] == nums[k + 1])
						k--;// optional skip for non-zero triplets
				} else {
					j++;
					while (j < k && nums[j] == nums[j - 1])
						j++;// optional skip for non-zero triplets
				}
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) { // to avoid
																	// duplicates
				i++;
			}
		}
		return res;
	}

	// 这个思想是先定下一个数，然后在剩下的数组中 按照Two Sum 思想完成
	private static List<List<Integer>> threeSum2(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}

	// 43ms,这是用回溯法写的，适用范围更加广泛，比如说题目改成了4个数相加。但是效率偏低，相当于暴力枚举所有的3个数相加
	private static List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		backtracking(res, list, used, nums, 0, 0, 0);
		return res;
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, boolean[] used, int[] nums, int sum,
			int depth, int start) {
		if (depth == 3) {
			if (sum == 0) {
				List<Integer> tmp = new ArrayList<Integer>(list);
				res.add(tmp);
			}
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) // 去重
				continue;
			used[i] = true;
			list.add(nums[i]);
			sum += nums[i];
			backtracking(res, list, used, nums, sum, depth + 1, i + 1);
			sum -= nums[i];
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}

}
