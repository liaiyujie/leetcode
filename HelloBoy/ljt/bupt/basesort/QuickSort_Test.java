package ljt.bupt.basesort;

import java.util.Arrays;

public class QuickSort_Test {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 66, 6, 3, 7, 3, 8, 23, 9, 234, 78, 23, 34, 21, 4, 423, 12, 321, 1, 2, 32, 3, 45 };
		// int[] nums = {5,6,4,3,3,4,5,6,7,19,7,2,2,2,8,9,1,10};
		QuickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void QuickSort(int[] nums, int left, int right) {
		int dp;// 记录每个key最终的位置
		if (left < right) {
			dp = Partition(nums, left, right);
			QuickSort(nums, left, dp - 1);
			QuickSort(nums, dp + 1, right);
		}
	}

	private static int Partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			if (left < right) {
				nums[left++] = nums[right];
			}
			while (left < right && nums[left] <= pivot) {
				left++;
			}
			if (left < right) {
				nums[right--] = nums[left];
			}
		}
		nums[left] = pivot;
		return left;
	}

}
