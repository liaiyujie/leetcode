package ljt.bupt.leetcode.dp;

public class MaximalSquare_221 {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		// char[][] matrix = { { '1'} };
		int res = maximalSquare(matrix);
		System.out.println(res);
	}

	// 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是
	// 某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。这是定性的判断，
	// 那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，最多比它的上方，
	// 左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，左方和左上方为右下角的正方形的大小
	// 都一样的，这样加上该点就可以构成一个更大的正方形。但如果它的上方，左方和左上方为右下角的正方形的大小
	// 不一样，合起来就会缺了某个角落，这时候只能取那三个正方形中最小的正方形的边长加1了。
	// 假设dpi表示以i,j为右下角的正方形的最大边长，则有
	// dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1; if matrix[i][j] == 1
	// dp[i][j] = 0; if matrix[i][j] = 0
// 10ms
	private static int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int[][] dp = new int[row][col];

		int maxLen = 0;// 记录最大的边长
		// 初始化第一行第一列为本身
		for (int i = 0; i < row; i++) {
			dp[i][0] = matrix[i][0] - '0';
			if (dp[i][0] > maxLen) {
				maxLen = dp[i][0];
			}
		}
		for (int i = 0; i < col; i++) {
			dp[0][i] = matrix[0][i] - '0';
			if (dp[0][i] > maxLen) {
				maxLen = dp[0][i];
			}
		}

		// 根据递推方程
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
					min = min < dp[i][j - 1] ? min : dp[i][j - 1];
					dp[i][j] = min + 1;
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
					}
				}

			}
		}
		return maxLen * maxLen;
	}

	// 70ms ,需要用dp思想
	// 穷举，边长为边长到1为最短的边
	private static int maximalSquare1(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int minLen = row < col ? row : col;
		for (int k = minLen; k >= 1; k--) {
			if (hasSquare(k, matrix)) {
				return k * k;
			}
		}
		return 0;
	}

	// 检测矩阵matrix中是否有长度为k 的正方形，里面元素全为’1‘
	private static boolean hasSquare(int k, char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return false;
		int col = matrix[0].length;
		// 以 （i，j）为左上顶点，检测边长为k 的正方形中元素是否全为’1‘
		for (int i = 0; i + k <= row; i++) {
			for (int j = 0; j + k <= col; j++) {
				if (isSquare(i, j, k, matrix)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSquare(int row, int col, int k, char[][] matrix) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (matrix[row + i][col + j] != '1') {
					return false;
				}
			}
		}
		return true;
	}

}
