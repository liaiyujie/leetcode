package ljt.bupt.poj.unionfind;

import java.util.Arrays;
import java.util.Scanner;

public class poj_1611 {
	
	static int[] student;
	static int[] ans;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (n == 0 && m == 0)
				return;
			student = new int[n];
			ans = new int[n];
			Arrays.fill(ans, 1);
			for (int i = 0; i < n; ++i) {
				student[i] = i;
			}
			while (m-- > 0) {
				int k = in.nextInt();
				int x = in.nextInt();
				for (int i = 0; i < k - 1; i++) {
					int y = in.nextInt();
					union(x, y);
				}
			}
			System.out.println(ans[find(0)]);
		}

	}

	private static int find(int x) {
		if (x != student[x]) {
			student[x] = find(student[x]);
		}
		return student[x];
	}

	private static void union(int node1, int node2) {
		int x = find(node1);
		int y = find(node2);
		if (x == y) {
			return;
		} else {
			if (x > y) {
				student[y] = x;
				ans[x] += ans[y];
			} else {
				student[x] = y;
				ans[y] += ans[x];
			}
		}

	}

}
