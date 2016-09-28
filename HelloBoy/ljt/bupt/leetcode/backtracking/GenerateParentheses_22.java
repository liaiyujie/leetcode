package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
	/**
	 * 定义全局变量,无需再传值到各个方法
	 */
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {

		List<String> l = generateParenthesis1(3);
		System.out.println(l);

	}

	// The idea here is to only add '(' and ')' that we know will guarantee us
	// a solution (instead of adding 1 too many close).
	// Once we add a '(' we will then discard it and try a ')' which can only
	// close a valid '('. Each of these steps are recursively called.

	private static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	private static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}
	
//	最后，重申，凡是遇到要求全部可能集合、可能性、可能性个数的题目，立马考虑递归回溯求解！！！
	private static List<String> generateParenthesis1(int n) {
		/**
		 * 初始状态,左括号和右括号都可以添加n个,所以左右都传了n
		 */
		generateLeftsAndRights("", n, n);
		return list;

	}

	private static void generateLeftsAndRights(String subList, int left, int right) {
		/**
		 * 最后可能出现的情况, 右括号比左括号先用完, 明显不是合法的串,应剔除
		 */
		if (left > right)//left剩下的比right多，不合法
			return;

		/**
		 * 左括号还剩得有, 优先用左括号 该方法将不断深搜, 直到左括号全部用完
		 */
		if (left > 0) {
			generateLeftsAndRights(subList + "(", left - 1, right);
		}

		/**
		 * 开始用右括号
		 */
		if (right > 0) {
			generateLeftsAndRights(subList + ")", left, right - 1);
		}

		/**
		 * 基准情况, 各自都用完, 说明已经形成了一个合法的串,将该串加入list返回
		 */
		if (left == 0 && right == 0) {
			list.add(subList);
			return;
		}
	}

}