package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement_169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 4, 4, 1, 2, 3 };
		int re = majorityElement(nums);
		System.out.println(re);
	}

	private static int majorityElement(int[] num) {
		int major = num[0], count = 1;
		for (int i = 1; i < num.length; i++) {
			if (count == 0) {
				count++;
				major = num[i];
			} else if (major == num[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

	private static int majorityElement1(int[] nums) {
		// TODO Auto-generated method stub
		int len = nums.length;
		int n = 0;
		if (len % 2 == 0)
			n = len / 2;
		else
			n = len / 2 + 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		int res = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= n) {
				res = entry.getKey();
			}
		}
		return res;
	}

}
