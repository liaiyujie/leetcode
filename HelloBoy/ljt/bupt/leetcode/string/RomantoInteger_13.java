package ljt.bupt.leetcode.string;

import java.util.HashMap;

//https://segmentfault.com/a/1190000002683379
public class RomantoInteger_13 {

	public static void main(String[] args) {

		int res = romanToInt("III");
		System.out.println(res);

	}

	private static int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += map.get(s.charAt(i));
			if (i > 0 && map.get(s.charAt(i - 1)) < map.get(s.charAt(i)))
				res -= 2 * map.get(s.charAt(i - 1));
		}
		return res;
	}

	public static int romanToInt1(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int value = map.get(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
				value = value + map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));// IV
																					// =
																					// 1
																					// +
																					// 5
																					// -2
			} else {
				value = value + map.get(s.charAt(i));
			}
		}
		return value;
	}

}
