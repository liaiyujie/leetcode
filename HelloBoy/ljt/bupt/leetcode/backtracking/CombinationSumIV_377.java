package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV_377 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int target = 30;
		int res = combinationSum4(nums, target);
		System.out.println(res);
//		long s = System.currentTimeMillis();
//		List<List<Integer>> res = combinationSum41(nums, target);
//		Integer c = combinationSum4p(nums, target);
//		long e = System.currentTimeMillis();
//		for(List l:res){
//			System.out.println(l);
//		}
//		System.out.println(c);
//		System.out.println(s-e);
	}

	
	//动态规划思想
	//dp[n] = dp[n-nums[i]] + dp[nums[i]]  i~[0,nums.length-1]
	private static int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target+1];
		dp[nums[0]] = 1;
		for(int i = nums[0]+1; i <=target;i++){
			
			for (int num: nums) {
                if (num == i) dp[i]++;
                else if (num < i) dp[i] += dp[i-num];
                else break;
            }
			
//			for(int j = 0 ; j <nums.length;j++){
//				if(i-nums[j]>=nums[0]){
//					dp[i] = dp[i-nums[j]] + dp[nums[j]];
//				}
//			}
		}
		return dp[target];
	}
//	public class Solution {
//	    public int backPackVI(int[] nums, int target) {
//	        int[] dp = new int[target+1];
//	        Arrays.sort(nums);
//	        dp[0] = 1;
//	        for (int i = 1; i <= target; i++) {
//	            for (int num: nums) {
//	                if (num <= i) dp[i] += dp[i-num];
//	            }
//	        }
//	        return dp[target];
//	    }
//	}
	// 先使用回溯法试试，不过预计会超时
	private static int combinationSum4p(int[] nums, int target) {
		int count = 0;
		count = dfs(nums, target,count);
		return count;
	}

	private static int dfs(int[] nums, int target, Integer count) {
		if (target <= 0) {
			if (target == 0) {
				count = count +1;
			}
			return count;
		}

		for (int i = 0; i < nums.length; i++) {
			target = target - nums[i];
			count = dfs(nums, target,count);
			target = target + nums[i];
		}
		return count;
	}

	// 先使用回溯法试试，不过预计会超时
	private static List<List<Integer>> combinationSum41(int[] nums, int target) {
		Integer count = 0;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtracking(res,list,nums, target);
		return res;
	}

	private static void backtracking(List<List<Integer>> res,List<Integer> list,int[] nums, int target) {
		if (target <= 0) {
			if (target == 0) {
				res.add(new ArrayList(list));
			}
			return ;
		}

		for (int i = 0; i < nums.length; i++) {
			target = target - nums[i];
			list.add(nums[i]);
			backtracking(res,list,nums, target);
			target = target + nums[i];
			list.remove(list.size()-1);
		}
		
	}

}
