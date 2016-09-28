package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://algorithm.yuanbin.me/zh-hans/exhaustive_search/permutations.html
public class Permutations_46 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permute1(nums);
		for (List l : res) {
			System.out.println(l);
		}
	}

	
	//使用了交换的思想
	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
        dfs(res, nums, 0);  
        return res;  
	}

	private static void dfs(List<List<Integer>> res, int[] nums, int j) {  
        if (j == nums.length) {  
            List<Integer> temp = new ArrayList<Integer>();  
            for (int num : nums) temp.add(num);  
            res.add(temp);  
        }  
        for (int i = j; i < nums.length; i++) {  
            swap(nums, i, j);  
            dfs(res, nums, j+1);  
            swap(nums, i, j);  
        }  
    }  
    private static void swap(int[] nums, int m, int n) {  
        int temp = nums[m];  
        nums[m] = nums[n];  
        nums[n] = temp;  
    }  
    

	private static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> numsList = new ArrayList<Integer>();

		if (nums == null) {
			return result;
		} else {
			// convert int[] to List<Integer>
			for (int item : nums)
				numsList.add(item);
		}

		if (nums.length <= 1) {
			result.add(numsList);
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			int[] numsNew = new int[nums.length - 1];
			System.arraycopy(nums, 0, numsNew, 0, i);
			System.arraycopy(nums, i + 1, numsNew, i, nums.length - i - 1);

			List<List<Integer>> resTemp = permute(numsNew);
			for (List<Integer> temp : resTemp) {
				temp.add(nums[i]);
				result.add(temp);
			}
		}

		return result;
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
