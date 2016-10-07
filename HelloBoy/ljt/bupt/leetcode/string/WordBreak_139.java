package ljt.bupt.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_139 {

	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("aaaa");
		wordDict.add("aaa");
		boolean res = wordBreak(s,wordDict);
		System.out.println(res);
	}

	
//	"aaaaaaa"
//	["aaaa","aaa"]   这个测试样例让我很蛋疼
	
//	"goalspecial"
//	["go","goal","goals","special"]
	private static boolean wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length() ==0)
			return false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< s.length() ;i++){
			sb.append(s.charAt(i));
			if(wordDict.contains(sb.toString())){
				if(wordDict.contains(s.substring(i+1))){
					return true;
				}
				if(i == s.length() -1){
					return true;
				}
				sb.delete(0, sb.length());
			}
		}
		return false;
	}

}
