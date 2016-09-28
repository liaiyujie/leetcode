package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class FindKPairswithSmallestSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { -10, -4, 0, 0, 6 };
		int[] nums2 = { 3, 5, 6, 7, 8, 100 };
		int k = 10;
		long startTime = System.currentTimeMillis();
		List<int[]> list = kSmallestPairs(nums1, nums2, k);

		for (int i = 0; i < list.size(); i++) {
			int[] j = list.get(i);
			System.out.println(j[0] + ";;;" + j[1]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// -1;;;-1
		// -1;;;-1
		// -1;;;-1
		// -1;;;-1
		// -1;;;-1
		// 58870 毫秒
	}

	private static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0) || k <= 0) {
			return result;
		}
		Queue<Sum> heap = new PriorityQueue<>();
		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			int row = i;
			int col = 0;
			int val = nums1[row] + nums2[col];
			heap.offer(new Sum(val, row, col));
		}

		for (int i = 0; i < Math.min(nums1.length * nums2.length, k); i++) {
			Sum sum = heap.poll();
			int row = sum.i;
			int col = sum.j;
			int[] pair = { nums1[row], nums2[col] };
			if (col < nums2.length - 1) {
				int val = nums1[row] + nums2[col + 1];
				heap.offer(new Sum(val, row, col + 1));
			}
			result.add(pair);
		}
		return result;
	}

	private static List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
		List<int[]> list = new ArrayList<int[]>();
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (k >= (len1 * len2)) {
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					list.add(new int[] { nums1[i], nums2[j] });
				}
			}
			return list;
		} else {
			Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					int sum = nums1[i] + nums2[j];
					if (map.containsKey(sum)) {
						int value = map.get(sum);
						map.put(sum, value + 1);
					} else {
						map.put(sum, 1);
					}
				}
			}
			int count = 0;
			Iterator it = map.keySet().iterator();
			laberA: while (it.hasNext()) {
				int key = (int) it.next();
				int value = map.get(key);
				count += value;
				if (count < k) {
					continue;
				} else if (count == k) {
					int keykey = key;
					// 将小于等于keykey的全部打印
					for (int i = 0; i < len1; i++) {
						for (int j = 0; j < len2; j++) {
							int sum = nums1[i] + nums2[j];
							if (sum <= keykey) {
								list.add(new int[] { nums1[i], nums2[j] });
							}
						}
					}
					break laberA;
				} else {
					int keykey = key;
					count = count - value;
					int left = k - count;
					// 接下来将遍历，将小于keykey的key对应的元素全部打印，keykey对应的元素打印left个
					for (int i = 0; i < len1; i++) {
						for (int j = 0; j < len2; j++) {
							int sum = nums1[i] + nums2[j];
							if (sum < keykey) {
								list.add(new int[] { nums1[i], nums2[j] });
							} else if ((sum == keykey) && left != 0) {
								list.add(new int[] { nums1[i], nums2[j] });
								left--;
							}
						}
					}
					break laberA;
				}
			}

		}
		return list;
	}

	private static List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {// Time
																					// Limit
																					// Exceeded
		// TODO Auto-generated method stub
		List<int[]> list = new ArrayList<int[]>();
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (k >= (len1 * len2)) {
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					list.add(new int[] { nums1[i], nums2[j] });
				}
			}
			return list;
		} else {
			Map<Integer, List<int[]>> map = new TreeMap<Integer, List<int[]>>();
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					int sum = nums1[i] + nums2[j];
					List<int[]> list1 = new ArrayList<int[]>();// 超级费时
					if (map.containsKey(sum)) {
						List<int[]> list2 = map.get(sum);
						list1.addAll(list2);
						list1.add(new int[] { nums1[i], nums2[j] });
						map.put(sum, list1);
					} else {
						list1.add(new int[] { nums1[i], nums2[j] });
						map.put(sum, list1);
					}
				}
			}
			int count = 0;
			lableA: while (true) {
				Iterator it = map.keySet().iterator();
				while (it.hasNext()) {
					// it.next()得到的是key，tm.get(key)得到obj
					List<int[]> list2 = map.get(it.next());
					for (int j = 0; j < list2.size(); j++) {
						list.add(list2.get(j));
						count++;
						if (count >= k) {
							break lableA;
						}
					}
				}
			}
		}
		return list;
	}

}

class Sum implements Comparable<Sum> {
	int val;
	int i;
	int j;

	public Sum(int val, int i, int j) {
		this.val = val;
		this.i = i;
		this.j = j;
	}

	public int compareTo(Sum o) {
		return this.val - o.val;
	}
}
