package ljt.bupt.leetcode.string;

import java.util.HashMap;

//https://segmentfault.com/a/1190000004455444
public class IntegertoRoman_12 {

	public static void main(String[] args) {

		for(int i = 1 ; i< 105 ; i++){
			String res = intToRoman(i);
			System.out.println(res);
		}

	}

	private static String intToRoman(int n) {
		//需要将I V X L C D M及前一个数字比如4 9 40 90 400 900打表。然后罗马数字将由这些数字组成
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] num = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (n != 0) {
			if (n >= num[i]) {
				sb.append(roman[i]);
				n -= num[i];
			} else
				i++;
		}
		return sb.toString();
	}

}
