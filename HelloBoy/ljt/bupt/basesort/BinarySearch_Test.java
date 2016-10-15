package ljt.bupt.basesort;

public class BinarySearch_Test {
	// http://www.cnblogs.com/wuyuegb2312/archive/2013/05/26/3090369.html
	public static void main(String[] args) {
		// 二分问题请记住standardBinarySearch，和BinarySearch_firstIndexofKey的写法
		int[] nums = { 1, 2, 3, 3, 3, 3, 5, 5, 5, 5, 5, 6, 7, 8, 9 };
		// int res = standardBinarySearch(nums, 5);
		// int res = BinarySearch_firstIndexofKey(nums, 3);
		int res = BinarySearch_lastIndexofKey(nums, 5);
		System.out.println(res);

	}

	// 使用while(left<right-1)可以保证每次循环时数组长度都会至少减一，
	// 终止时数组长度可能为2(left+1==right)、1(left==mid，上一次循环时right取mid==left)，
	// 但是不可能为0。(每一次循环前总有left<=mid<=right，无论令left=mid还是令right=mid，
	// 都不会发生left>right)。同BinarySearch_firstIndexofKey一样，right总是指向数组中候选的最后一个可能为key的下标，
	// 此时只需先检查right后检查left是否为key就能确定x的位置。

	// 如果想最大限度地利用已有的函数，那么把需要处理的数组倒序，
	// 然后直接使用方法BinarySearch_firstIndexofKey，再把得到的第一次出现的下标做一次减法就可以得到最后一次出现的下标
	// 3.二分查找返回key(可能有重复)最后一次出现的下标x，如果不存在返回-1（模仿2的第一版）
	private static int BinarySearch_lastIndexofKey(int[] nums, int key) {
		if (nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start < end - 1) {
			int mid = start + ((end - start) >> 1);
			if (nums[mid] <= key)
				start = mid;
			else
				end = mid;
		}
		if (nums[end] == key)
			return end;
		else if (nums[start] == key)
			return start;
		else
			return -1;
	}

	// 二分查找返回key(可能有重复)第一次出现的下标x，如果不存在返回-1
	private static int BinarySearch_firstIndexofKey(int[] nums, int key) {
		if (nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (nums[mid] < key) {
				start = mid + 1;// start 位数组中第一个可能出现的key的Index
			} else {
				end = mid;// end 位数组中第一个大于等于key的Index
			}
		}
		if (nums[start] == key)
			return start;
		return -1;
	}

	// 在一个升序数组中找到key的下标,可能会有很多重复的key，只能保证找到一个
	private static int standardBinarySearch(int[] nums, int key) {
		if (nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (nums[mid] == key) {
				return mid;
			} else if (nums[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
