package ljt.bupt.leetcode.greedy;

public class JumpGame_55 {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		boolean res = canJump(nums);
		System.out.println(res);
	}
//  贪心思想，对每一个点，先跳他能跳过去的最远的点，跳不过去的话就少跳一些，如果遇到某个点根本跳不过去，直接返回false
	private static boolean canJump(int[] nums) {
		if(nums.length<2)
			return true;
		int len = nums.length;
		
		return false;
	}

}
