package ljt.bupt.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {

	public static void main(String[] args) {
//		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] matrix = {{10,10,10},{10,1,10},{10,10,10}};
//		int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
		List<int[]> res = pacificAtlantic(matrix);
		for(int[] i :res){
			System.out.println(Arrays.toString(i));
		}
	}
	
	
	private static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
	}
	
	static int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }


	
	
	private static List<int[]> pacificAtlantic2(int[][] matrix) {
		
		List<int[]> result = new ArrayList<>();
        int row = matrix.length;
        if(row == 0) return result;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] isReached = new boolean[row][col];
        for(int i = 0; i < row; ++i) {
            dfs(matrix, isReached, pacific, i, 0, Integer.MIN_VALUE, result);
            dfs(matrix, isReached, atlantic, i, col-1, Integer.MIN_VALUE, result);
        }
        for(int j = 0; j < col; ++j) {
            dfs(matrix, isReached, pacific, 0, j, Integer.MIN_VALUE, result);
            dfs(matrix, isReached, atlantic, row-1, j, Integer.MIN_VALUE, result);
        }
        return result;
		
	}
	private static void dfs(int[][] matrix, boolean[][] isReached, boolean[][] isVisited, int x, int y, int last, List<int[]> result) {
        if(x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || isVisited[x][y] || matrix[x][y] < last) return;
        if(isReached[x][y]) {
//            int[] tmp = new int[2];
//            tmp[0] = x;
//            tmp[1] = y;
            result.add(new int[]{x,y});
        }
        else isReached[x][y] = true;
        isVisited[x][y] = true;
        dfs(matrix, isReached, isVisited, x-1, y, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x+1, y, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x, y-1, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x, y+1, matrix[x][y], result);
    }
	
	//深度优先遍历看看该点是否能到Pacific  左 上 右  下的顺序
//	private static boolean DFS1(int[][] matrix, Point[][] point, int i, int j) {
//		if(i == 0 || j ==0 || point[i][j].isPacific())
//			return true;
//		//尝试向左走
//		if(j-1>=0&&matrix[i][j]>=matrix[i][j-1]){
//			if(point[i][j-1].isPacific()){
//				point[i][j].setPacific(true);
//				return true;
//			}else{
//				return DFS1(matrix, point, i, j-1);
//			}
//		}
//		if(i-1>=0&&matrix[i][j]>=matrix[i-1][j]){//尝试向上走
//			if(point[i-1][j].isPacific()){
//				point[i][j].setPacific(true);
//				return true;
//			}else{
//				return DFS1(matrix, point, i-1, j);
//			}
//		}
//		if(j+1<matrix[0].length&&matrix[i][j]>=matrix[i][j+1]){//尝试向右走
//			if(point[i][j+1].isPacific()){
//				point[i][j].setPacific(true);
//				return true;
//			}else{
//				return DFS1(matrix, point, i, j+1);
//			}
//		}
//		if(i+1<matrix.length&&matrix[i][j]>=matrix[i+1][j]){//尝试向xia走
//			if(point[i+1][j].isPacific()){
//				point[i][j].setPacific(true);
//				return true;
//			}else{
//				return DFS1(matrix, point, i+1, j);
//			}
//		}
////		else{
////			return false;
////		}
//		return false;
//		
//	}
//
//	
	
	private static boolean DFS2(int[][] matrix, Point[][] point, int i, int j) {
		
		return false;
	}

	//BSF
	//下面思想是： 遍历每一个点，对每一个点，先向左上遍历看是否能打带边缘或者某个点，该点能达到边缘。 再向右下遍历……
	//写了一个小时，最后过了50个测试样例，有些测试样例过不去，是自己的思想的问题，这题不能以这个思想写。
	//因为有些点直接左上不能达到要求，但是可以向右走几步或者下走几步然后左上最后达到要求。所以没AC o(╯□╰)o
	//还是对每个点都得四个方向深度优先走
	private static List<int[]> pacificAtlantic1(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		int col = matrix.length ;
		if(col == 0)
			return res;
		int row = matrix[0].length ; 
		//初始化
		Point[][] point = new Point[col][row];
		for(int i = 0 ; i < col ;i++){
			for(int j = 0 ; j< row ;j++){
				Point p = new Point();
				if(i == 0 || j ==0)
					p.setPacific(true);
				if(i == col-1 || j == row -1)
					p.setAtlantic(true);
				point[i][j] = p;
			}
		}
		//对矩阵中的每一个点，先向右上搜索，看下能不能达到某个点，该点的横坐标或者纵坐标为0
		//对矩阵中的每一个点，先向右上搜索，看下能不能达到某个点，该点的的标记isPacific==true
		for(int i = 1 ; i< col ;i++){
			for(int j = 1; j< row ;j++){
//				pacificHelper(matrix,point,i,j);
				if(matrix[i][j]>=matrix[i-1][j]){//看下是否能向上走
					if(point[i-1][j].isPacific()){
						point[i][j].setPacific(true); 
						continue;
					}else{
						if(matrix[i][j]>=matrix[i][j-1]){//看下是否能向左走
							if(point[i][j-1].isPacific()){
								point[i][j].setPacific(true); 
								continue;
							}
						}
					}
				}else if(matrix[i][j]>=matrix[i][j-1]){//看下是否能向左走
					if(point[i][j-1].isPacific()){
						point[i][j].setPacific(true); 
						continue;
					}
				}else{
					continue;
				}
			}
		}
		
		for(int i = 0 ; i< col ;i++){
			for(int j = 0 ; j < row ;j++){
				System.out.print(point[i][j].isPacific() + " ");
			}
			System.out.println();
		}
		
		//对矩阵中的每一个点，向右下搜索，看下能不能达到某个点，该点的横坐标或者纵坐标为
		//对矩阵中的每一个点，先向右下搜索，看下能不能达到某个点，该点的的标记isAtlantic==true
		for(int i = col-2 ; i>=0 ;i--){
			for(int j = row-2; j>=0 ;j--){
//				atlanticHelper(matrix,point,i,j);
				if(matrix[i][j]>=matrix[i+1][j]){//看下是否能向下走
					if(point[i+1][j].isAtlantic()){
						point[i][j].setAtlantic(true); 
						continue;
					}else{
						if(matrix[i][j]>=matrix[i][j+1]){//看下是否能向右走
							if(point[i][j+1].isAtlantic()){
								point[i][j].setAtlantic(true); 
								continue;
							}
						}
					}
				}else if(matrix[i][j]>=matrix[i][j+1]){//看下是否能向右走
					if(point[i][j+1].isAtlantic()){
						point[i][j].setAtlantic(true); 
						continue;
					}
				}else{
					continue;
				}
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0 ; i< col ;i++){
			for(int j = 0 ; j < row ;j++){
				System.out.print(point[i][j].isAtlantic() + " ");
			}
			System.out.println();
		}
		
		//遍历point  查找point中isPacific==true&&isAtlantic==true
		for(int i = 0 ; i< col ;i++){
			for(int j = 0 ; j < row ;j++){
				if(point[i][j].isPacific()&&point[i][j].isAtlantic()){
					res.add(new int[]{i,j});
				}
			}
		}
		
		return res;
	}
	
}


class Point{
//	private int i;
//	private int j;
	private boolean isPacific;
	private boolean isAtlantic;
	
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(boolean isPacific, boolean isAtlantic) {
		super();
//		this.i = i;
//		this.j = j;
		this.isPacific = isPacific;
		this.isAtlantic = isAtlantic;
	}

//	public int getI() {
//		return i;
//	}
//
//	public void setI(int i) {
//		this.i = i;
//	}
//
//	public int getJ() {
//		return j;
//	}
//
//	public void setJ(int j) {
//		this.j = j;
//	}

	public boolean isPacific() {
		return isPacific;
	}

	public void setPacific(boolean isPacific) {
		this.isPacific = isPacific;
	}

	public boolean isAtlantic() {
		return isAtlantic;
	}

	public void setAtlantic(boolean isAtlantic) {
		this.isAtlantic = isAtlantic;
	}
	
}