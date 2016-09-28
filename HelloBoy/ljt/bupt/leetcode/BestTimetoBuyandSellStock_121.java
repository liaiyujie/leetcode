package ljt.bupt.leetcode;

import java.util.Arrays;

public class BestTimetoBuyandSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int re = maxProfit(prices);
		System.out.println(re);

	}

	private static int maxProfit(int[] prices) {
		if(prices.length==0||prices==null)
			return 0;
		int minNum = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i]<minNum)
				minNum = prices[i];
			max = Math.max(max, prices[i]- minNum);
		}
		return max;
	}

	private static int maxProfit2(int[] prices) {
		if(prices.length==0||prices==null)
			return 0;
		int[] dp = new int[prices.length];
		int minNum = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			int max = 0;
			if(prices[i]<minNum)
				minNum = prices[i];
			max = prices[i]- minNum;
			if(max>0){
				dp[i] = max;
			}else{
				dp[i] = 0;
			}
		}
		Arrays.sort(dp);
		return dp[prices.length-1];
	}

	private static int maxProfit1(int[] prices) {
		if (prices.length == 0 || prices == null)
			return 0;
		int[] dp = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (prices[j] < prices[i]) {
					max = Math.max(max, prices[i] - prices[j]);
				}
			}
			dp[i] = max;
		}
		Arrays.sort(dp);
		return dp[prices.length - 1];
	}

}
