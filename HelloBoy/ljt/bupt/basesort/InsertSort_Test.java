package ljt.bupt.basesort;

import java.util.Arrays;

public class InsertSort_Test {

	public static void main(String[] args) {
		// int[] nums = { 4, 3, 2, 1, 6, 3, 7, 3, 8, 23, 9, 234, 78, 23, 34, 21,
		// 4, 4234, 12, 321, 1, 2, 32, 3, 45 };
		// int[] nums = {5,6,4,3,7,2,8,9,1,10};
		int[] nums = { 4, 2 };
		InsertSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	private static void InsertSort(int[] nums) {
		if (nums.length < 2) {
			return;
		}

//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i - 1] > nums[i]) {// 乱序的，调整
//				int temp = nums[i];
//				int j = i;
//				while (j > 0 && nums[j - 1] > temp) {
//					nums[j] = nums[j - 1];
//					j--;
//				}
//				nums[j] = temp;
//			}
//		}

		// 下面是自己写的代码，很烂，还写不出来,确实两层循环很难写
		for (int i = 1; i < nums.length; i++) {// 默认第一个数为有序，从第二个数开始找他应该在的位置
			for (int j = i; j > 0; j--) {// 从后往前找，找到第一个小于或者等于它的数的下标，然后插在她后面
				if (nums[i] > nums[j-1]) {// 找到了这个j，现在的目标就是将i插入到j的位置，将原来j到i-1的位置的元素全部后移
					int tmp = nums[i];
					removetoBack(nums,j,i);
					nums[j] = tmp;
					break;
				} else {
					continue;
				}
			}
		}

	}
//  将start到end-1的位置向后移
	private static void removetoBack(int[] nums, int start, int end) {
		while(end>start){
			nums[end] = nums[end-1];
			end--;
		}
	}

}
