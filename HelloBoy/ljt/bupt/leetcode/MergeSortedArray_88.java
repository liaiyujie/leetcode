package ljt.bupt.leetcode;

import java.util.Arrays;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int m = 4;
		int n = 6;
		int[] nums1 = new int[m + n];
		int[] nums2 = new int[n];
		nums1[0] = 2;
		nums1[1] = 4;
		nums1[2] = 6;
		nums1[3] = 8;
		nums2[0] = 1;
		nums2[1] = 3;
		nums2[2] = 5;
		nums2[3] = 7;
		nums2[4] = 9;
		nums2[5] = 10;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));

	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0){
			for(int i = 0 ; i < n ; i ++){
				nums1[i] = nums2[i];
			}
			return ;
		}
			
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = index; j < m + n; j++) {
				if (nums2[i] < nums1[j]) {// nums1 中j和j后面的元素后移
					index = j;
					for (int k = m + i; k > j; k--) {
						nums1[k] = nums1[k - 1];
					}
					nums1[j] = nums2[i];
					break;
				}
				if(nums2[i]>=nums1[m+i-1]){//将nums2[i] 和之后的元素都加到nums1后面
					nums1[m+i] = nums2[i];
				}
			}
		}

	}

}
