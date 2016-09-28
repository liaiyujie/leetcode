package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams_49 {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// String[] strs = {""};
		List<List<String>> list = groupAnagrams(strs);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			List<String> list1 = (List<String>) it.next();
			for (String s : list1) {
				System.out.println(s);
			}
		}
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };// 最多10609个z

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}

	private static List<List<String>> groupAnagrams1(String[] strs) {
		Map<String, List<String>> map = new HashMap();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];// value
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String ss = new String(c);// key
			if (map.containsKey(ss)) {
				List<String> list = map.get(ss);
				list.add(s);
			} else {
				List<String> list = new ArrayList();
				list.add(s);
				map.put(ss, list);
			}
		}
		List<List<String>> list = new ArrayList();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<String>> entry = (Map.Entry) it.next();
			list.add(entry.getValue());
		}
		return list;
	}

}
