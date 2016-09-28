package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

	public static void main(String[] args) {
		String s = "ab";
		String t = "aa";
		boolean bool = isIsomorphic(s, t);
		System.out.println(bool);
	}

	private static boolean isIsomorphic(String s1, String s2) {
		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();

		for (Integer i = 0; i < s1.length(); i++) {

			if (m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isIsomorphic1(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> map1 = new HashMap<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(chars[i])) {
				char value = map.get(chars[i]);
				if (value != chart[i])
					return false;
			} else {
				map.put(chars[i], chart[i]);
			}
		}
		for (int i = 0; i < len; i++) {
			if (map1.containsKey(chart[i])) {
				char value = map1.get(chart[i]);
				if (value != chars[i])
					return false;
			} else {
				map1.put(chart[i], chars[i]);
			}
		}
		return true;
	}

}
