package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacterinaString_387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		int re = firstUniqChar(s);
		System.out.println(re);
	}

	private static int firstUniqChar(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	private static int firstUniqChar1(String s) {
		char[] ss = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < ss.length; i++) {
			if (map.containsKey(ss[i])) {
				map.put(ss[i], map.get(ss[i]) + 1);
			} else {
				map.put(ss[i], 1);
			}
		}
		// for(Entry entry:map.entrySet()){
		// System.out.println(entry.getKey() +":"+ entry.getValue());
		// }
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == Integer.valueOf(1)) {
				list.add(entry.getKey());
			}
		}
		if (list.isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < ss.length; i++) {
				if (list.contains(ss[i]))
					return i;
			}
		}

		return -1;
	}

}
