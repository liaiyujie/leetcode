package ljt.bupt.leetcode.dp;

public class CoinChange_322 {

	public static void main(String[] args) {
		int[] coins = { 2 };
		int amount = 3;
		int res = coinChange(coins, amount);
		System.out.println(res);
	}

	// dp[m] = min{dp[m-i] i~[1,2,5]}+1
	private static int coinChange(int[] coins, int amount) {
		if(amount==0)
			return 0;
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			boolean flag = false;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					if(dp[i-coins[j]]!=-1){//这句话很重要，就是前面的一个面值可以达到，才执行下面的操作
						flag = true;
						min = min>dp[i-coins[j]]+1?dp[i-coins[j]]+1:min;
					}
				}
			}
			if(!flag){
				dp[i] = -1;
			}else{
				dp[i] = min;
			}
		}
		return dp[amount]==0?-1:dp[amount];
	}

}
