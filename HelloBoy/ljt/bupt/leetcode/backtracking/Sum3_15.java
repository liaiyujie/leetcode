package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3_15 {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(nums);
		for (List l : res) {
			System.out.println(l);
		}

	}
	
	//和下面的思想是一样的
	private static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    int j, k, sum;
	    for(int i=0;i<nums.length-2;i++){
	        j = i+1;
	        k = nums.length - 1;
	        while(j<k){
	            //System.out.println("Checking " + nums[i] + " , " + nums[j] + " , " + nums[k]);
	            sum = nums[i] + nums[j] + nums[k];
	            if (sum == 0){
	              List<Integer> ls = new ArrayList<Integer>();
	              ls.add(nums[i]);
	              ls.add(nums[j]);
	              ls.add(nums[k]);
	              res.add(ls);
	              j++;k--;
	              while(j<k && nums[k]==nums[k+1]) k--;//to avoid duplicates
	              while(j<k && nums[j]==nums[j-1]) j++;//to avoid duplicates
	            } else if (sum > 0){
	                k--;
	                while(j<k && nums[k]==nums[k+1]) k--;//optional skip for non-zero triplets
	            } else {
	                j++;
	                while(j<k && nums[j]==nums[j-1]) j++;//optional skip for non-zero triplets
	            }
	        }
	        while(i<nums.length-2 && nums[i]==nums[i+1]){ //to avoid duplicates
	            i++;
	        }
	    }
	    return res;
	}
	
	
//  这个思想是先定下一个数，然后在剩下的数组中 按照Two Sum 思想完成
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

	// 43ms,这是用回溯法写的，适用范围更加广泛，比如说题目改成了4个数相加。但是效率偏低
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
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
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
