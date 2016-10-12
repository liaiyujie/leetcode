package ljt.bupt.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdditiveEquations_bfs {
	// Sample Input
	// 3
	// 3 1 2 3
	// 3 1 2 5
	// 6 1 2 3 5 4 6
	// Output for the Sample Input

	// 1+2=3

	// Can't find any equations.

	// 1+2=3
	// 1+3=4
	// 1+4=5
	// 1+5=6
	// 2+3=5
	// 2+4=6
	// 1+2+3=6
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		while (sum-- > 0) {
			int count = in.nextInt();
			if (count < 3) {
				System.out.println("Can't find any equations.");
				continue;
			}
			int[] nums = new int[count];
			for (int i = 0; i < count; i++) {
				nums[i] = in.nextInt();
			}

			Arrays.sort(nums);
			
			boolean[] used = new boolean[count];
//			List<List<Integer>> list = new ArrayList<>();
			// 先尝试2数相加，然后3数相加，最后count-1数相加
			int C = 0;
			for (int depth = 2; depth < count; depth++) {
				List<List<Integer>> list = new ArrayList<>();
				DFS(list,nums,used,depth,0);
//				for(List l:list)
//					System.out.println(l);
				if(list.size()==0){
					C++;
					continue;
				}else{
					for(int i = 0 ; i < list.size() ;i++){
						List l = list.get(i);
						for(int j = 0 ; j< l.size()-2 ;j++){
							System.out.print(l.get(j) + "+");
						}
						System.out.println(l.get(l.size()-2) + "=" + l.get(l.size()-1));
					}
				}
				
			}
			if(C==count-2){
				System.out.println("Can't find any equations.");
				continue;
			}
		}

	}

	private static void DFS(List<List<Integer>> list, int[] nums, boolean[] used, int depth, int start) {
		if(depth == 0){
			int sum = 0 ;
			for(int i = 0 ; i< used.length ;i++){
				if(used[i])
					sum+=nums[i];
			}
			for(int i = 0 ; i< used.length ;i++){
				if(nums[i]== sum){
					List<Integer> tmp = new ArrayList<>();
					for(int j = 0 ;j< used.length ;j++){
						if(used[j])
							tmp.add(nums[j]);
					}
					tmp.add(nums[i]);
					list.add(tmp);
					return ;
				}
			}
			return ;
		}
		
		for(int i = start ; i< nums.length ;i++){
			int sum = 0;
			for(int j = 0 ; j<nums.length ; j++){
				if(used[j]){
					sum +=nums[j];
				}
			}
			if(sum >nums[nums.length-1])
				return ;
			used[i] = true;
			DFS(list, nums, used, depth-1, i+1);
			used[i] = false;
		}
		
	}

}
