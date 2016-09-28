package ljt.bupt.leetcode.backtracking;

import java.util.Arrays;

public class NextPermutation_31 {

	public static void main(String[] args) {
		int[] nums = { 2,3,1 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	
	
	
	
	private static void nextPermutation(int[] nums) {
		
		
	}





//  解题思想就是从后往前找，按照升序排列的不用管，
//	当遇到第一个比前面的数更小的数是，将这个数与后面第一个比这个大的数交换，然后后面的数逆置排序
//	在当前序列中，从尾端往前寻找两个相邻元素，前一个记为first，后一个记为second，并且满足first 小于 second。然后再从尾端寻找另一个元素number，如果满足first 小于number，即将第first个元素与number元素对调，并将second元素之后（包括second）的所有元素颠倒排序，即求出下一个序列
//
//	example:
//	6，3，4，9，8，7，1
//	此时 first ＝ 4，second = 9
//	从尾巴到前找到第一个大于first的数字，就是7
//	交换4和7，即上面的swap函数，此时序列变成6，3，7，9，8，4，1
//	再将second＝9以及以后的序列重新排序，让其从小到大排序，使得整体最小，即reverse一下（因为此时肯定是递减序列）
//	得到最终的结果：6，3，7，1，4，8，9
	private static void nextPermutation1(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return;
		} else if (nums.length == 2) {
			swap(nums, 0, 1);
		} else {
			boolean flag = false;
			for (int i = nums.length - 1; i >= 0; i--) {
				if(i>0&&nums[i-1]<nums[i]){
					flag = true;//设为找到了
					//然后从后往前找，找到第一个比nums[i-1]大的下标，交换
					for(int j = nums.length-1;j>i-1;j--){
						if(nums[j]>nums[i-1]){
							swap(nums,i-1,j);
							break;
						}
					}
					reverse(nums,i,nums.length-1);
					break;
				}
			}
			if(!flag){
				Arrays.sort(nums);
			}
		}

	}

	private static void reverse(int[] nums, int start, int end) {//将数组nums在i 和j区间的元素反转
		while(start<end){
			swap(nums,start,end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}

}
