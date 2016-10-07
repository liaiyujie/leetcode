package ljt.bupt.leetcode.nsum;

import java.util.Arrays;
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
	
//  使用nsum的经典解法  ,不过这道题不行，因为给出的数组没有排序
	private static int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums.length<2)
			return null;
		int[] res = new int[2];
		int start = 0 ;
		int end = nums.length -1 ;
		while(start < end){
			if(nums[start] + nums[end] == target){
				res[0] = start ;
				res[1] = end ;
				break;
			}else if(nums[start] + nums[end] < target){
				start ++;
			}else{
				end--;
			}
		}
		return res;
	}

	private static int[] twoSum1(int[] nums, int target) {
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
