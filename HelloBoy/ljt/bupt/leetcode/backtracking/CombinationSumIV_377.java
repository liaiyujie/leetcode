package ljt.bupt.leetcode.backtracking;

public class CombinationSumIV_377 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int target = 4;
		int res = combinationSum4(nums, target);
		System.out.println(res);
	}

	// 先使用回溯法试试，不过预计会超时
	private static int combinationSum4(int[] nums, int target) {
		int count = 0;
		backtracking(nums, target, count, 0);
		return count;
	}

	private static void backtracking(int[] nums, int target, int count, int start) {
		if (target <= 0) {
			if (target == 0) {
				count++;
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {

		}

	}

}
