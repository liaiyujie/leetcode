package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberII_137 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 2, 0 };
		int re = singleNumber(nums);
		System.out.println(re);
	}
/*	The usual bit manipulation code is bit hard to get and replicate. 
	I like to think about the number in 32 bits and just count how many 1s are there in each bit, 
	and sum %= 3 will clear it once it reaches 3. After running for all the numbers for each bit, 
	if we have a 1, then that 1 belongs to the single number, 
	we can simply move it back to its spot by doing ans |= sum << i;

	This has complexity of O(32n), which is essentially O(n) and very easy to think and implement. 
	Plus, you get a general solution for any times of occurrence. Say all the numbers have 5 times, 
	just do sum %= 5.*/
	public static int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					sum++;
					sum %= 3;
				}
			}
			if (sum != 0) {
				//ans= ans|(sum << i);
				ans |= sum << i;
			}
		}
		return ans;
	}

	private static int singleNumber1(int[] nums) {// 非常慢的算法，只打败了百分之2，需要用位运算
		// if(nums.length%3==1){
		//
		// }else{//nums.length%3==2
		//
		// }
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				int value = map.get(num);
				value++;
				map.put(num, value);
			} else {
				map.put(num, 1);
			}
		}
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
			if (entry.getValue() == 1 || entry.getValue() == 2) {
				return entry.getKey();
			}
		}
		return 0;
	}

}
