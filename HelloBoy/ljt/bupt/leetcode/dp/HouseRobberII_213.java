package ljt.bupt.leetcode.dp;

public class HouseRobberII_213 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4} ;
		int res = rob(nums);
		System.out.println(res);
	}
	
	
	private static int rob(int[] nums) {
		// 求两种条件下更大的那个，用一个offset表示是哪种条件
        return Math.max(rob(nums, 0), rob(nums, 1));
	}
	
	private static int rob(int[] nums, int offset) {
		// 如果长度过小，则直接返回结果
        if(nums.length <= 1 + offset){
            return nums.length <= offset ? 0 : nums[0 + offset]; 
        }
        int a = nums[0 + offset];
        // 如果offset是1，则从下标为1的元素开始计算，所以要比较nums[1]和nums[2]
        int b = Math.max(nums[0 + offset], nums[1 + offset]);
        // 对于不抢劫最后一个房子的情况，i要小于nums.length - 1
        for(int i = 2 + offset; i < nums.length - 1 + offset; i++){
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
	}


	//这下面的代码太不美观了，写了两次一样的代码
//  分两种情况，抢了第一个房子，然后不抢最后一个。或没抢第一个房子，抢了最后一个
	private static int rob1(int[] nums) {
		if(nums == null||nums.length == 0 )
			return 0;
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if(nums.length ==3)
			return Math.max(Math.max(nums[0], nums[1]),nums[2]);
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2 ; i<= nums.length -2; i++){
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		int max = dp[nums.length-2];
		
		dp[1] = nums[1];
		dp[2] =Math.max(nums[1], nums[2]);
		for(int i = 3 ; i<= nums.length -1; i++){
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		max = max > dp[nums.length -1] ? max : dp[nums.length -1];
		return max;
	}

}
