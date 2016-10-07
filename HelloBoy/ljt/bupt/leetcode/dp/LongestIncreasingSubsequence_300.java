package ljt.bupt.leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		int[] nums = { 2, 2 };
		int re = lengthOfLIS(nums);
		System.out.println(re);
	}

	private static int lengthOfLIS(int[] A) {
		if (A.length == 0 || A == null)
			return 0;
		int length = A.length;
		int[] B = new int[length];
		B[0] = A[0];
		int end = 0;
		for (int i = 1; i < length; ++i) {
			// 如果当前数比B中最后一个数还大，直接添加
			if (A[i] > B[end]) {
				B[++end] = A[i];
				continue;
			}
			// 否则，需要先找到替换位置
			int pos = findInsertPos(B, A[i], 0, end);
			B[pos] = A[i];
		}
		// for (int i = 0; i < B.length; ++i) {
		// System.out.println(B[i]);
		// }
		return end + 1;
	}

	/**
	 * 二分查找第一个大于等于n的位置
	 */
	private static int findInsertPos(int[] B, int n, int start, int end) {
		while (start < end) {
			int mid = start + (end - start) / 2;// 直接使用(high + low) / 2 可能导致溢出
			if (B[mid] < n) {
				start = mid + 1;
			} else if (B[mid] > n) {
				end = mid;
			} else {
				return mid;
			}
		}
		return start;
	}

	// 自己没写出来，下面是有bug版本
	// Follow up: Could you improve it to O(n log n) time complexity?
	// 邹博给出了一个贪心策略的算法O(n log n)，维护一个缓冲，然后数组的数依次进去，
	// 遇到一个数前面比他小，那么把这个数替换掉后面一个比他大的数,可以用二分，所以一个数查找时间复杂度为log n

	private static int lengthOfLIS3(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		LinkedList<Integer> buf = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			insert(buf, nums[i]);
		}
		return buf.size();
	}

	private static void insert(LinkedList<Integer> buf, int n) {
		if (buf.size() == 0) {// 将n插入最前面
			buf.addFirst(n);
		} else if (n < buf.get(0)) {
			buf.set(0, n);
		} else if (buf.size() != 0 && n > buf.get(buf.size() - 1)) {// 将n插入最后面
			buf.addLast(n);
		} else {// 将n插入中间某位置
			int index = searchIndex(buf, n);
			buf.set(index, n);
		}
	}

	private static int searchIndex(LinkedList<Integer> buf, int n) {
		int start = 0;
		int end = buf.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (buf.get(mid) < n && mid + 1 < buf.size() && buf.get(mid + 1) > n) {
				return mid + 1;
			} else if (buf.get(mid) < n && mid + 1 < buf.size() && buf.get(mid + 1) < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	// 和下面的一样 动态规划解法 O（n2） ，自己写的
	private static int lengthOfLIS2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max = max < dp[j] ? dp[j] : max;
				}
			}
			dp[i] = max + 1;
		}
		Arrays.sort(dp);
		return dp[nums.length - 1];
	}

	private static int lengthOfLIS1(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		return dp[nums.length - 1];
	}

}
