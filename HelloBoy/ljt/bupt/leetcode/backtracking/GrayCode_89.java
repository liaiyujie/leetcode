package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

	public static void main(String[] args) {
		int n = 3;
		ArrayList<Integer> res = grayCode(n);
		System.out.println(res);
	}

	private static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++){
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        ArrayList<Integer> r1 = reverse(result);
        int x = 1 << (n-1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        result.addAll(r1);
        return result;
	}
	
	public static ArrayList<Integer> reverse (ArrayList<Integer> r) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = r.size() - 1; i >= 0; i--) {
            rev.add(r.get(i));
        }
        return rev;
    }
	

	private static List<String> grayCode1(int n) {
		List<String> list = new ArrayList<>();
		if(n<=0)
			return list;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< n;i++){
			sb.append('0');
		}
		list.add(sb.toString());
		
		helper(list,sb.toString());
		
		return list;
	}

	private static void helper(List<String> list, String str) {
		if(!list.contains(str)){
			list.add(str);
			return ;
		}
		
		for(int i = 0 ; i< str.length() ;i++){
			str = chang(str,i);
			helper(list,str);
//			str = chang(str,i);
		}
		
	}

	private static String chang(String str, int i) {
		if(i==str.length()-1){
			if(str.charAt(i)=='1')
				str = str.substring(0,i) + "0";
			if(str.charAt(i)=='0')
				str = str.substring(0,i) + "1";
		}
		String befor = str.substring(0, i);
		String after = str.substring(i+1, str.length());
		if(str.charAt(i)=='0'){
			str = befor + "1" + after;
			return str;
		}
		if(str.charAt(i)=='1'){
			str = befor + "0" + after;
			return str;
		}
		return "";
	}

}
