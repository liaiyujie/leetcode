package ljt.bupt.leetcode;

import java.util.Arrays;

public class SearchInsertPosition35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		int target = 4;
		int re = searchInsert(nums, target);
		System.out.println(re);
	}

	private static int searchInsert(int[] nums, int target) {
		// TODO Auto-generated method stub
		if(target <= nums[0])
			return 0;
		if(target == nums[nums.length-1])
			return nums.length-1;
		if(target > nums[nums.length-1])
			return nums.length;
		int index = Arrays.binarySearch(nums, target);
		if(index > 0)
			return index;
		else{
			//在数组中找到第一个大于target的数字
			int low = 0;
			int high = nums.length-1;
			while(low <= high){
				int mid = low + (high - low)/2;
				if(nums[mid]>target){
					if(nums[mid-1]<target){
						return mid;
					}else{
						high = mid -1;
					}
				}else{
					if(nums[mid+1]>target){
						return mid +1;
					}else{
						low = mid +1;
					}
				}
			}
		}
		return 0;
	}

}
