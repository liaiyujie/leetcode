package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {

	public static void main(String[] args) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}

	private static List<String> letterCombinations(String digits) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");
		List<String> res = new ArrayList<>();
		if("".equals(digits)||digits.length()==0){
			return res;
		}
		
		StringBuilder sb = new StringBuilder();
		backtracking(res,sb,map,digits);
		return res;
	}

	private static void backtracking(List<String> res, StringBuilder sb, HashMap<Integer, String> map,String digits) {
		if(digits.length() ==0){
			res.add(sb.toString());
			return ;
		}
		
		Integer cur = Integer.valueOf(digits.substring(0, 1));
		String litter = map.get(cur);
		for(int i = 0 ; i< litter.length() ; i++){
			sb.append(litter.charAt(i));
			backtracking(res, sb, map, digits.substring(1));
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
