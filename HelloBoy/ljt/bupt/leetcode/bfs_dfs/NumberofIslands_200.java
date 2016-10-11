package ljt.bupt.leetcode.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands_200 {
	// 该题可以用DFS &&BFS两种方法解答
	static private int n;
	static private int m;
	static int[][] goes = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }// 一个点的上下左右点
	};

	public static void main(String[] args) {
		// char[][] grid = { { '0', '1', '0' }, { '1', '0', '1' }, { '0', '1',
		// '0' } };
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int res = numIslands2(grid);
		System.out.println(res);
	}

	private static int numIslands(char[][] grid) {// bfs
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;
		int M = grid.length;
		int N = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					addNode(i, j, queue, grid);
					while (!queue.isEmpty()) {
						int[] node = queue.remove();
						grid[node[0]][node[1]] = '2';
						addNode(node[0], node[1] - 1, queue, grid);
						addNode(node[0], node[1] + 1, queue, grid);
						addNode(node[0] - 1, node[1], queue, grid);
						addNode(node[0] + 1, node[1], queue, grid);
					}
				}
			}
		}
		return count;
	}

	private static void addNode(int i, int j, Queue<int[]> queue, char[][] grid) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '2';
			queue.add(new int[] { i, j });
		}
	}

	// The basic idea is to traverse all the points, every time when current
	// point is land, the program will stop and
	// found out the whole land that is connected with this land, and mark them
	// as traversed (by giving them value 0).
	// So the sub problem now is to solve the problem of finding connected land.
	// This we can use DFS and traversed mark.
	// Every time we find a land, we use DFS on its nearby & not traversed land.
	// public:
	// int numIslands(vector<vector<char>>& grid) {
	// int result=0;
	// for (int i=0;i<grid.size();i++){
	// for (int j=0;j<grid[0].size();j++){
	// if (grid[i][j]=='1'){
	// result += 1;
	// dfs(i,j,grid);
	// }
	// }
	// }
	// return result;
	// }
	// void dfs(int i,int j,vector<vector<char>>& grid){
	// grid[i][j] = -1;
	// if (i+1<grid.size() && grid[i+1][j]=='1') dfs(i+1,j,grid);
	// if (j+1<grid[0].size() && grid[i][j+1]=='1') dfs(i,j+1,grid);
	// if (i-1<grid[0].size() && grid[i-1][j]=='1') dfs(i-1,j,grid);
	// if (j-1<grid[0].size() && grid[i][j-1]=='1') dfs(i,j-1,grid);
	// }
	// };
	private static int numIslands2(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private static void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		// 下面是DFS，按照 先下 上 右 左 的方向遍历。
		// 一般深度优先遍历是需要栈的支持，而递归即为栈。也可以自己用栈来实现，但代码会很长
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
	}

	// 自己先尝试用BFS(层序遍历写一下)
	// 没有AC，还没理解题意，题目说水平或者垂直才算连接上，而我认为不但水平垂直，斜着也算链接上
	private static int numIslands1(char[][] grid) {
		int res = 0;
		int rowlen = grid.length + 2;
		int collen = grid[0].length + 2;
		boolean[][] mark = new boolean[rowlen + 2][collen + 2];
		CharAndIndex[][] cai = new CharAndIndex[rowlen + 2][collen + 2];
		// 下面的两个循环是为矩阵添加一个外墙。
		for (int i = 0; i < rowlen; i++) {
			cai[i][0] = new CharAndIndex('0', i, 0);
			cai[i][collen - 1] = new CharAndIndex('0', i, collen - 1);
		}
		for (int i = 0; i < collen; i++) {
			cai[0][i] = new CharAndIndex('0', 0, i);
			cai[rowlen - 1][i] = new CharAndIndex('0', rowlen - 1, i);
		}
		for (int i = 0; i < rowlen - 2; i++) {
			for (int j = 0; j < collen - 2; j++) {
				cai[i + 1][j + 1] = new CharAndIndex(grid[i][j], i + 1, j + 1);
			}
		}
		Queue<CharAndIndex> queue = new LinkedList<>();
		queue.offer(cai[0][0]);
		mark[0][0] = true;
		boolean flagIsBeforContainOne = false;
		while (!queue.isEmpty()) {
			int len = queue.size();
			boolean flagIsAfterContainOne = false;
			for (int k = 0; k < len; k++) {
				CharAndIndex tmp = queue.poll();
				if (tmp.value == '1') {
					flagIsBeforContainOne = true;
					flagIsAfterContainOne = true;
				}
				int i = tmp.getI();
				int j = tmp.getJ();
				if ((i + 1) < rowlen && mark[i + 1][j] == false) {
					queue.offer(cai[i + 1][j]);
					mark[i + 1][j] = true;
				}
				if ((j + 1) < collen && mark[i][j + 1] == false) {
					queue.offer(cai[i][j + 1]);
					mark[i][j + 1] = true;
				}
			}
			if (flagIsAfterContainOne == false && flagIsBeforContainOne == true) {
				res++;
				flagIsBeforContainOne = false;
			}
		}
		return res;
	}

	/*
	 * private static void DFS(int x, int y,int rowlen,int collen,char[][]
	 * grid,boolean[][] mark) { for(int i = 0 ; i<4;i++){ int nx = x +
	 * goes[i][0]; int ny = y + goes[0][i];
	 * if(nx<0||nx>rowlen||ny<0||ny>collen){ continue; } if(grid[nx][ny]=='0')
	 * continue; if(mark[nx][ny]==true) continue; mark[nx][ny] = true;
	 * DFS(nx,ny,rowlen,collen,grid,mark); } return ; }
	 */

}

class CharAndIndex {
	char value;
	int i;
	int j;

	public CharAndIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharAndIndex(char value, int i, int j) {
		super();
		this.value = value;
		this.i = i;
		this.j = j;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
