package ljt.bupt.leetcode;

public class ProductofArrayExceptSelf_238 {

	public static void main(String[] args) {
		int[] nums = { 1, 0 };
		int[] re = productExceptSelf(nums);
		for (int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] re = new int[nums.length];
		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			re[i] = left[i] * right[i];
		}
		return re;
	}

	private static int[] productExceptSelf2(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < result.length; i++)
			result[i] = 1;
		int left = 1, right = 1;
		for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
			left *= nums[i];
			right *= nums[j];
			result[i + 1] *= left;
			result[j - 1] *= right;
		}
		return result;
	}

	private static int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}

}
