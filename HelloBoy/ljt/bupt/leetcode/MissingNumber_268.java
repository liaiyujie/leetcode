package ljt.bupt.leetcode;

import java.util.Arrays;

public class MissingNumber_268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,4,0};
		int res = missingNumber(nums);
		System.out.println(res);
	}

	private static int missingNumber(int[] nums) {//使用等差數列的性質，先假設不缺，算出總和
	        //可能會產生溢出
			int n = nums.length;
	        int sum = n * (n + 1) / 2;
	        for(int num : nums){
	            sum -= num;
	        }
	        return sum;
	}

	private static int missingNumber2(int[] nums) {
		//生成另一个不缺数字的数字，然后两个数字中的数字异或，就能得到唯一的一个数
//		int xor = 0, i = 0;
//		for (i = 0; i < nums.length; i++) {
//			xor = xor ^ i ^ nums[i];
//		}
//
//		return xor ^ i;
		int len = nums.length;
		int[] nums1 = new int[len+1];
		for(int i = 0 ; i < len+1;i++){
			nums1[i] = i;
		}
		int res = nums[0];
		for(int i = 1 ; i < len ;i++){
			res ^= nums[i];
		}
		for(int i = 0 ; i < len+1 ;i++){
			res ^= nums1[i];
		}
		return res;
	}

	private static int missingNumber1(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i]!= i){
				return i;
			}
		}
		return nums.length;
	}

}
