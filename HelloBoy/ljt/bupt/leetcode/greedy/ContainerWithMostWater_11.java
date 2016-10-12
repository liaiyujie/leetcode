package ljt.bupt.leetcode.greedy;

public class ContainerWithMostWater_11 {

	public static void main(String[] args) {
		int[] height = { 2, 3, 1, 4 };
		int res = maxArea(height);
		System.out.println(res);
	}

	// 增加 26 27 33 这三行代码，AC 9ms
	// Your answer 超时，这个算法每一个值需要计算不需要计算的都算了，耗时，如果能省略跳过那些明显不需要计算的数，能AC
	// 97658256
	// Expected answer
	// 97658256
	// Runtime: 212 ms

	// two pionts
	// 解法有点贪心的味道，从前往后遍历，找每一个以该值为一个短板（长板）所能得到的最大容量
	// 对每一个值，从后往前搜索，计算每一个容量，选最大值
	private static int maxArea(int[] height) {
		if (height.length < 2)
			return 0;
		int maxContain = 0;
		for (int i = 0; i < height.length - 1; i++) {// 从第一个竖线开始遍历，到倒数第二个竖线结束
			int curVal = height[i];
			if (i > 0 && height[i] <= height[i - 1])// 这个就是减少不必要的计算
				continue;
			for (int j = height.length - 1; j > i; j--) {
				// 计算每一个值
				int lastVal = height[j];
				if (curVal <= lastVal) {
					maxContain = maxContain < curVal * (j - i) ? curVal * (j - i) : maxContain;
					break;// 找到一个，这个必然为最大值，所以直接break
				} else {
					maxContain = maxContain < lastVal * (j - i) ? lastVal * (j - i) : maxContain;
				}
			}
		}
		return maxContain;
	}

}
