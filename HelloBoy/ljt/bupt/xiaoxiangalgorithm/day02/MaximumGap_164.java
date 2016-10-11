package ljt.bupt.xiaoxiangalgorithm.day02;

import java.util.Arrays;

public class MaximumGap_164 {

	public static void main(String[] args) {
		int[] nums = { 6, 3, 1, 2, 8, 3 };
		int res = maximumGap2(nums);
		System.out.println(res);
	}

	// Suppose there are N elements in the array, the min value is min and the
	// max value is max. Then the maximum gap will be no smaller than
	// ceiling[(max - min ) / (N - 1)].
	//
	// Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the
	// array into n-1 buckets, where k-th bucket contains all numbers in [min +
	// (k-1)gap, min + k*gap). Since there are n-2 numbers that are not equal
	// min or max and there are n-1 buckets, at least one of the buckets are
	// empty. We only need to store the largest number and the smallest number
	// in each bucket.
	//
	// After we put all the numbers into the buckets. We can scan the buckets
	// sequentially and get the max gap.
	// 他写的方法里面将第一个桶和最后一个桶都省略了。最小数在省略的第一个桶，最大的数在省略的最后一个桶中
	private static int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		// get the max and min value of the array
		int min = num[0];
		int max = num[0];
		for (int i : num) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		// the minimum possibale gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
		int[] bucketsMIN = new int[num.length - 1]; // store the min value in
													// that bucket
		int[] bucketsMAX = new int[num.length - 1]; // store the max value in
													// that bucket
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		// put numbers into buckets
		for (int i : num) {
			if (i == min || i == max)
				continue;
			int idx = (i - min) / gap; // index of the right position in the
										// buckets
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}
		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < num.length - 1; i++) {
			if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value
													// gap
		return maxGap;
	}
	
	

	// 没写出来，出点问题
	// Try to solve it in linear time/space.
	// 借助桶排序的思想，可以在线性时间解决
	private static int maximumGap2(int[] nums) {
		if (nums.length < 2)
			return 0;

		int len = nums.length;
		Bucket[] bucket = new Bucket[len];
		int nMax = nums[0];
		int nMin = nums[0];
		for (int i = 1; i < len; i++) {
			if (nums[i] > nMax)
				nMax = nums[i];
			if (nums[i] < nMin)
				nMin = nums[i];
		}
		// 依次将数据放入bucket
		int delta = nMax - nMin;
		int nBucket = 0;// 某个数应该在哪个桶中
		for (int i = 0; i < nums.length; i++) {
			nBucket = (nums[i] - nMin) * len / delta;
			if (nBucket >= len) {
				nBucket = len - 1;
			}
			bucket[nBucket].add(nums[i]);
		}

		// 计算有效桶的间隔
		int i = 0;//
		int nGap = delta / len;
		int gap;
		for (int j = 1; j < len; j++) {
			if (bucket[j].getValid() == true) {
				gap = bucket[j].getMin() - bucket[i].getMax();
				if (nGap < gap)
					nGap = gap;
				i = j;
			}
		}
		return nGap;
	}

	// 朴素解法就是先排序，然后计算每一个间隙
	private static int maximumGap1(int[] nums) {
		if (nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int MaxGap = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > MaxGap) {
				MaxGap = nums[i] - nums[i - 1];
			}
		}
		return MaxGap;
	}

}

class Bucket {
	
	private boolean isValid = false;
	private int max = 0 ;
	private int min = 0 ;

	public Bucket() {
		super();
	}

	public Bucket(boolean isValid, int max, int min) {
		super();
		this.isValid = isValid;
		this.max = max;
		this.min = min;
	}

	public boolean getValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void add(int val) {
		if (this.getValid() == false) {
			this.max = val;
			this.min = val;
			this.isValid = true;
		} else {
			if (val > this.max)
				this.max = val;
			if (val < this.min)
				this.min = val;
		}
	}
}
