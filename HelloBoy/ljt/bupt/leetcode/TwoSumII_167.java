package ljt.bupt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII_167 {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] re = twoSum(nums, target);
		for (int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}

	}

	private static int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		int i = 0, j = len - 1, sum = 0;
		while (i < j) {
			sum = numbers[i] + numbers[j];
			if (sum == target)
				break;
			else if (sum < target)
				i++;
			else
				j--;
		}
		return new int[] { i + 1, j + 1 };
	}

	private static int[] twoSum2(int[] numbers, int target) {
		int beginIndex = 0;
		int endIndex = numbers.length - 1;
		while (numbers[beginIndex] + numbers[endIndex] != target) {
			if (numbers[beginIndex] + numbers[endIndex] > target)
				endIndex = findBinary(beginIndex, endIndex, numbers, target - numbers[beginIndex], true);
			else
				beginIndex = findBinary(beginIndex, endIndex, numbers, target - numbers[endIndex], false);
		}
		return new int[] { beginIndex + 1, endIndex + 1 };

	}

	private static int findBinary(int begin, int end, int[] numbers, int target, boolean orient) {
		int mid = (begin + end) / 2;
		while (target != numbers[mid] && begin < end) {
			if (target > numbers[mid])
				begin = mid + 1;
			else
				end = mid - 1;
			mid = (begin + end) / 2;
		}
		if (orient && numbers[mid] > target)
			return mid - 1;
		else if (!orient && numbers[mid] < target)
			return mid + 1;
		else
			return mid;
	}

	private static int[] twoSum1(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] re = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(target - numbers[i], i + 1);
			} else {
				re[0] = map.get(numbers[i]);
				re[1] = i + 1;
				return re;
			}
		}
		return null;
	}

}
