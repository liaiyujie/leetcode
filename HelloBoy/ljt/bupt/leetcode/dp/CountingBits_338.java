package ljt.bupt.leetcode.dp;

import java.util.Arrays;

public class CountingBits_338 {

	public static void main(String[] args) {
		int num = 20;
		int[] res = countBits(num);
		System.out.println(Arrays.toString(res));
	}

	// First of all,by using the hint of this problem,we can find the conclusion
	// easily that
	// 1 if the number is the power of two,it just has one'1' digit.
	// 2 other numbers' '1' digit are based on (their nearest number of two's
	// power) +(number-its nearest number of two's power).
	//
	// For example, 15 can be the result of 8( nearest number of two's
	// power)+7.We just need to remember its nearest number of power of 2.
	// Then,the problem can solve itself!

	private static int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		int k = 0;
		for (int i = 1; i <= num; i++) {
			if ((i & (i - 1)) == 0) {
				k = i;
				res[i] = 1;
			} else {
				res[i] = res[k] + res[i - k];// 其实res[k] == 1
			}
		}
		return res;
	}

	// 最朴素的解法
	private static int[] countBits1(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i < num + 1; i++) {
			int count = 0;
			String msg = Integer.toBinaryString(i);
			char[] cha = msg.toCharArray();
			for (int j = 0; j < cha.length; j++) {
				if (cha[j] == '1') {
					count++;
				}
			}
			result[i] = count;
		}
		return result;
	}

}
