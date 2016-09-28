package ljt.bupt.leetcode.bfs_dfs;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString_394 {

	public static void main(String[] args) {
		String s = "3[a2[c]]";
		String res = decodeString(s);
		System.out.println(res);
	}

	private static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>();
		int i = 0;
		result.push("");
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				int start = i;
				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
					i++;
				count.push(Integer.parseInt(s.substring(start, i + 1)));
			} else if (ch == '[') {
				result.push("");//这个“”就能解决我之前写不下去的问题，相当于一个分隔符
			} else if (ch == ']') {
				String str = result.pop();
				StringBuilder sb = new StringBuilder();
				int times = count.pop();
				for (int j = 0; j < times; j += 1) {
					sb.append(str);
				}
				result.push(result.pop() + sb.toString());
			} else {
				result.push(result.pop() + ch);
			}
			i += 1;
		}
		return result.pop();
	}

	// 试试能不能使用lastindexof("[") 写一写
	private static String decodeString2(String s) {
		while (s.lastIndexOf("[") != -1) {
			String tmp = "";
			String digit = "";
			int indexC = 0;
			int index = s.lastIndexOf("[");
			for (int i = index + 1; i < s.length(); i++) {
				if (s.charAt(i) != ']') {
					tmp += s.charAt(i);
				} else {
					indexC = i;
					break;
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {// 是数字
					digit += s.charAt(i);
				} else {
					break;
				}
			}
			int time = Integer.valueOf(new StringBuilder().append(digit).reverse().toString());
			String tmpS = "";
			for (int j = 0; j < time; j++) {
				tmpS += tmp;
			}
			s = s.substring(0, index - digit.length()) + tmpS + s.substring(indexC + 1);
		}
		return s;
	}

	private static String decodeString1(String s) {// 按照这个思路下去写感觉有点困难
		LinkedList<Integer> time = new LinkedList<>();
		LinkedList<String> str = new LinkedList<>();
		boolean[] flag = new boolean[s.length()];
		int count = -1;
		String digit = "";
		String eng = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {// 是数字
				digit += s.charAt(i);
			}
			if (s.charAt(i) == '[') {
				time.addFirst(Integer.valueOf(new StringBuilder().append(digit).toString()));// 将上面字符串的12压入栈中
				digit = "";
				if (!"".equals(eng)) {
					str.addFirst(eng);
					eng = "";
				}
				if (s.charAt(i + 1) - 'a' >= 0 && s.charAt(i + 1) - 'a' < 26) {
					count++;
					flag[count] = true;
				}
			}
			if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' < 26) {// 是字母
				eng += s.charAt(i);
			}
			if (s.charAt(i) == ']') {
				str.addFirst(eng);
				eng = str.removeFirst();
				int times = time.removeFirst();
				String tmpS = "";
				for (int j = 0; j < times; j++) {
					tmpS += eng;
				}
				if (true) {

				}
				str.addFirst(tmpS);

			}
		}

		return str.removeFirst();
	}

}
