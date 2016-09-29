package ljt.bupt.leetcode;

import java.util.Arrays;

public class RotateArray_189 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 0;
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));

	}

	// 可以先将整个数字逆置，再前k个逆置，再后面的逆置
	private static void rotate(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k-1);
		reverse(nums, k , nums.length - 1);

	}

	private static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = 0;
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}

	}

	// 这个是将后面的数字放到一个缓存数组中，较笨
	private static void rotate1(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		int[] tmp = new int[k];
		for (int i = nums.length - k; i < nums.length; i++) {
			tmp[i - nums.length + k] = nums[i];
		}
		for (int i = nums.length - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = tmp[i];
		}

	}

}
