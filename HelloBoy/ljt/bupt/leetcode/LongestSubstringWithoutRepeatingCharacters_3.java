package ljt.bupt.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

	public static void main(String[] args) {
		String s = "abcacbddd";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
	
	
//  发现一个重复元素，需要从前面出现该元素的位置后面讲元素都加进去
	private static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		
		
		
		
		return 0;
	}

}
