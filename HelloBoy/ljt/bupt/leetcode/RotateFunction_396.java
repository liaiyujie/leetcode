package ljt.bupt.leetcode;

public class RotateFunction_396 {

	public static void main(String[] args) {
		int[] A = { 4, 3, 2, 6 };
		int res = maxRotateFunction(A);
		System.out.println(res);

	}

	// Find rules: 4ms
	// F0 = 0 + 1a1 + 2a2 + 3a3
	// F1 = F0 + a0 + a1 + a2 - 3a3 = F0 + a0 + a1 + a2 + a3 - 4a3
	// F2 = F1 + a3 + a0 + a1 - 3a2 = F1 + a0 + a1 + a2 + a3 - 4a2
	// F3 = F2 + a2 + a3 + a0 - 3a1 = F2 + a0 + a1 + a2 + a3 - 4a1

	private static int maxRotateFunction(int[] A) {
		int F = 0;
		int sum = 0;
		int res = Integer.MIN_VALUE;
		int n = A.length;
		if (n <= 1)
			return 0;
		for (int i = 0; i < n; i++) {
			F += i * A[i];
			sum += A[i];
		}
		if (F > res)
			res = F;
		for (int k = 1; k < n; k++) {
			F += sum;
			F -= n * A[n - k];
			if (F > res)
				res = F;
		}
		return res;
	}

	// 17 / 17 test cases passed.
	// Status: Accepted
	// Runtime: 541 ms 改进了一丢丢

	private static int maxRotateFunction2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int max = Integer.MIN_VALUE;
		int[] times = new int[2 * nums.length];
		for (int i = 0; i < nums.length; i++) {
			times[i] = i;
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length + i; j++) {
				sum += nums[j - i] * times[j];
			}
			ChangeTime2(times, nums.length, i);
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	private static void ChangeTime2(int[] times, int length, int i) {
		times[i + length] = times[i];
	}

	// 17 / 17 test cases passed.
	// Status: Accepted
	// Runtime: 729 ms too slow
	private static int maxRotateFunction1(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int max = Integer.MIN_VALUE;
		int[] times = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			times[i] = i;
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				sum += nums[j] * times[j];
			}
			ChangeTime(times);
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	// 耗时太长，改进一下就是不移动这个数组，每次将数组中的第一个元素放到最后面，这样每次只移动一个数
	private static void ChangeTime(int[] times) {
		int tmp = times[0];
		for (int i = 1; i < times.length; i++) {
			times[i - 1] = times[i];
		}
		times[times.length - 1] = tmp;
	}

}
