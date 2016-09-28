package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElementII_229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,1,2,3,3 };
		List re = majorityElement(nums);
		Iterator<Integer> it = re.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	private static List majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}
	private static List<Integer> majorityElement1(int[] nums) {
		int len = nums.length;
		int n = 0;
		if(len%3==0)
			n = len/3;
		else
			n = len/3+1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= n) {
				res.add(entry.getKey());
			}
		}
		return res;
	}

}
