package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] re = twoSum(nums, target);
		for(int i = 0; i< re.length ; i++){
			System.out.println(re[i]);
		}
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] re = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(target-nums[i], i);
			} else {
				re[0] = map.get(nums[i]);
				re[1] = i;
				return re;
			}
		}
		return null;
	}

}
