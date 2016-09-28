package ljt.bupt.leetcode;

public class IncreasingTripletSubsequence_334 {

	public static void main(String[] args) {
		int[] nums = { 0,4,2,1,0,-1,-3 };
		boolean bool = increasingTriplet(nums);
		System.out.println(bool);
	}
	
	
	/*The main idea is keep two values when check all elements in the array:
	the minimum value min until now and the second minimum value secondMin 
	from the minimum value's position until now. Then if we can find the 
	third one that larger than those two values at the same time, 
	it must exists the triplet subsequence and return true.

	What need to be careful is: we need to include the condition 
	that some value has the same value with minimum number, 
	otherwise this condition will cause the secondMin change its value.*/
	private static boolean increasingTriplet(int[] nums) {
		 int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
	        for(int num : nums){
	            if(num <= min) min = num;
	            else if(num < secondMin) secondMin = num;
	            else if(num > secondMin) return true;
	        }
	        return false;
	}

	private static boolean increasingTriplet2(int[] nums) {
		if (nums.length <= 2)
			return false;
		int len = nums.length;
		for (int i = 0; i < len-2; i++) {
			for (int j = i+1; j < len-1; j++) {
				if (nums[i] < nums[j]) {
					for (int k = j+1; k < len; k++) {
						if(nums[j]<nums[k])
							return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean increasingTriplet1(int[] nums) {// 错误，不是连续的3个数
		if (nums.length <= 2)
			return false;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

}
