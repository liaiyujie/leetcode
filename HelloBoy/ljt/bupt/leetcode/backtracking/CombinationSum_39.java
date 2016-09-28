package ljt.bupt.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

	public static void main(String[] args) {
		int[] candidates= {2,3,4,5,6,7,10};
		int target = 9 ;
		List<List<Integer>> res = combinationSum(candidates, target);
		for(List l : res)
			System.out.println(l);
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> list = new ArrayList<>();
		
		backtracking(res,list,candidates,target,0,0);
		
		return res;
		
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates,int target, int sum, int start) {
		
		if(sum == target){
			List<Integer> tmp = new ArrayList<>(list);
			res.add(tmp);
			return ; 
			
		}else if(sum>target){
			return ;
		}else{
			for(int i = start ; i<candidates.length ;i++){
				if(sum+candidates[i]<=target){
					sum+=candidates[i];
					list.add(candidates[i]);
					backtracking(res, list, candidates, target, sum, i);
					sum -=candidates[i];
					list.remove(list.size()-1);
				}
				
			}
			
		}
	}

}
