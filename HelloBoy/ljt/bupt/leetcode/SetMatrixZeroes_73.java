package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{4,5,0,7},{5,6,7,8},{0,7,8,9},{7,8,9,10}};
		for(int i = 0 ; i<matrix.length ; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		setZeroes(matrix);
		for(int i = 0 ; i<matrix.length ; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	//下面我的思想是用兩個列表分別儲存為0的元素的橫軸坐標。
	//而該思想沒有使用額外的內存空間，先遍歷一遍數組，出現為0的元素，將該元素的最上面和最左面的元素置0
	private static void setZeroes(int[][] matrix) {
		 int col0 = 1, rows = matrix.length, cols = matrix[0].length;

		    for (int i = 0; i < rows; i++) {
		        if (matrix[i][0] == 0) 
		        	col0 = 0;
		        for (int j = 1; j < cols; j++)
		            if (matrix[i][j] == 0)
		                matrix[i][0] = matrix[0][j] = 0;
		    }

		    for (int i = rows - 1; i >= 0; i--) {
		        for (int j = cols - 1; j >= 1; j--)
		            if (matrix[i][0] == 0 || matrix[0][j] == 0)
		                matrix[i][j] = 0;
		        if (col0 == 0) matrix[i][0] = 0;
		    }
		
	}

	private static void setZeroes1(int[][] matrix) {
		if(matrix == null)
			return ;
		int m = matrix.length ;
		int n = matrix[0].length ;
		List<Integer> rowli = new ArrayList<>();
		List<Integer> colli = new ArrayList<>();
		int zeroesCount = 0;
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(matrix[i][j]==0){
					zeroesCount++;
					rowli.add(i);
					colli.add(j);
					
				}
			}
		}
		if(zeroesCount == 0 ){
			return ;
		}else{
			for(int i = 0 ; i < m ; i++){
				if(!rowli.contains(i)){
					continue;
				}else{
					for(int j = 0 ; j < n ; j++){
						matrix[i][j] = 0;
					}
				}
			}
			for(int i = 0 ; i < n ; i++){
				if(!colli.contains(i)){
					continue;
				}else{
					for(int j = 0 ; j < m ; j++){
						matrix[j][i] = 0;
					}
				}
			}
		}
	}

}
