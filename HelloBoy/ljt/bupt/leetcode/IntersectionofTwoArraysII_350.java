package ljt.bupt.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionofTwoArraysII_350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] res = intersect(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new LinkedList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		//下面将list转化为array
		int[] result = new int[list.size()];
		int k = 0;
		for (Integer num : list) {
			result[k++] = num;
		}
		return result;
	}

}
