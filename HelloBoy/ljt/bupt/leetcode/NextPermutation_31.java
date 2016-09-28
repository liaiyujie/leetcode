package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation_31 {

	public static void main(String[] args) {
		int[] nums = {3,1,2};
		nextPermutation1(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	
	//TLE
//一个很笨的实现，先把所有的全排列写出来，存入List中，然后遍历那个等于给定的数组，最后返回下一个
	private static void nextPermutation1(int[] nums) {
		int[] num = new int[nums.length];
		num = Arrays.copyOf(nums, nums.length);
		Arrays.sort(num);
		//产生num的所有全排列
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		boolean[] used = new boolean[num.length];
		backtracking(res,list,used,num);
//		for (List l : res) {
//			System.out.println(l);
//		}
		//res中已经存了所有的全排列
		for(int i = 0 ; i< res.size() ;i++){
			List<Integer> tmp = res.get(i);
			boolean flag = true;
			for(int j = 0 ; j< tmp.size() ;j++){
				if(nums[j]!=tmp.get(j)){
					flag = false;
					break;
				}
			}
			if(flag == true){//在res中找到了第i个列表和nums一样
				/*if(i == res.size()-1){
					for(int j = 0 ; j< tmp.size();j++){
						nums[j] = res.get(0).get(j);
					}
				}else{
					for(int j = 0 ; j< tmp.size();j++){
						nums[j] = res.get(i+1).get(j);
					}
				}*/
				for(int j = 0 ; j< tmp.size();j++){
					nums[j] = res.get((i+1)%res.size()).get(j);
				}
				break;
			}
		}
	}
	
	
	private static void backtracking(List<List<Integer>> res, List<Integer> list,boolean[] used, int[] num) {
		if(list.size() == num.length ){
			List<Integer> tmp = new ArrayList<>(list);
			res.add(tmp);
			return ;
		}
		
		for(int i = 0; i<num.length ;i++){
			if (used[i] || (i > 0 && !used[i - 1] && num[i] == num[i - 1]))
				continue;
			used[i] = true;
			list.add(num[i]);
			backtracking(res, list, used, num);
			list.remove(list.size()-1);
			used[i] = false;
		}
		
	}



	//  发现问题挺难的，目前没想明白怎么写
	private static void nextPermutation(int[] nums) {
		if(nums.length == 1||nums.length == 0){
			return ;
		}else if(nums.length == 2){
			swap(nums,0,1);
			return ;
		}else{//length>2
			for(int i = nums.length-1 ; i>=0 ;i--){
				if(nums[i]>nums[i-1]){
					swap(nums,i,i-1);
					return ;
				}else{
					
				}
			}
		}
			
		
	}
	private static void swap(int[] nums , int i , int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
