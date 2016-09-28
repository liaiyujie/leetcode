package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets_78 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = subsets(nums);
		for (List l : res) {
			System.out.println(l);
		}
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		boolean[] used = new boolean[nums.length];
		//i代表深度。即深度为0 1 2 3 的都弄出来  相当于组合的那道题，组合题（Combinations_77）的i是定下来的
		for(int i = 0 ; i<= nums.length; i++)
			backtracking(res,nums,used,i,0);
		
		return res;
	}

	private static void backtracking(List<List<Integer>> res, int[] nums, boolean[] used, int depth, int start) {
		if (depth == 0) {// 该将结果加入res中
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (used[i] == true) {
					tmp.add(nums[i]);
				}
			}
			res.add(tmp);
		}

		for (int i = start; i < nums.length; i++) {
			used[i] = true;
			backtracking(res,nums,used,depth-1,i+1);
			used[i] = false;
		}

	}

}
