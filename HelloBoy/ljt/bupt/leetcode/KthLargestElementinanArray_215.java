package ljt.bupt.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray_215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		int result = findKthLargest(nums , k);
		System.out.println(result);
	}

	private static int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<Integer>(nums.length,new Comparator<Integer>() {

			@Override
			public int compare(Integer a0, Integer a1) {
//				if(a0 < a1)
//					return 1;
//				else if(a0 == a1)
//					return 0;
//				else
//					return -1;
				return a1-a0;
			}
		});
		for(int i = 0; i< nums.length ; i++){
			queue.add(nums[i]);
		}
		for(int i = 0 ; i< k-1 ; i++){
			queue.poll();
		}
		int result = queue.peek();
		return result;
	}

	private static int findKthLargest1(int[] nums, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int result = nums[nums.length-k];
		return result;
	}

}
