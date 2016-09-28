package ljt.bupt.leetcode;

public class FindMinimuminRotatedSortedArray153 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int re = findMin(nums);
		System.out.println(re);
	}

	private static int findMin(int[] num) {// 数字可能重复
		int lo = 0;
		int hi = num.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;

			if (num[mid] > num[hi]) {
				lo = mid + 1;
			} else if (num[mid] < num[hi]) {
				hi = mid;
			} else { // when num[mid] and num[hi] are same
				hi--;
			}
		}
		return num[lo];
	}

	private static int findMin3(int[] nums) {// 数字可能重复
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				return nums[i + 1];
			}
		}
		return nums[0];
	}

	private static int findMin2(int[] num) {// 数字不带重复的
		int lo = 0, hi = num.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (num[mid] > num[hi])
				lo = mid + 1;
			else
				hi = mid;
		}
		return num[lo];
	}

	private static int findMin1(int[] nums) {
		// TODO Auto-generated method stub
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				return nums[i + 1];
			}
		}
		return nums[0];
	}

}
