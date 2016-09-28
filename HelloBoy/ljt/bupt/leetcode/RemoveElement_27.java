package ljt.bupt.leetcode;

import java.util.Arrays;

public class RemoveElement_27 {

	public static void main(String[] args) {
		int[] nums = {3,3,3,3,3,3}; 
		int val = 3;
		int res = removeElement(nums, val);
		System.out.println(res);
		System.out.println(Arrays.toString(nums));
	}

	private static int removeElement(int[] nums, int val) {
		int count = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i]!= val){
				nums[count++] = nums[i];
			}
		}
		return count;
	}

	private static int removeElement2(int[] nums, int val) {
		int count = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i]== val){
				count ++;
			}
		}
		for(int i = 0 ; i < nums.length-count ; i++){
			if(nums[i]== val){
				for(int j = nums.length -1 ; j>i ; j--){
					if(nums[j]!=val){
						nums[i] = nums[j];
						nums[j] = val;
						break;
					}
				}
			}
		}
		return nums.length - count;
	}

	private static int removeElement1(int[] nums, int val) {
		int count = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i]== val){
				count ++;
			}
		}
		return nums.length - count;
	}

}
