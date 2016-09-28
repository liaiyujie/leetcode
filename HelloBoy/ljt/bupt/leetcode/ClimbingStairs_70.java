package ljt.bupt.leetcode;

public class ClimbingStairs_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		int re = climbStairs(44);
		long endTime = System.currentTimeMillis();
		System.out.println(re);
		System.out.println(endTime - startTime);
	}

	public static int climbStairs(int n) {
		// base cases
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;

		for (int i = 2; i < n; i++) {
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}

	private static int climbStairs1(int n) {
		int[] nums = new int[91];
		nums[1] = 1;
		nums[2] = 2;
		for (int i = 3; i <= 90; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n];
	}

}
