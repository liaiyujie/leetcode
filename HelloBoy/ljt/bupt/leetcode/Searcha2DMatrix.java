package ljt.bupt.leetcode;

import java.util.Arrays;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int target = 3;
		boolean bool = searchMatrix(matrix,target);
		System.out.println(bool);
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
		int[] nums = new int[matrix.length *matrix[0].length];
		int len = 0;
		for(int i = 0; i<matrix.length ; i++){
			for(int j = 0; j<matrix[i].length ; j++){
				nums[len++] = matrix[i][j];
			}
		}
//		for(int i = 0; i< len ; i++){
//			System.out.println(nums[i]);
//		}
		//接下来 在nums数组中使用二分查找 查找目标target
//		int index = Arrays.binarySearch(nums, target);
//		return index >=0 ? true : false;
		
		
		//接下来 在nums数组中使用二分查找 查找目标target,自己写一个
		int low = 0;
		int high = len-1;
		while(low <= high){
			int mid = low + ((high - low)>>1);//位运算符优先级低
			//int mid = (high+low)/2;
			if(nums[mid]<target){
				low = mid+1;
			}else if(nums[mid]>target){
				high = mid-1;
			}else{
				return true;
			}
		}
		return false;
	}

}
