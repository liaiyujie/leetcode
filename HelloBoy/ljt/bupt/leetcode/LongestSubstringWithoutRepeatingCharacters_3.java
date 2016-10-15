package ljt.bupt.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

	public static void main(String[] args) {
		String s = "abcaebddd";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
	
	
//	这道题的关键还是掌握好循环，控制两个指针p,q。p在左，q在右。
//	如果q字符等于p字符的话，则p可以向右挪一个。如果q字符等于p到q之间的一个字符的话则，
//	p和q移动到相同字符右边一个。之前的字符串长度可以进行存档，即与最长长度记录进行比较。
	
//  发现一个重复元素，需要从前面出现该元素的位置后面讲元素都加进去
	private static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0 ;
//		int count = 0;
		for(int i = 0 ; i< s.length() ;i++){
			boolean flag = set.add(s.charAt(i));
			if(!flag){
				int index = 0;
				for(int j = i-1;j>=0;j--){//从i开始向前找，找到第一个和s.charAt(i)相等的下标
					if(s.charAt(j)==s.charAt(i)){
						index = j;
						break;
					}
				}
//				count = set.size();
				max = max > set.size() ? max :set.size();
//				count = 1;
				set.clear();
				for(int j = index+1;j<=i;j++){
					set.add(s.charAt(j));
				}
			}
		}
		max = max > set.size() ? max :set.size();
		return max;
	}

}
