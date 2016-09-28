package ljt.bupt.leetcode;

import java.util.Arrays;

public class PlusOne_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 9, 9, 9 };
		int[] re = plusOne(digits);
		System.out.println(Arrays.toString(re));
	}

	private static int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}

}
