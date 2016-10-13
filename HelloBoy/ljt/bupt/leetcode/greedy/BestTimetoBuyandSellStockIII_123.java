package ljt.bupt.leetcode.greedy;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIII_123 {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
		int re = maxProfit(prices);
		System.out.println(re);
	}

	// 高级版的难度一下子就提升了，开始错误想法：将两个获益最大区间的获益相加，也就是我下面写的代码，很快就证明是错误的。
	// 正确解法：构造两个数组，left和right，left[i]表示从0到i天的最大获益，
	// right[i]表示从i到最后一天的最大获益。求left的方法其实就解题I的方法，不再赘述。
	// 求right的方法其实是求left的对称解法：
	// 求left时，记录前i天的最低价minPrice与最大获益max，求left[i]：考虑要在第i天卖出，
	// 那么买进的时间必然是在0到i之间（闭区间），这个时候只需要比较prices[i]-minPrice和max就可以求出
	// 截止到第i天的最大获益，然后根据需要更新minPrice

	// 求right时，记录从第i天往后的最高价maxPrice与最大获益max，求right[i]：考虑要再第i天买进，
	// 那么卖出时间必然是在i到最后一天之间（闭区间），这个时候只需要比较maxPrice-prices[i]和max就可以求出
	// 从第i天开始的最大获益，然后根据需要更新maxPrice。
	// 对于left和right的构造算法复杂度都是O(n)。
	// 构造完left和right之后，只要求left[i]+right[i]的最大值就行了。
	private static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int max = 0;
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (minPrice < prices[i]) {
				left[i] = Math.max(left[i - 1], prices[i] - minPrice);
			} else {
				left[i] = left[i - 1];
				minPrice = prices[i];
			}
		}
		int maxPrice = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] < maxPrice) {
				right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
			} else {
				right[i] = right[i + 1];
				maxPrice = prices[i];
			}
		}
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, left[i] + right[i]);
		}
		return max;
	}

	// 最多进行两次交易，那么将每次可以获利的交易记录下来，选择两次最大的获利交易，相加
	// 这个思想有bug ，[1,2,4,2,5,7,2,4,9,0]样例过不去，按照这个思想，有三次上升分别上升3 5 7 ，得到结果为12
	// 但是这个样例可以看成两次上升1~7 2~9 结果为13 过了188/198个样例 o(╯□╰)o
	private static int maxProfit1(int[] prices) {
		if (prices.length < 2)
			return 0;
		int[] maxPro = new int[prices.length];
		int before = prices[0];
		int after = 0;
		for (int i = 1; i < prices.length; i++) {
			after = prices[i];
			if (after >= prices[i - 1]) {
				if (i == prices.length - 1) {
					maxPro[i] = prices[i] - before;
				}
				continue;
			} else {
				maxPro[i] = prices[i - 1] - before;
				before = prices[i];
			}
		}
		Arrays.sort(maxPro);
		System.out.println(Arrays.toString(maxPro));
		return maxPro[prices.length - 1] + maxPro[prices.length - 2];
	}

}
