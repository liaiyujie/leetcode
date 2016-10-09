package ljt.bupt.leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
//https://segmentfault.com/a/1190000002673098
//https://segmentfault.com/a/1190000000613436
//https://segmentfault.com/a/1190000003498304
public class LargestRectangleinHistogram_84 {

	public static void main(String[] args) {
		int[] heights = new int[20];
		Random random = new Random();
		for(int i = 0 ; i< 20 ; i++){
			heights[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(heights));
		int res1 = largestRectangleArea(heights);
		int res2 = largestRectangleArea1(heights);
		System.out.println(res1 == res2);
	}

	//stack的应用
	private static int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0, largestArea = 0;
		while (index < height.length) {
			if (stack.isEmpty() || height[stack.peek()] < height[index]) {
				stack.push(index++);
			} else {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? index : index - stack.peek() - 1;
				largestArea = Math.max(largestArea, h * w);
			}
		}
		while (!stack.isEmpty()) {
			int h = height[stack.pop()];
			int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
			largestArea = Math.max(largestArea, h * w);
		}
		return largestArea;
	}

	// 朴素解法，三万个1 Runtime: 305 ms 超时
	private static int largestRectangleArea1(int[] heights) {
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			// 找到以这个heights[i]是为高，它的宽最大能为多少
			int width = helper(heights, i);
			max = max > width * heights[i] ? max : width * heights[i];
		}
		return max;
	}

	private static int helper(int[] heights, int i) {
		int count = 1;
		int tmp = i;
		int c = heights[i];
		// 先往左找
		while (i > 0) {

			if (heights[i - 1] >= c) {
				count++;
			} else {
				break;
			}
			i--;
		}
		// 先往右找
		while (tmp < heights.length - 1) {
			if (heights[tmp + 1] >= c) {
				count++;
			} else {
				break;
			}
			tmp++;
		}
		return count;
	}

}
