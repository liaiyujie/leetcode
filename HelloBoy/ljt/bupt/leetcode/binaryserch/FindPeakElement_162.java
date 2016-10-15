package ljt.bupt.leetcode.binaryserch;

public class FindPeakElement_162 {
//  找一个数组的局部最大值，用到高原数组的概念
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int res = findPeakElement(nums);
		System.out.println(res);
	}
//  二分搜索，使用高原数组的概念。刚开始数组为一个高原数组。不断缩短数组的范围
	private static int findPeakElement(int[] nums) {
		if(nums.length==1)
			return 0;
		int start = 0 ;
		int end = nums.length -1;
		while(start<end){
			int mid = start + (end - start)/2;
//			int mid = (start + end)/2;
			if(nums[mid] > nums[mid+1]){//高原数组现在在start~mid之间
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}

	//暴力搜索，找到数组最大值
	private static int findPeakElement1(int[] nums) {
		if(nums.length==1)
			return 0;
		int maxIndex = Integer.MIN_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for(int i = 0 ; i < nums.length ;i++){
			if(nums[i] > maxVal){
				maxVal = nums[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}
