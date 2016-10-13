package ljt.bupt.leetcode.greedy;

public class JumpGameII_45 {

	public static void main(String[] args) {
		int[] nums = { 3,4,3,2,5,4,3 };
		int res = jump(nums);
		System.out.println(res);
	}

	
//	比较典型的贪心。维护一个区间，区间表示第i步所能到达的索引范围。
//	递推的方法为：每次都遍历一遍当前区间内的所有元素，从一个元素出发的最远可达距离是index+array[index]，
//	那么下一个区间的左端点就是当前区间的右端点+1，下一个区间的右端点就是当前区间的max(index+array[index])，
//	以此类推，直到区间包含了终点，统计当前步数即可。
//	{ 2, 3, 1, 1, 4 }; 第一个区间为{3,1}  第二个区间为{1,4} 到达末尾介绍
	private static int jump(int[] A) {
		if (A.length == 1)
            return 0;
        int max = 0, count = 1, begin = 0, end = A[0];
        while (end < A.length - 1) {
            count++;
            int index = begin;
            for (; index <= end; index++) {
                max = Math.max(max, index + A[index]);
            }
            begin = index;
            end = max;
        }
        return count;
	}




	//dp
//	和Jump Game I的不同在于找到最少的步数。这里有一个很巧妙的思想就是，
//	i和j既然都是从起点开始遍历，每一个点i只要满足j + A[j] >= i，证明有解，
//	就break出来。此时的j一定是满足条件的最小的j，所以dp[i] = dp[j] + 1一定是最优解。
	private static int jump1(int[] A) {
		int n = A.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				if (j + A[j] >= i) {
					dp[i] = dp[j] + 1;
					break;
				}
			}
		}
		return dp[n - 1];
	}

}
