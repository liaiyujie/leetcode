package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ransomNote = "aa";
		String magazine = "abb";
		boolean re = canConstruct(ransomNote, magazine);
		System.out.println(re);
	}

	private static boolean canConstruct(String ransomNote, String magazine) {
		char[] ran = ransomNote.toCharArray();
		char[] mag = magazine.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < mag.length; i++) {
			if (!map.containsKey(mag[i])) {
				map.put(mag[i], 1);
			} else {
				map.put(mag[i], map.get(mag[i]) + 1);
			}
		}
		for (int i = 0; i < ran.length; i++) {
			if (!map.containsKey(ran[i])) {
				return false;
			} else {
				int val = map.get(ran[i]);
				if (val == 1) {
					map.remove(ran[i]);
				} else {
					val--;
					map.put(ran[i], map.get(ran[i]) - 1);
				}
			}
		}
		return true;
	}
}
