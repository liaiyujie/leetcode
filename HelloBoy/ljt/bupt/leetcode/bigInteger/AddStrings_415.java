package ljt.bupt.leetcode.bigInteger;

public class AddStrings_415 {

	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "1";
		String res = addStrings(num1, num2);
		System.out.println(res);

	}

	private static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		sb.append(num1);
		num1 = sb.reverse().toString();
		sb.delete(0, sb.length());
		sb.append(num2);
		num2 = sb.reverse().toString();
		sb.delete(0, sb.length());
		int carry = 0;// 进位
		int len1 = num1.length();
		int len2 = num2.length();
		while (len1 > 0 || len2 > 0 || carry != 0) {
			int n1 = len1 <= 0 ? 0 : num1.charAt(num1.length() - len1) - '0';
			int n2 = len2 <= 0 ? 0 : num2.charAt(num2.length() - len2) - '0';
			int sum = n1 + n2 + carry;
			sb.append(sum%10);
			carry = sum /10;
			len1 --;
			len2 --;
		}
		return sb.reverse().toString();
	}

}
