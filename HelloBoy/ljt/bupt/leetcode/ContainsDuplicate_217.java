package ljt.bupt.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[300000];
		for(int i = 0; i< 300000 ; i++){
			nums[i] = i;
		}
		long startTime = System.currentTimeMillis();
		boolean re = containsDuplicate(nums);
		long endTime = System.currentTimeMillis();
		System.out.println(re);
		System.out.println(endTime- startTime);
		
	}

	private static boolean containsDuplicate(int[] nums) {
		final Set<Integer> distinct = new HashSet<Integer>();
	    for(int num : nums) {
	        if(distinct.contains(num)) {
	            return true;
	        }
	        distinct.add(num);
	    }
	    return false;
	}

	private static boolean containsDuplicate1(int[] nums) {//超时，效率低
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i< nums.length ;i++){
			set.add(nums[i]);
		}
		if(set.size() == nums.length)
			return false;
		return true;
	}

}
