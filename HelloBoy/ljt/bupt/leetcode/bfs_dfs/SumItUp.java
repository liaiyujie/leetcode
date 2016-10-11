package ljt.bupt.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumItUp {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int sum = in.nextInt();
			int count = in.nextInt();
			if (sum == 0 && count == 0)
				return;
			List<List<Integer>> list = new ArrayList<>();
			int[] nums = new int[count];
			for (int i = 0; i < count; i++) {
				nums[i] = in.nextInt();
			}
			boolean[] used = new boolean[count];

			backtracking(list, nums, sum, used, 0);

			// for (List l : list) {
			// System.out.println(l);
			// }
			System.out.println("Sums of " + sum + ":");
			if (list.size() == 0)
				System.out.println("NONE");
			else {
				for (List l : list) {
					if (l.size() == 1)
						System.out.println(l.get(0));
					else {
						for (int i = 0; i < l.size() - 1; i++) {
							System.out.print(l.get(i) + "+");
						}
						System.out.println(l.get(l.size() - 1));
					}

				}
			}

		}
	}

	private static void backtracking(List<List<Integer>> list, int[] nums, int sum, boolean[] used, int start) {
		if (sum <= 0) {
			if (sum == 0) {
				List<Integer> tmp = new ArrayList<>();
				for (int i = 0; i < nums.length; i++) {
					if (used[i]) {
						tmp.add(nums[i]);
					}
				}
				list.add(tmp);
			}
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false)
				continue;
			used[i] = true;
			backtracking(list, nums, sum - nums[i], used, i + 1);
			used[i] = false;
		}

	}

}
