package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {

	public static void main(String[] args) {
		int[] candidates= {1,2,3,4,5,6,7,8,9};
		int target = 9 ;
		List<List<Integer>> res = combinationSum(candidates, target);
		for(List l : res)
			System.out.println(l);
	}

	private static List<List<Integer>> combinationSum(int[] cand, int target) {
		Arrays.sort(cand);
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    List<Integer> path = new ArrayList<Integer>();
	    dfs_com(cand, 0, target, path, res);
	    return res;
	}
	
	private static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
	    if (target == 0) {
	        res.add(new ArrayList(path));
	        return ;
	    }
	    if (target < 0) return;
	    for (int i = cur; i < cand.length; i++){
	        if (i > cur && cand[i] == cand[i-1]) continue;
	        path.add(path.size(), cand[i]);
	        dfs_com(cand, i+1, target - cand[i], path, res);
	        path.remove(path.size()-1);
	    }
	}
	
	
//  自己写的回溯，传入的参数较多。
	private static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		Arrays.sort(candidates);
		
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> list = new ArrayList<>();
		boolean[] used = new boolean[candidates.length];
		
		backtracking(res,list,candidates,used,target,0,0);
		
		return res;
		
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates,boolean[] used,int target, int sum, int start) {
		
		if(sum == target){
			List<Integer> tmp = new ArrayList<>(list);
			res.add(tmp);
			return ; 
			
		}else if(sum>target){
			return ;
		}else{
			for(int i = start ; i<candidates.length ;i++){
				if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false)
					continue;
				if(sum+candidates[i]<=target){
					used[i] = true;
					sum+=candidates[i];
					list.add(candidates[i]);
					backtracking(res, list, candidates,used, target, sum, i+1);
					sum -=candidates[i];
					list.remove(list.size()-1);
					used[i] = false;
				}
				
			}
			
		}
	}

}
