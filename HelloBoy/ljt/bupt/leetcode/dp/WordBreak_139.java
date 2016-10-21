package ljt.bupt.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_139 {

	public static void main(String[] args) {
		String s = "goalspecial";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("go");
		wordDict.add("goal");
		wordDict.add("goals");
		wordDict.add("special");
		boolean res = wordBreak(s,wordDict);
		System.out.println(res);
	}

	//印证了邹博说的那句话，一般方法解决不了的题目，往dp方面想
	//dp[i] = 存在j（dp[j]&&str[j,i-1]属于字典 其中j[0,i-1]）
	private static boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;//空串在字典里    dp[i]表示s.substring(0, i)是否在字典中
		for(int i = 1; i<=s.length();i++){
			for(int j = i-1 ; j>=0;j--){
				if(dp[j]&&wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}


//	"goalspecial"
//	["go","goal","goals",""]
	private static boolean wordBreak1(String s, Set<String> wordDict) {
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
