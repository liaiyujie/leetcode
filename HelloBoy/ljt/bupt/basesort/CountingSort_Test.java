package ljt.bupt.basesort;

import java.util.Arrays;

public class CountingSort_Test {

	public static void main(String[] args) {
		
		int[] nums = {4,3,2,66,6,3,7,3,8,23,9,234,78,23,34,21,4,423,12,321,1,2,32,3,45};
//		int[] nums = {5,6,4,3,3,4,5,6,7,19,7,2,2,2,8,9,1,10};
		CountingSort1(nums);
		System.out.println(Arrays.toString(nums));

	}
//计数排序适用于数组中的数据比较集中的情况，即max - min不会相差太大
//1、计数排序思想，  先求出数组中的最大值和最小值，然后依次映射为0~某个数。创建一个数组大小为差值。
//2、遍历原数组，记录每一个出现的次数，即依次hash。
//3、对得到的数组前n项依次求和，得到新数组
//4、对新数组进行操作即可
// 其实进行到1,2两部已经可以得到答案。进行3,4是为了保证排序算法的稳定性
//  该排序算法的时间复杂度为o(n)  空间复杂度为o(n)
	private static void CountingSort1(int[] nums) {
		if(nums.length==0||nums==null||nums.length==1){
			return ;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//1
		for(int i = 0 ; i < nums.length ;i++){
			if(max<nums[i]){
				max = nums[i];
			}
			if(min>nums[i]){
				min = nums[i];
			}
		}
		
		int gsp = max - min;
		if(gsp==0)
			return ;
		//2 统计数组nums中，值为i的个数
		int[] tmp = new int[gsp+1];
		for(int i = 0 ; i< nums.length ;i++){
			tmp[nums[i]-min] ++;
		}
		
		//3 统计数组nums中，值小于等于i的个数
		int[] sum = new int[gsp+1];
		sum[0] = tmp[0];
		for(int i = 1 ; i<= gsp;i++){
			sum[i] = sum[i-1] + tmp[i] ;
		}
		
		//4
		int[] res = new int[nums.length];
		res = Arrays.copyOf(nums, nums.length);//为了操作方便不覆盖原数组中的值，申请了一个新的数组
		 for(int i = res.length-1;i>=0;i--){
			 int c = res[i]-min;//将原数组中的值减去min映射为sum数组中的值
			 nums[sum[c]-1] = c+min;//更新原数组中的值
			 sum[c]--;
		 }
	}

}
