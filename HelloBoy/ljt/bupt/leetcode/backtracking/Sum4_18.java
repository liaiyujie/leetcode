package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_18 {

	public static void main(String[] args) {
		int[] nums = {-500,-495,-489,-472,-466,-449,-439,-435,-435,-413,-406,-381,-369,-353,-335,-311,-306,-260,-258,-231,-205,-189,-180,-165,-165,-164,-146,-141,-126,-121,-116,-100,-83,-23,-17,18,53,65,91,124,139,140,164,168,200,202,211,216,221,224,249,251,280,282,300,314,323,348,355,373,401,416,428,443,443,445,462,491,497};
		int target = -1864;
		long startTime = System.currentTimeMillis();
		List<List<Integer>> res = fourSum(nums, target);
		for (List l : res)
			System.out.println(l);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
	
	
	
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		
		return null;
	}




//  这道题  用回溯法超时o(╯□╰)o
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
