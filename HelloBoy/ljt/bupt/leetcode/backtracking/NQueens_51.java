package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//http://blog.csdn.net/hackbuteer1/article/details/6657109
public class NQueens_51 {

	public static void main(String[] args) {

		int n = 2;
		List<List<String>> res = solveNQueens(n);
		for (List l : res)
			System.out.println(l);

	}

	// 把棋盘存储为一个N维数组a[N]，数组中第i个元素的值代表第i行的皇后位置，
	// 这样便可以把问题的空间规模压缩为一维O(N)，在判断是否冲突时也很简单，
	// 首先每行只有一个皇后，且在数组中只占据一个元素的位置，行冲突就不存在了，
	// 其次是列冲突，判断一下是否有a[i]与当前要放置皇后的列j相等即可。至于斜线冲突，
	// 通过观察可以发现所有在斜线上冲突的皇后的位置都有规律即它们所在的行列互减的绝对值相等，
	// 即| row – i | = | col – a[i] | 。这样某个位置是否可以放置皇后的问题已经解决。
	//
	private static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
//		List<String> list = new ArrayList<>();
		int[] message = new int[n];
		for (int i = 0; i < n; i++) {
			message[i] = -100;
		}
		backtracking(res, message, 0);
		return res;
	}

	private static void backtracking(List<List<String>> res, int[] message, int depth) {
		if (depth == message.length) {// 打印结果
//			System.out.println(Arrays.toString(message));
//			[1, 3, 0, 2]   说明在第一行的第二个位置，第二行di4个位置 ，第三行第一个个位置，第四行第三个位置 为Q  其余位置为.
//			[2, 0, 3, 1]
			List<String> list = new ArrayList<>();
			for(int i = 0 ; i< message.length ;i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < message.length ;j++){
					sb.append('.');
				}
				sb.setCharAt(message[i], 'Q'); 
				list.add(sb.toString());
			}
			res.add(list);
		} else {
			for (int i = 0; i < message.length; i++) {// 试探第depth行的每一列
				if (can_place(message, depth, i)) {
					message[depth] = i;
					backtracking(res, message, depth + 1);
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
		
//		//不会有行冲突，监测列冲突
//		for(int i = 0 ; i < message.length ;i ++){
//			if(message[i] == n)
//				return false;
//		}
//		//监测斜线冲突
//		for(int i = 0 ; i < message.length-1 ;i ++){
//			for(int j = i+1 ; j < message.length ;j++){
//				if(Math.abs(j-i)==Math.abs(message[j]-message[i]))
//					return false;
//			}
//		}
		
	}

}
