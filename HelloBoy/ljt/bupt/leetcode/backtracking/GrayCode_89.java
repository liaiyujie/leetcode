package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

	public static void main(String[] args) {
		int n = 3;
		List<Integer> res = grayCode(n);
		System.out.println(res);
	}
//	递归生成码表
	private static List<Integer> grayCode(int n) {
		
		
		
		return null;
	}
	
//	异或转换
	private static List<Integer> grayCode1(int n) {
		List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i<1<<n ;i++){
            res.add((i/2)^i);
        }
        return res;
	}

}
