package ljt.bupt.leetcode.dp;

import java.util.Arrays;

public class PerfectSquares_279 {

	public static void main(String[] args) {
		int n = 13;
		long s = System.currentTimeMillis();
		int res = numSquares2(n);
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		System.out.println(res);
	}
	
//	dp[0] = 0 
//	dp[1] = dp[0]+1 = 1
//	dp[2] = dp[1]+1 = 2
//	dp[3] = dp[2]+1 = 3
//	dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
//	      = Min{ dp[3]+1, dp[0]+1 } 
//	      = 1                
//	dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
//	      = Min{ dp[4]+1, dp[1]+1 } 
//	      = 2
//	dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
//	       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
//	       = 2
//	dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

//	还是下面的状态转移方程，dp写法
//	这个代码写得真漂亮
	private static int numSquares(int n) {
		int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
	}

	// 动态规划和递归代码的关系，从前往后得到答案就为动态规划写法，从后往前推出答案为递归写法，这方法是递归
	// dp[n] = min{1+dp[n-s*s] s~[1,floor(sqrt(n))]}
	private static int numSquares2(int n) {
		int maxOne = (int) Math.sqrt(n);
		if (maxOne * maxOne == n) {
			return 1;
		}
		int res = Integer.MAX_VALUE;
		while (maxOne > 0) {
			int cur = 1 + numSquares(n - maxOne * maxOne);
			res = res < cur ? res : cur;
			maxOne--;
		}
		return res+1;
	}

	// 600 / 600 test cases passed.
	// Status: Accepted
	// Runtime: 1177 ms
	// 多了平方数的判断，本是不需要的
	// dp[i] = Math.min(dp[i], dp[i - j * j] + 1);  这个状态转移方程更好
	// dp[n] = min{dp[n-i],dp[i] i~[1~n/2]} n不是平方数
	// dp[n] = 1 n是平方数
	private static int numSquares1(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int x = (int) Math.sqrt(i);
			if (x*x==i) {
				dp[i] = 1;
			} else {
				for (int j = 1; j <= i / 2; j++) {
					min = min > dp[i - j] + dp[j] ? dp[i - j] + dp[j] : min;
				}
				dp[i] = min;
			}
		}
		 System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	private static boolean isSquares(int n) {
		for (int i = n / 2 + 1; i >= 1; i--) {
			if (i * i == n) {
				return true;
			}
		}
		return false;
	}

}
