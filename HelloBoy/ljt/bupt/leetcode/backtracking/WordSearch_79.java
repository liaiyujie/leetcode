package ljt.bupt.leetcode.backtracking;

public class WordSearch_79 {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCEDA";
		boolean res = exist(board, word);
		System.out.println(res);
	}

	
	
	//参照网上写的DFS，别人写的不会陷入到跳出整个回溯的过程，仔细分析人家代码
	private static boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
	        return true;
	    }
	    if (board == null || board.length == 0 || board[0].length == 0) {
	        return false;
	    }
	    boolean[][] visit = new boolean[board.length][board[0].length];
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	           if ( helper(board, visit, word, i, j, 0)) {
	               return true;
	           }
	        }
	    }
	    return false;
	}
	public static boolean helper(char[][] board, boolean[][] visit, String word, int i, int j, int pos) {
	    if (pos == word.length()) {
	        return true;
	    }
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || board[i][j] != word.charAt(pos)) {
	        return false;
	    }
	    visit[i][j] = true;
	    boolean res = helper(board, visit, word, i + 1, j, pos + 1) || helper(board, visit, word, i - 1, j, pos + 1) || helper(board, visit, word, i , j - 1, pos + 1) || helper(board, visit, word, i, j + 1, pos + 1);
	    visit[i][j] = false;
	    return res;
	}



	//我自己写的dfs  经常会遇到需要跳出整个回溯的问题，现在有种做法就是设一个全局boolean变量，找到一个置为true。然后下面就对这个boolean进行判断剪枝，详细情况见exist1
	private static boolean exist1(char[][] board, String word) {
		char[] words = word.toCharArray();
		if (board.length == 0 || "".equals(word) || word == null)
			return false;
		if (board[0].length == 0)
			return false;

		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == words[0]) {// 找到一个开头字符相同的
					used[i][j] = true;
					boolean res = DFS(board, i, j, used,words, 1);
					used[i][j] = false;
					if (res) {
						return res;
					}
				}
			}
		}
		return false;
	}

	static int[][] goes = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };// 下 上 右
																		// 左
																		// 的方向深搜
	static boolean flag = false;
	private static boolean DFS(char[][] board, int row, int col, boolean[][] used,char[] words, int wordsIndex) {
		if (wordsIndex == words.length) {
			flag = true;
			return flag;
		}
//   刚开始一直超时，因为没有做剪枝，if(flag)  return flag; 后AC  14ms  超过50%
		for (int i = 0; i < 4; i++) {
			if (row + goes[i][0] < board.length && row + goes[i][0] >= 0 && col + goes[i][1] < board[0].length&& col + goes[i][1] >= 0 && wordsIndex + 1 <= words.length&& board[row + goes[i][0]][col + goes[i][1]] == words[wordsIndex]&&used[row + goes[i][0]][col + goes[i][1]]==false){
				if(flag)
					return flag;
				used[row + goes[i][0]][col + goes[i][1]] = true;
				DFS(board, row + goes[i][0], col + goes[i][1], used,words, wordsIndex + 1);
				used[row + goes[i][0]][col + goes[i][1]] = false;
			}
		}
		return flag;
	}

}
