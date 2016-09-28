package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {};
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
		List<Integer> res = spiralOrder(matrix);
		 System.out.println(res);
	}
//	This is a very simple and easy to understand solution. 
//	I traverse right and increment rowBegin, then traverse down and decrement colEnd, 
//	then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.
//
//	The only tricky part is that when I traverse left or up I have to check 
//	whether the row or col still exists to prevent duplicates. 
//	If anyone can do the same thing without that check, please let me know!
	private static List<Integer> spiralOrder(int[][] matrix) {//和我的TakeOff函数思想很想，不过人家编码很好，直接一下子解出来
		List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
	}

	private static List<Integer> spiralOrder2(int[][] matrix) {//和下面我写的同样的思想，但是人家的编码更棒更短
		List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            result.add(matrix[0][i]); //Add the first row of the matrix into result list
        }
        
        //Construct a new array without the first row by let the last column of the original matrix 
        //be the first row in the new column and so on. Like left rotate the original matrix without the first row. 
        if (matrix.length > 1) {
            int[][] newMatrix = new int[matrix[1].length][matrix.length - 1];
            int row = 0;
            //下面的循环就是将去掉第一行的矩阵向左旋转了90度后存入新的矩阵中
            for (int i = matrix[1].length - 1; i >= 0; i--) {
                for (int j = 1; j < matrix.length; j++) {
                    newMatrix[row][j - 1] = matrix[j][i];
                    //System.out.println(row + " " + (j - 1) + ":" + newMatrix[row][j - 1] + ", ");
                }
                row++;
            }
            result.addAll(spiralOrder(newMatrix));
        }
        
        return result;
	}

	private static List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		while(matrix!= null){
			res.addAll(TakeOff(matrix));
			int len1 = matrix.length;
			if(len1==0){
				return res;
			}
			int len2 = matrix[0].length;
			if(len1<=2||len2<=2){
//				res.addAll(TakeOff(matrix));
				return res;
			}
			int[][] m = matrix;
			matrix = null;
			matrix = new int[len1-2][len2-2];
			for(int i = 1 ; i <len1-1 ; i++){
				for(int j = 1 ; j< len2-1 ; j++){
					matrix[i-1][j-1] = m[i][j];
				}
			}
		}
		
		
		return res;
	}
	private static List<Integer> TakeOff(int[][] matri){
		List<Integer> res = new ArrayList<>();
		if(matri.length==0){
			return res;
		}else if(matri.length==1){
			for(int i = 0 ; i<matri[0].length ; i++){
				res.add(matri[0][i]);
			}
			return res ;
		}else if(matri[0].length ==1){
			for(int i = 0 ; i<matri.length ; i++){
				res.add(matri[i][0]);
			}
			return res ;
		}else{
			for(int i = 0 ; i< matri[0].length ;i++){
				res.add(matri[0][i]);
			}
			for(int i = 1 ; i< matri.length ;i++){
				res.add(matri[i][matri[0].length-1]);
			}
			for(int i = matri[0].length-2 ; i>=0 ;i--){
				res.add(matri[matri.length-1][i]);
			}
			for(int i = matri.length-2 ; i>=1 ;i--){
				res.add(matri[i][0]);
			}
			return res;
		}
		
	}

}
