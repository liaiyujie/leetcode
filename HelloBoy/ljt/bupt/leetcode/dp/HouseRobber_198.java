package ljt.bupt.leetcode.dp;

public class HouseRobber_198 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4} ;
		int res = rob(nums);
		System.out.println(res);
	}

	//可以不用dp[]，使用只需要3个大小的滚动数组
	private static int rob(int[] nums) {
		if(nums.length<=1){
			if(nums.length==1)
				return nums[0];
			else
				return 0;
		}
		int[] dp = new int [3];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i<nums.length ;i++){
			dp[i%3] = Math.max(dp[(i-2)%3] + nums[i], dp[(i-1)%3]);
		}
		return dp[(nums.length-1)%3];
	}


	// 思路：因为不能抢劫挨着的店家， 所以这道题的本质相当于在一列数组中取出一个或多个不相邻数，
	// 使其和最大，使用dp。 举例子｛1，2，3，4}, f[i]表示到第i家能偷窃的最大钱数，
	// f[0] = nums[0], f[1] = max(nums[0], nums[1]), f[2]有两种可能，
	// 就是只取f[1]或者取f[0] + f[2]. 所以递推公式是：f[i] = Math.max(f[i - 2] + nums[i], f[i -
	// 1]);
	//
	// 时间复杂度： O(n)空间复杂度： O(n)
	private static int rob1(int[] nums) {
		if(nums.length<=1){
			if(nums.length==1)
				return nums[0];
			else
				return 0;
		}
		int[] dp = new int [nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i<nums.length ;i++){
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[nums.length-1];
	}

}
