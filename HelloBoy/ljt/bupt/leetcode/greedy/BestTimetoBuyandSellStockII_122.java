package ljt.bupt.leetcode.greedy;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII_122 {

	public static void main(String[] args) {
		int[] prices = { 1,2,3,4,1,5,1,2,3,4,5 };
		int re = maxProfit(prices);
		System.out.println(re);

	}
//  贪心思想，只要股票在上升，不管，股票一下降，在下降之前将它卖出
	private static int maxProfit(int[] prices) {
		if(prices.length <2)
			return 0;
		int maxPro = 0;
		int before = prices[0];
		int after = 0;
		for(int i = 1 ; i< prices.length ;i++){
			after = prices[i];
			if(after >= prices[i-1]){
				if(i==prices.length-1){
					maxPro += prices[i] - before;
				}
				continue;
			}else{
				maxPro += prices[i-1] - before;
				before = prices[i];
			}
		}
		return maxPro;
	}

}
