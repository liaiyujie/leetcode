package ljt.bupt.leetcode.dp;

import java.util.Arrays;

public class UniquePaths_62 {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		int res = uniquePaths(m, n);
		System.out.println(res);

	}

	// 带滚动数组，空间复杂度由O(n*m)变成O(n)
	private static int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		// for(int i = 0 ; i< n ;i++){
		// dp[i] = 1;
		// }
		Arrays.fill(dp, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] +=dp[j-1];
			}
		}
		return dp[n-1];
	}

	// dp 两个版本，一个是不带滚动数组版的，一个带滚动数组版
	// dp[m][n] = dp[m-1][n] + dp[m][n-1]
	private static int uniquePaths1(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

}
