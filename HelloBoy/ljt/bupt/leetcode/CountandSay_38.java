package ljt.bupt.leetcode;

public class CountandSay_38 {

	public static void main(String[] args) {
		String re = countAndSay(11);
		System.out.println(re);
	}

	private static String countAndSay(int n) {
		if (n <= 0)
			return "";
		String init = "1";
		while (n-- > 1) {
			init = say(init);
		}
		return init;
	}

	private static String say(String str) {
		if (str.length() < 1)
			return "";
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char c = str.charAt(0);
		if (str.length() == 1) {
			sb.append(count);
			sb.append(c);
			return sb.toString();
		}
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				sb.append(count);
				sb.append(c);
				count = 1;
				c = str.charAt(i);
			}
		}
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}

}
