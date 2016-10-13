package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

	public static void main(String[] args) {
		int n = 3;
		List<Integer> res = grayCode(n);
		System.out.println(res);
	}

	// 递归生成码表
	private static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n <= 1) {
			for (int i = 0; i <= n; i++) {
				result.add(i);
			}
			return result;
		}
		result = grayCode(n - 1);
		ArrayList<Integer> r1 = reverse(result);
		int x = 1 << (n - 1);
		for (int i = 0; i < r1.size(); i++) {
			r1.set(i, r1.get(i) + x);
		}
		result.addAll(r1);
		return result;
	}

	public static ArrayList<Integer> reverse(ArrayList<Integer> r) {
		ArrayList<Integer> rev = new ArrayList<Integer>();
		for (int i = r.size() - 1; i >= 0; i--) {
			rev.add(r.get(i));
		}
		return rev;
	}

	// 异或转换
	private static List<Integer> grayCode1(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			res.add((i / 2) ^ i);
		}
		return res;
	}

}
