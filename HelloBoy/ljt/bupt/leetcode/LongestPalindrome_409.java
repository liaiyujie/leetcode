package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

	public static void main(String[] args) {
		String s = "aaaAaaaa";
		int res = longestPalindrome(s);
		System.out.println(res);
	}

	private static int longestPalindrome(String s) {
//		s = s.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			// if(map.containsKey(s.charAt(i))){
			// map.put(s.charAt(i), map.get(s.charAt(i)+1));
			// }else{
			// map.put(s.charAt(i), 1);
			// }
		}
		int res = 0;
		int max = 0;// 记录最长的奇数
		boolean hasodd = false;// 是否有奇数个数
		// List<Integer> valueset = map.values();
		for (Integer i : map.values()) {
			if (i % 2 == 0) {
				res += i;
			} else {
				hasodd = true;
				max = max < i ? i : max;
				res += (i - 1);
			}
		}
		if (hasodd)
			return res + 1;
		return res;
	}

}
