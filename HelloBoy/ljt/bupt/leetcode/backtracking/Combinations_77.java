package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> res = combine(n, k);
		for (List l : res) {
			System.out.println(l);
		}
	}

	private static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		boolean[] used = new boolean[n];
		helper(res, nums, used, k, 0);
		return res;
	}

	private static void helper(List<List<Integer>> res, int[] nums, boolean[] used, int k, int start) {

		if (k == 0) {// 这个时候检索到了k个数字能够成为一个组合，将这个组合保存在res中
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < used.length; i++) {
				if (used[i] == true) {
					tmp.add(i+1);
				}
			}
			res.add(tmp);
		}
		for (int i = start; i < nums.length; i++) {
			used[i] = true;
			helper(res, nums, used, k - 1, i + 1);
			used[i] = false;
		}

	}

}
