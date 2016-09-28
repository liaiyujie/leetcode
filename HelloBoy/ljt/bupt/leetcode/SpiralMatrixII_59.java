package ljt.bupt.leetcode;

import java.util.Arrays;

public class SpiralMatrixII_59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		int[][] matrix = new int[n][n];
		matrix = generateMatrix(n);
		for(int i = 0 ; i<matrix.length ; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	private static int[][] generateMatrix(int n) {
		if(n == 0){
            return null;
        }
		int[][] matrix = new int[n][n];
		
		int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix.length - 1;
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
        	
            for (int j = colBegin; j <= colEnd; j ++) {
                matrix[rowBegin][j] = count++;
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                matrix[j][colEnd] = count++;
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    matrix[rowEnd][j] = count++;
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    matrix[j][colBegin] = count++;
                }
            }
            colBegin ++;
        }
        
        return matrix;
	}

}
