package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII_216 {

	public static void main(String[] args) {
		int k = 3 ;
		int n = 9 ;
		List<List<Integer>> res = combinationSum(k, n);
		for(List l : res)
			System.out.println(l);
	}

	
//  自己写的回溯，传入的参数较多。
	private static List<List<Integer>> combinationSum(int k, int n) {
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> list = new ArrayList<>();
		
		backtracking(res,list,candidates,n,k,0);
		
		return res;
		
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates,int n, int k, int start) {
		
		if(k == 0){//检索到了三个数字
			if(n == 0){//这三个数字相加刚好等于n
				List<Integer> tmp = new ArrayList<>(list);
				res.add(tmp);
				return ; 
			}else {
				return ;
			}
			
		}
		
		for(int i = start ; i< candidates.length ;i++){
			n -=candidates[i];
			list.add(candidates[i]);
			backtracking(res, list, candidates, n, k-1, i+1);
			n+=candidates[i];
			list.remove(list.size()-1);
		}
	}

}
