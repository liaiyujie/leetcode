package ljt.bupt.leetcode.dp;

import java.util.Arrays;

public class UniquePathsII_63 {

	public static void main(String[] args) {
		// int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] obstacleGrid = { { 1 }, { 0 } };
		int res = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);

	}

	// 空间复杂度为O(n) // 没有AC 有些边缘问题比较难考虑
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		if (col == 1) {
			for (int i = 0; i < row; i++) {
				if (obstacleGrid[i][0] == 1)
					return 0;
			}
			return 0;
		}
		int[] dp = new int[col];
		// 初始化
		for (int i = 0; i < col; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[i] = 1;
			} else {
				for (int j = i; j < col; j++) {
					dp[j] = 0;
				}
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (j == 0) {
						dp[j] = 1;
					} else {
						dp[j] += dp[j - 1];
					}

				} else {
					dp[j] = 0;
				}
			}
		}

		return dp[col - 1];
	}

	// dp思想 空间复杂度为O(n2)
	private static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		int[][] dp = new int[row][col];
		// 初始化
		for (int i = 0; i < col; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			} else {
				for (int j = i; j < col; j++) {
					dp[0][j] = 0;
				}
				break;
			}
		}

		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				for (int j = i; j < row; j++) {
					dp[j][0] = 0;
				}
				break;
			}
		}

		// 往下按照递推方程写

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[row - 1][col - 1];
	}

}
