package ljt.bupt.leetcode.greedy;

public class JumpGame_55 {

	// his problem have two method which is Greedy and Dynamic Programming.
	// The time complexity of Greedy method is O(n).
	// The time complexity of Dynamic Programming method is O(n^2).
	public static void main(String[] args) {
//		int[] nums = { 2, 3, 1, 1, 4 };
		 int[] nums = {3,2,1,0,4};
		boolean res = canJump(nums);
		System.out.println(res);
	}

	// 贪心思想就是维护一个当前位置所能到达的最远距离和目前为止能到达的最远距离， O(N)
	// 比较两者的大小，更新目前为止能到达的最远距离
	private static boolean canJump(int[] nums) {
		if (nums.length == 0 || nums == null)
			return false;
		int max = 0;
		for (int i = 0;i <= max && i < nums.length; i++) {
			max = Math.max(max, i + nums[i]);
		}
		return max >= nums.length-1;
	}

	// dp 的解法在leetcode 中会超时，更换贪心 O(N2)
	// dp
	// 建立动规boolean数组dp，表示从起点A[0]处到达该点的可能性。所以，起点的可能性dp[0] = true。
	// 然后进行两次循环，令j < i，当dp[j]为true且j点可以到达i点时，dp[i]也为true。
	// 循环结束后，dp数组对所有点作为终点的可能性都进行了赋值。返回数组A的终点dp[A.length-1]即可。
	private static boolean canJump2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return false;
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for (int i = 0; i < nums.length; i++) {// 以每个点为终点，看是否能到达我这个点
			for (int j = 0; j < i; j++) {// 看i前面的点是否有一个点能到达i点
				if (dp[j] && j + nums[j] >= i) {
					dp[i] = true;
					break;// 找到一个点能到达该点即可，不需要再往下重复找
				}

			}
		}
		return dp[nums.length - 1];
	}

	// 自己没写出代码
	// 贪心思想，对每一个点，先跳他能跳过去的最远的点，跳不过去的话就少跳一些，如果遇到某个点根本跳不过去，直接返回false
	private static boolean canJump1(int[] nums) {
		if (nums.length < 2)
			return true;
		int len = nums.length;

		return false;
	}

}
