package ljt.bupt.leetcode.binaryserch;

import java.util.Arrays;

public class SearchforaRange_34 {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 4, 5, 6 };
		int target = 4;
		int[] res = searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}

	private static int[] searchRange(int[] A, int target) {
		int start = firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, firstGreaterEqual(A, target + 1) - 1 };
	}

	// find the first number that is greater than or equal to target.
	// could return A.length if target is greater than A[A.length-1].
	// actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			// low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				// should not be mid-1 when A[mid]==target.
				// could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}

	private static int[] searchRange2(int[] nums, int target) {
		int[] res = { -1, -1 };
		int lo = 0, hi = nums.length - 1;

		// lo is the start index of target
		// hi is the end index of target
		while (nums[lo] < nums[hi]) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > target) {// target is in the left half
				hi = mid - 1;
			} else if (nums[mid] < target) {// target is in the right half
				lo = mid + 1;
			} else {// find target, then need to find the start and end point
				if (nums[lo] == nums[mid]) {
					hi--;
				} else {
					lo++;
				}
			}
		}
		// check whether find the target number
		if (nums[lo] == nums[hi] && nums[lo] == target) {
			res[0] = lo;
			res[1] = hi;
		}

		return res;
	}

	// 二分查找，先用api试试
	private static int[] searchRange1(int[] nums, int target) {
		int[] res = new int[2];
		// int index = Arrays.binarySearch(nums, target);
		int index = BinarySerch(nums, target);
		if (index < 0) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		// 在index的基础上往前找
		int i = index;
		while (--i >= 0) {
			if (nums[i] != target) {
				res[0] = i + 1;
				break;
			}
		}
		// 在index的基础上往后找
		while (++index < nums.length) {
			if (nums[index] != target) {
				res[1] = index - 1;
				break;
			} else {
				res[1] = nums.length - 1;
			}
		}
		if (nums[nums.length - 1] == target)
			res[1] = nums.length - 1;
		return res;
	}

	private static int BinarySerch(int[] nums, int target) {
		if (nums.length == 0 || nums == null)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
