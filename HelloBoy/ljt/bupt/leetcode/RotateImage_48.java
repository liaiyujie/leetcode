package ljt.bupt.leetcode;

public class RotateImage_48 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	// Follow up:
	// Could you do this in-place?

	// AC Java in place solution with explanation Easy to understand.
	// The idea was firstly transpose the matrix and then flip it symmetrically.
	// For instance,
	//
	// 1 2 3
	// 4 5 6
	// 7 8 9
	//
	// after transpose, it will be swap(matrix[i][j], matrix[j][i])
	//
	// 1 4 7
	// 2 5 8
	// 3 6 9
	//
	// Then flip the matrix horizontally. (swap(matrix[i][j],
	// matrix[i][matrix.length-1-j])
	//
	// 7 4 1
	// 8 5 2
	// 9 6 3
	//
	// Hope this helps.
	private static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];//转置，第i行变成第i列
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}

	}

	// 没有就地旋转
	private static void rotate1(int[][] matrix) {
		int len = matrix.length;
		int[][] copy = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				copy[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < len; i++) {

			for (int j = 0; j < len; j++) {
				matrix[j][len - i - 1] = copy[i][j];
			}
		}

	}

}
