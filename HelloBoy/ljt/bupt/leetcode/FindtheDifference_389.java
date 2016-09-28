package ljt.bupt.leetcode;

public class FindtheDifference_389 {

	public static void main(String[] args) {
		char s ='a';
		char t = 'b';
//		char c = findTheDifference(s,t);
//		System.out.println(c);
		int c = s ^ t ^ 'a';
		System.out.println(c);

	}

	private static char findTheDifference(String s, String t) {
		char c = 0;
		for (int i = 0; i < s.length(); ++i) {
			c ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); ++i) {
			c ^= t.charAt(i);
		}
		return c;
	}
	

}
