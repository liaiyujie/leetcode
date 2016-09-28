package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class TopKFrequentElements_347 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		List<Integer> res = topKFrequent(nums, k);

	}

	private static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (!freqMap.containsKey(freq)) {
				freqMap.put(freq, new LinkedList<>());
			}
			freqMap.get(freq).add(num);
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}

	private static List<Integer> topKFrequent3(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}

	// 该桶排序有一个缺点，就是当元素非常多的时候，桶的大小特别大。改进办法就是算出最大的频率，然后桶的大小就为最大频率
	// Java O(n) Solution - Bucket Sort，Idea is simple. Build a array of list to
	// be buckets with length 1 to sort.
	private static List<Integer> topKFrequent2(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];// 使用List[]
															// 而不用int[]的原因是可能相同频率的会有多个
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			// the value to which the specified key is mapped,
			// or defaultValue if this map contains no mapping for the key
			// PS:1.8新方法
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	// 我写的
	private static List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int value = map.get(nums[i]);
				map.put(nums[i], value + 1);

			}
		}
		Set<Integer> keyset = map.keySet();
		int[] values = new int[keyset.size()];
		int j = 0;
		for (int i : keyset) {
			values[j] = map.get(i);
			j++;
		}
		Arrays.sort(values);
		for (int i = 0; i < k; i++) {
			int val = values[values.length - 1 - i];
			for (int r : keyset) {
				if (map.get(r) == val) {
					list.add(r);
					map.remove(r);
					break;
				}
			}
		}
		return list;
	}

}
