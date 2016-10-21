package ljt.bupt.basesort;

import java.util.Arrays;

public class BubbleSort_Test {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 66, 6, 3, 7, 3, 8, 23, 9, 234, 78, 23, 34, 21, 4, 423, 12, 321, 1, 2, 32, 3, 45 };
		// int[] nums = {5,6,4,3,3,4,5,6,7,19,7,2,2,2,8,9,1,10};
		BubbleSortPlus2(nums);
		System.out.println(Arrays.toString(nums));

	}

	// 冒泡排序算法的改进
	//
	// 对冒泡排序常见的改进方法是加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，
	// 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，
	// 避免不必要的比较过程。本文再提供以下两种改进算法：

	// 1．设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
	// 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
	private static void BubbleSortPlus1(int[] nums) {
		if (nums.length < 2)
			return;
		int len = nums.length;
		int i = len - 1; // 初始时,最后位置保持不变
		while (i > 0) {
			int pos = 0; // 每趟开始时,无记录交换
			for (int j = 0; j < i; j++)
				if (nums[j] > nums[j + 1]) {
					pos = j; // 记录交换的位置
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			i = pos; // 为下一趟排序作准备
		}

	}

	// 2．传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,我们考虑利用在每趟排序中
	// 进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 从而使排序趟数几乎减少了一半。
	private static void BubbleSortPlus2(int[] nums) {
		int n = nums.length;
		int low = 0;
		int high = n - 1; // 设置变量的初始值
		int tmp, j;
		while (low < high) {
			for (j = low; j < high; ++j) // 正向冒泡,找到最大者
				if (nums[j] > nums[j + 1]) {
					tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			--high; // 修改high值, 前移一位
			for (j = high; j > low; --j) // 反向冒泡,找到最小者
				if (nums[j] < nums[j - 1]) {
					tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			++low; // 修改low值,后移一位
		}
	}

	private static void BubbleSort(int[] nums) {
		if (nums.length < 2)
			return;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {// 共需要进行len-1次排序。
			for (int j = 0; j < len - i - 1; j++) {// 每次从前往后遍历将一个最大的数往后排
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
				}
			}
		}

	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}

}
