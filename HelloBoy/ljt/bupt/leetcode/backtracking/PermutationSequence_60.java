package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {

	static boolean isEnd = false;
	static int count = 0;

	public static void main(String[] args) {
		int n = 4;
		int k = 5;
		// for(int i = 1; i<= 24 ;i++){
		// String res = getPermutation(n, i);
		// count=0;
		// isEnd = false;
		// System.out.println(res);
		// }
		String res = getPermutation(n, k);
		System.out.println(res);

	}
//  发现其中的规律，直接定位每一个数。
	private static String getPermutation(int n, int k) {
		int pos = 0;
		List<Integer> numbers = new ArrayList<Integer>();
		int[] factorial = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			factorial[i] = sum;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}

		// create a list of numbers to get indices
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		// numbers = {1, 2, 3, 4}

		k--;

		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i];
			sb.append(String.valueOf(numbers.get(index)));
			numbers.remove(index);
			k -= index * factorial[n - i];
		}

		return String.valueOf(sb);
	}

	
	
	// 使用回溯法写的，耗时很大，380ms。
	private static String getPermutation1(int n, int k) {
		if (n < 1 || k < 1)
			return "";
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[n];

		backtracking(res, list, used, n, k);
		// for(List l :res)
		// System.out.println(l);
		if (res.size() == 0)
			return "fail";
		list = res.get(0);
		String s = "";
		for (Integer e : list) {
			s += e;
		}
		return s;
	}

	private static void backtracking(List<List<Integer>> res,
			List<Integer> list, boolean[] used, int n, int k) {
		if (list.size() == n) {
			count++;
			if (count == k) {
				isEnd = true;
				List<Integer> tmp = new ArrayList<Integer>(list);
				res.add(tmp);
			}

			// if(res.size() == k){
			// //结束,这里面不写任何代码，超时，所以这里要检测当等于K的时候，就返回 遇到TLE，
			// // 然后加了isEnd这个之后提交，出现了MLE。内存占用太大，就不能将前K个结果全部储存
			// isEnd = true;
			// }
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (used[i - 1] == true || isEnd == true)
				continue;
			used[i - 1] = true;
			list.add(i);
			backtracking(res, list, used, n, k);
			list.remove(list.size() - 1);
			used[i - 1] = false;
		}

	}

}
