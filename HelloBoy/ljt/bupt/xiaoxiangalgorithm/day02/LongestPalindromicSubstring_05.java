package ljt.bupt.xiaoxiangalgorithm.day02;

import java.util.Arrays;

public class LongestPalindromicSubstring_05 {
	// https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
	public static void main(String[] args) {
		// String s =
		// "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
		String s = "12212321";
		System.out.println(s.length());
		long st = System.currentTimeMillis();
		String res = longestPalindrome(s);
		long en = System.currentTimeMillis();
		System.out.println(en - st);
		System.out.println(res);
	}

	// Manacher算法，这个算法求最长回文子串的时间复杂度是线性O(N)。
	private static String longestPalindrome(String s) {
		String newStr = getManacherString(s);
		System.out.println(newStr);//$#1#2#2#1#2#3#2#1#
		int len = newStr.length();
		int[] p = new int[len];
		int mx = 0;
		int id = 0;
		int maxLen = 0;
		int maxIndex = 0;
		p[0] = 1;
		for (int i = 1; i < len; i++) {
			if (mx > i) {//被mx的范围抓住了
				p[i] = Math.min(p[2 * id - i], mx - i);
			} else {
				p[i] = 1;
			}
			while (i + p[i] < len && i - p[i] >= 1) {
				if (newStr.charAt(i + p[i]) == newStr.charAt(i - p[i])) {
					p[i]++;
				} else {
					break;
				}
			}
			if (p[i] + i > mx) {
				mx = p[i] + i;
				id = i;
			}
			if (p[i] > maxLen) {
				maxLen = p[i];
				maxIndex = i;
			}
		}
		System.out.println(Arrays.toString(p));
		StringBuilder sb = new StringBuilder();
		for (int i = maxIndex - maxLen + 1; i < maxIndex; i++) {
			if (newStr.charAt(i) != '#') {
				sb.append(newStr.charAt(i));
			}
		}
//		System.out.println(sb.toString());
		String resultStr = sb.toString();
		System.out.println(resultStr);
		if (newStr.charAt(maxIndex) != '#') {
			resultStr += newStr.charAt(maxIndex);
			System.out.println(resultStr);
		}
		resultStr += sb.reverse().toString();
		return resultStr;
	}

	private static String getManacherString(String str) {
		StringBuilder sb = new StringBuilder("$");
		int n = str.length();
		for (int i = 0; i < n; i++) {
			sb.append("#").append(str.charAt(i));
		}
		sb.append("#");
		return sb.toString();
	}

	// 将生成tmp的代码提出来之后AC，避免生成过多的tmp 137ms
	// 稍微优化一点的朴素解法，但是还是超时
	// 分析与解法
	// 最容易想到的办法是枚举所有的子串，分别判断其是否为回文。这个思路初看起来是正确的，
	// 但却做了很多无用功，如果一个长的子串包含另一个短一些的子串，那么对子串的回文判断其实是不需要的。

	// 解法一
	// 那么如何高效的进行判断呢？我们想想，如果一段字符串是回文，那么以某个字符为中心的前缀和后缀都是相同的，
	// 例如以一段回文串“aba”为例，以b为中心，它的前缀和后缀都是相同的，都是a。
	// 那么，我们是否可以可以枚举中心位置，然后再在该位置上用扩展法，记录并更新得到的最长的回文长度呢？
	private static String longestPalindrome1(String s) {
		if (s.length() == 0 || s == null)
			return "";
		String res = "";
		for (int i = 0; i < s.length(); i++) {// i is the middle point of the
												// palindrome
			// if the length of the palindrome is odd
			String tmp = "";
			int k = 0;
			boolean flag = false;
			for (int j = 0; (i - j >= 0) && (i + j < s.length()); j++) {
				if (s.charAt(i - j) != s.charAt(i + j)) {
					break;
				} else {
					flag = true;
					k = j;
					// tmp = s.substring(i - k, i + k + 1);
				}
			}
			if (flag)
				tmp = s.substring(i - k, i + k + 1);
			if (tmp.length() > res.length())
				res = tmp;

			k = 0;
			tmp = "";
			flag = false;
			// for the even case
			for (int j = 0; (i - j >= 0) && (i + j + 1 < s.length()); j++) {
				if (s.charAt(i - j) != s.charAt(i + j + 1)) {
					break;
				} else {
					flag = true;
					k = j;
					// tmp = s.substring(i - k, i + k + 2);
				}
			}
			if (flag)
				tmp = s.substring(i - k, i + k + 2);
			if (tmp.length() > res.length())
				res = tmp;
		}
		System.out.println(res.length());
		return res;
	}

}
