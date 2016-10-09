package ljt.bupt.leetcode.divideandconquer;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray_215 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int result = findKthLargest(nums, k);
		System.out.println(result);
	}

	private static int findKthLargest(int[] nums, int k) {
		  shuffle(nums);
	        k = nums.length - k;
	        int lo = 0;
	        int hi = nums.length - 1;
	        while (lo < hi) {
	            final int j = partition(nums, lo, hi);
	            if(j < k) {
	                lo = j + 1;
	            } else if (j > k) {
	                hi = j - 1;
	            } else {
	                break;
	            }
	        }
	        return nums[k];
	}
	private static void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

//    O(N) best case / O(N^2) worst case running time + O(1) memory
//The smart approach for this problem is to use the selection algorithm 
//(based on the partion method - the same one as used in quicksort).
	public static int findKthLargest3(int[] nums, int k) {

		k = nums.length - k;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			final int j = partition(nums, lo, hi);
			if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private static int partition(int[] a, int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		while (true) {
			while (i < hi && less(a[++i], a[lo]));
			while (j > lo && less(a[lo], a[--j]));
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private static void exch(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static boolean less(int v, int w) {
		return v < w;
	}

	private static int findKthLargest2(int[] nums, int k) {
		// final PriorityQueue<Integer> pq = new PriorityQueue<>();
		// for(int val : nums) {
		// pq.offer(val);
		//
		// if(pq.size() > k) {
		// pq.poll();
		// }
		// }
		// return pq.peek();

		// Queue<Integer> queue = new PriorityQueue<Integer>(nums.length,new
		// Comparator<Integer>() {
		// @Override
		// public int compare(Integer a0, Integer a1) {
		// if(a0 < a1)
		// return 1;
		// else if(a0 == a1)
		// return 0;
		// else
		// return -1;
		// return a1-a0;
		// }
		// });
		// PriorityQueue<Integer> queue = new
		// PriorityQueue<>(nums.length,Collections.);
		PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
		}
		for (int i = 0; i < k - 1; i++) {
			queue.poll();
		}
		int result = queue.peek();
		return result;
	}

	private static int findKthLargest1(int[] nums, int k) {
		Arrays.sort(nums);
		int result = nums[nums.length - k];
		return result;
	}

}
