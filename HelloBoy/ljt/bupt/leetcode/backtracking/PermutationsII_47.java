package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://algorithm.yuanbin.me/zh-hans/exhaustive_search/permutations.html
public class PermutationsII_47 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> res = permuteUnique(nums);
		for (List l : res) {
			System.out.println(l);
		}
	}

	private static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		ArrayList<Integer> list = new ArrayList<Integer>();
		helperUnique(result, used, list, nums);
		return result;
	}

	private static void helperUnique(List<List<Integer>> result, boolean[] used, ArrayList<Integer> list, int[] nums) {

		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		/*
		 * 上面这一连串判断条件，重点在于要能理解!used(i-1) 要理解这个，首先要明白i作为数组内序号，i是唯一的
		 * 给出一个排好序的数组，[1,2,2] 第一层递归 第二层递归 第三层递归 [1] [1,2] [1,2,2] 序号:[0] [0,1]
		 * [0,1,2] 这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了 [1] [1,2] [1,2,2] 序号:[0]
		 * [0,2] [0,2,1] 所以这边判断的时候!used(0)就变成了true，不会再继续递归下去，跳出循环
		 * 步主要就是为了去除连续重复存在的，很神奇反正 = =||
		 */
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]))
				continue;
			used[i] = true;
			list.add(nums[i]);
			helperUnique(result,used, list, nums );
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}

	private static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(result, list, nums);
		return result;
	}

	private static void helper(List<List<Integer>> result, ArrayList<Integer> list, int[] nums) {
		// in this problem we assume no duplicate exists in input array
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			helper(result, list, nums);
			list.remove(list.size() - 1);
		}
	}

}
