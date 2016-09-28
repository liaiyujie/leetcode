package ljt.bupt.leetcode;

public class CountNumberswithUniqueDigits_357 {

	public static void main(String[] args) {
		int n = 11;
		int re = countNumbersWithUniqueDigits(n);
		System.out.println(re);
	}
//	The idea is to append one digit at a time recursively    Backtracking 
//	(only append digits that has not been appended before). 
//	Number zero is a special case, because we don't want to deal with 
//	the leading zero, so it is counted separately at the beginning of 
//	the program. The running time for this program is O(10!) worst case, 
//	or O(n!) if n < 10.
	private static int countNumbersWithUniqueDigits(int n) {
		if (n > 10) {
			return countNumbersWithUniqueDigits(10);
		}
		int count = 1; // x == 0
		long max = (long) Math.pow(10, n);

		boolean[] used = new boolean[10];

		for (int i = 1; i < 10; i++) {
			used[i] = true;
			count += search(i, max, used);
			used[i] = false;
		}

		return count;
	}

	private static int search(long prev, long max, boolean[] used) {
		int count = 0;
		if (prev < max) {
			count += 1;
		} else {
			return count;
		}

		for (int i = 0; i < 10; i++) {
			if (!used[i]) {
				used[i] = true;
				long cur = 10 * prev + i;
				count += search(cur, max, used);
				used[i] = false;
			}
		}

		return count;
	}

	private static int countNumbersWithUniqueDigits1(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 10;
		for (int i = 2; i <= n; i++) {
			int res = helper(i);
			dp[i] = dp[i - 1] + res;
		}

		return dp[n];
	}

	private static int helper(int n) {// i>=2
		int re = 9;
		for (int i = 0; i < n - 1; i++) {
			re = re * (9 - i);
		}
		return re;
	}
}
