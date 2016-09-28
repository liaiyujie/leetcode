package ljt.bupt.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

	public static void main(String[] args) {

		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		l1.add(-1);
		l2.add(2);
		l2.add(3);
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		int res = minimumTotal(triangle);
		System.out.println(res);
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		int depth = triangle.size();
		int[] dp = new int[depth];
		for(int i = 0; i < depth ;i++)
			dp[i] = Integer.MAX_VALUE;
		if(depth == 0)
			return 0;
		int sum = 0;
		sum = triangle.get(0).get(0);
		dp[0] = sum;
		for(int i = 1; i < triangle.size() ;i++){
			
			for(int j = triangle.get(i).size()-1; j>=0;j--){
				if(j!=0){
					dp[j] = Math.min(dp[j], dp[j-1])+ triangle.get(i).get(j);
				}else{
					dp[j] = dp[0]+triangle.get(i).get(j);
				}
			}
		}
		Arrays.sort(dp);
		return dp[0];
	}
//  下面方法是用贪心写的，不能得到全局最优解
//	-1
//	2 3
//	1 -1 -3
	private static int minimumTotal1(List<List<Integer>> triangle) {
		int depth = triangle.size();
		int[] dp = new int[depth];
		int sum = 0;
		if(depth == 0)
			return sum;
		sum = triangle.get(0).get(0);
		dp[0] = 0;
		for(int i = 1 ; i< depth ;i++){
			int tmp = dp[i-1];
//			Math.max(triangle.get(i).get(tmp),triangle.get(i).get(tmp+1));
			int v1 = triangle.get(i).get(tmp);
			int v2 = triangle.get(i).get(tmp+1);
			if(v1<v2){
				dp[i] = tmp;
				sum+=v1;
			}else{
				dp[i] = tmp+1;
				sum+=v2;
			}
		}
		return sum;
	}

}
