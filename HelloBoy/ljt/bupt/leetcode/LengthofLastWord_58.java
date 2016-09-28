package ljt.bupt.leetcode;

public class LengthofLastWord_58 {

	public static void main(String[] args) {
		String s = "hello world";
		int len = lengthOfLastWord(s);
		System.out.println(len);
	}

	private static int lengthOfLastWord(String s) {
		String s1 = s.trim();
		int x = s1.lastIndexOf(" ");
		if (x == -1)
			return s1.length();
		else
			return s1.substring(x, s1.length() - 1).length();
	}

	private static int lengthOfLastWord1(String s) {
		if ("".equals(s.trim()))
			return 0;
		String[] str = s.split(" ");
		String re = str[str.length - 1];
		return re.length();
	}

}
