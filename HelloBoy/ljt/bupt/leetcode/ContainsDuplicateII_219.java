package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII_219 {

	public static void main(String[] args) {
		int[] nums = new int[300000];
		for(int i = 0; i< 300000 ; i++){
			nums[i] = i;
		}
		long startTime = System.currentTimeMillis();
		int k = 3;
		boolean re = containsNearbyDuplicate(nums,k);
		long endTime = System.currentTimeMillis();
		System.out.println(re);
		System.out.println(endTime- startTime);

	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(nums[i])) {
	            if (i - map.get(nums[i]) <= k) return true;
	        }
	        map.put(nums[i], i);
	    }
	    return false;
	}

}
