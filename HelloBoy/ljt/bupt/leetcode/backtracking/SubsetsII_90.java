package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> res = subsetsWithDup(nums);
		for (List l : res)
			System.out.println(l);
	}

	
	
	
	
	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();

		boolean[] used = new boolean[nums.length];

		for (int i = 0; i <= nums.length; i++) {
			helper(res, nums, used, i, 0);
		}

		return res;
	}


	private static void helper(List<List<Integer>> res, int[] nums, boolean[] used, int depth, int start) {
		if(depth == 0){
			List<Integer> tmp = new ArrayList<>();
			for(int i = 0 ; i< nums.length ;i++){
				if(used[i]){
					tmp.add(nums[i]);
				}
			}
			res.add(tmp);
		}
		
		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
				continue;
			used[i] = true;
			helper(res, nums, used, depth, i + 1);
			used[i] = false;
		}
		
	}





	private static List<List<Integer>> subsetsWithDup1(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();

		List<Integer> list = new ArrayList<>();

		boolean[] used = new boolean[nums.length];

		for (int i = 0; i <= nums.length; i++) {
			backtracking(res, list, nums, used, i, 0);
		}

		return res;
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used, int depth,
			int start) {
		if (list.size() == depth) {
			List<Integer> tmp = new ArrayList<>(list);
			res.add(tmp);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
				continue;
			used[i] = true;
			list.add(nums[i]);
			backtracking(res, list, nums, used, depth, i + 1);
			list.remove(list.size() - 1);
			used[i] = false;
		}

	}

}
