package ljt.bupt.leetcode.bigInteger;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiplyStrings_43 {

	public static void main(String[] args) {
		// String num1 =
		// "67671277416626746657687631784163120468201083678333022807";
		// String num2 =
		// "7513826174917015375128752933843614929738429142691134209414990271995868820936126459879940531569978476559542476";
		String num1 = "0";
		String num2 = "456";
		String res = multiply(num1, num2);
		BigInteger b1 = new BigInteger(num1);
		BigInteger b2 = new BigInteger(num2);
		b1 = b1.multiply(b2);
		System.out.println(b1.toString());
		System.out.println(res.equals(b1.toString()));
		System.out.println(res);
	}

	// 相乘和进位分开进行
	private static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null)
			return null;
		int len1 = num1.length();
		int len2 = num2.length();
		// 结果的位数最多可能是两个乘数位数之和
		int len3 = len1 + len2;
		int[] res = new int[len3];
		StringBuilder sb1 = new StringBuilder(num1);
		StringBuilder sb2 = new StringBuilder(num2);
		String nums1 = sb1.reverse().toString();
		String nums2 = sb2.reverse().toString();

		// 每一位都得到了这位该有的值，接下来就剩下进位
		for (int i = 0; i < len1; i++) {
			int a = nums1.charAt(i) - '0';
			for (int j = 0; j < len2; j++) {
				int b = nums2.charAt(j) - '0';
				res[i + j] += a * b;
			}
		}
		// 进位
		int carry = 0;
		for (int i = 0; i < len3; i++) {
			int tmp = res[i];
			res[i] = (tmp + carry) % 10;
			carry = (tmp + carry) / 10;
		}

		// System.out.println(Arrays.toString(res));
		int index = 0;
		for (int i = res.length - 1; i > 0; i--) {
			if (res[i] != 0) {
				index = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= index; i++) {
			sb.append(res[i]);
		}
		return sb.reverse().toString();
	}

	// 这个是相乘和进位一起进行
	private static String multiply2(String num1, String num2) {
		if (num1 == null || num2 == null)
			return null;
		int len1 = num1.length(), len2 = num2.length();
		// 结果的位数最多可能是两个乘数位数之和
		int len3 = len1 + len2;
		int[] res = new int[len3];
		int carry = 0, i = 0, j = 0;
		for (i = len1 - 1; i >= 0; i--) {
			// 先置carry位为0
			carry = 0;
			for (j = len2 - 1; j >= 0; j--) {
				// 每一位的乘积，等于之前这一位的结果，加上carry，再加上这一位和乘数的乘积
				int product = carry + res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				res[i + j + 1] = product % 10;
				carry = product / 10;
			}
			// 把最后的carry位加上
			res[i + j + 1] = carry;
		}
		StringBuilder resstr = new StringBuilder();
		i = 0;
		// 跳过前面无用的0
		while (i < len3 - 1 && res[i] == 0) {
			i++;
		}
		for (; i < len3; i++) {
			resstr.append(res[i]);
		}
		return resstr.toString();
	}

	static StringBuilder ssb = new StringBuilder();

	// 我的这个模拟手算乘法的思路不管怎么优化字符串拼接，还是减少创建sb对象的个数，都会超时。需要更改其他算法
	private static String multiply1(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";
		String sum = "";
		for (int i = num2.length() - 1; i >= 0; i--) {

			int num2T = num2.charAt(i) - '0';

			for (int j = num1.length() - 1; j >= 0; j--) {
				int num1T = num1.charAt(j) - '0';
				// sum += num2T*num1T*Math.pow(10, num1.length()-j-1); 会溢出
				int tp = num2T * num1T;
				if (ssb.length() > 0)
					ssb.delete(0, ssb.length());
				ssb.append(tp);
				// String tmp = tp + "";
				// 往tmp后面加num1.length()-j-1 个 0
				for (int k = 0; k < num1.length() + num2.length() - i - j - 2; k++) {
					// tmp += "0";
					ssb.append('0');
				}
				// //往tmp后面加num2.length()-i-1 个 0 直接写在上面的循环中
				// for (int k = 0; k < num2.length() - i - 1; k++) {
				// tmp += "0";
				// }
				sum = addString(sum, ssb.toString());
			}
		}

		return sum;
	}

	static StringBuilder sbb = new StringBuilder();

	private static String addString(String num1, String num2) {
		// StringBuilder sb1 = new StringBuilder(num1);
		// StringBuilder sb2 = new StringBuilder(num2);
		// String nums1 = sb1.reverse().toString();
		// String nums2 = sb2.reverse().toString();
		String nums1 = sbb.append(num1).reverse().toString();
		if (sbb.length() > 0)
			sbb.delete(0, sbb.length());
		String nums2 = sbb.append(num2).reverse().toString();
		if (sbb.length() > 0)
			sbb.delete(0, sbb.length());
		int len1 = nums1.length();
		int len2 = nums2.length();
		if (len1 < len2) {
			for (int i = 0; i < len2 - len1; i++) {
				nums1 += "0";
			}
		}
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++) {
				nums2 += "0";
			}
		}
		int len = nums1.length();
		// 目前为止，两个字符串已经一样长了
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int n1 = nums1.charAt(i) - '0';
			int n2 = nums2.charAt(i) - '0';
			int sum = n1 + n2 + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}
		if (carry == 1)
			sb.append("1");
		return sb.reverse().toString();
	}

}
