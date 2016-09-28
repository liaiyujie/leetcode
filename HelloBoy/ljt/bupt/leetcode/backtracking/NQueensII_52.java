package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII_52 {
	private static int count = 0;
	public static void main(String[] args) {

		int n = 2;
		int res = solveNQueens(n);
		System.out.println(res);

	}

	private static int solveNQueens(int n) {
		int[] message = new int[n];
		for (int i = 0; i < n; i++) {
			message[i] = -100;
		}
		backtracking(message, 0);
		return count;
	}

	private static void backtracking(int[] message, int depth) {
		if (depth == message.length) {// 打印结果
			count++;
		} else {
			for (int i = 0; i < message.length; i++) {// 试探第depth行的每一列
				if (can_place(message, depth, i)) {
					message[depth] = i;
					backtracking(message, depth + 1);
					message[depth] = -100;
				}
			}
		}

	}

	private static boolean can_place(int[] message, int row, int col) {
		
		for(int i = 0 ; i < message.length ;i ++){
			if(message[i] == col || Math.abs(i - row) == Math.abs(message[i] - col))
				return false;
		}
		return true;
	}

}
