package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class IsSubsequence_392 {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		boolean res = isSubsequence(s, t);
		System.out.println(res);

	}

	private static boolean isSubsequence(String s, String t) {
		if (t.length() < s.length())
			return false;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			prev = t.indexOf(tempChar, prev);
			if (prev == -1)
				return false;
			prev++;
		}
		return true;
	}

	// Java binary search for the followup question
	private static boolean isSubsequence2(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		if (s.equals(""))
			return true;
		if (s.length() > t.length())
			return false;

		ArrayList<Integer>[] indexes = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			indexes[i] = new ArrayList<Integer>();
		}
		// 26个链表，第一个链表记录t字符串中a字符出现的位置……
		for (int i = 0; i < t.length(); i++) {
			indexes[t.charAt(i) - 'a'].add(i);
		}
		int lastIndexJ = -1;
		for (int i = 0; i < s.length(); i++) {
			ArrayList<Integer> indexList = indexes[s.charAt(i) - 'a'];

			if (indexList.size() == 0) { // no such character in T
				return false;
			}
			int index = Collections.binarySearch(indexList, lastIndexJ + 1);
			if (index < 0) {
				index = -1 - index;
			}
			// the insertion point is at the end of indexList, hence doesn't
			// exist in indexList
			if (index == indexList.size()) {
				return false;
			}
			lastIndexJ = indexList.get(index);
		}
		return true;
	}

	// 先用暴力搜索方法
	private static boolean isSubsequence1(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int slen = s.length();
		int tlen = t.length();
		boolean[] bool = new boolean[slen];
		int cur = -1;
		for (int i = 0; i < slen; i++) {
			for (int j = cur + 1; j < tlen; j++) {
				if (tt[j] == ss[i]) {
					cur = j;
					bool[i] = true;
					break;
				}
			}
		}
		boolean res = true;
		for (int i = 0; i < slen; i++) {
			res = res && bool[i];
		}
		return res;
	}
}
