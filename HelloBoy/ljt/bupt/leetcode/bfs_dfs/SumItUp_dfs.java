package ljt.bupt.leetcode.bfs_dfs;

import java.util.Scanner;

/*input
4 6 4 3 2 2 1 1
5 3 2 1 1
400 12 50 50 50 50 50 50 25 25 25 25 25 25
0 0

output
Sums of 4:
4
3+1
2+2
2+1+1
Sums of 5:
NONE
Sums of 400:
50+50+50+50+50+50+25+25+25+25
50+50+50+50+50+25+25+25+25+25+25*/
public class SumItUp_dfs {
	static int sum, n;
	static int arr[] = new int[20];
	static int j, FLAG;
	static boolean used[] = new boolean[20];
	static int r[] = new int[20];

	static void f(int now, int total) {
		int i;
		if (total == sum) {
			FLAG = 1;
			for (i = 0; i < n; i++)
				if (used[i]) {
					System.out.printf("%d", arr[i]);
					break;
				}
			for (i++; i < n; i++) {
				if (used[i])
					System.out.printf("+%d", arr[i]);
			}
			System.out.println("");
			return;
		}
		for (i = now; i < n; i++) {
			if (total + arr[i] > sum)
				continue;
			if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])
				continue;
			used[i] = true;
			f(i + 1, total + arr[i]);
			used[i] = false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			sum = sc.nextInt();
			n = sc.nextInt();
			if (n == 0)
				break;
			FLAG = 0;
			for (j = 0; j < n; j++)
				arr[j] = sc.nextInt();
			System.out.printf("Sums of %d:\n", sum);
			dfs(0, 0, sum);
			if (FLAG == 0)
				System.out.println("NONE");
		}
	}

	private static void dfs(int len, int k, int sum) {//len为加入到结果数组的长度，k为遍历当前数组的长度

		if (sum == 0) {
			FLAG = 1;
			for (int i = 0; i < len; i++) {
				if (i == 0) {
					System.out.printf("%d", r[i]);
				} else {
					System.out.printf("+%d", r[i]);
				}

			}
			System.out.println();
			return;
		}
		for (int i = k; i < n; i++) {
			if (i == k || arr[i] != arr[i - 1] && sum - arr[i] >= 0) {// 去除重复的操作
				r[len] = arr[i];
				dfs(len + 1, i + 1, sum - arr[i]);
			}
		}
	}
}
