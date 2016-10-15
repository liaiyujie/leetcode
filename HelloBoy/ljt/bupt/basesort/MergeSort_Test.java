package ljt.bupt.basesort;

import java.util.Arrays;

public class MergeSort_Test {

	public static void main(String[] args) {
		int[] nums = {4,3,2,1,6,3,7,3,8,23,9,234,78,23,34,21,4,4234,12,321,1,2,32,3,45};
//		int[] nums = {5,6,4,3,7,2,8,9,1,10};
		MergeSort(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

	private static void MergeSort(int[] nums,int left,int right) {
		if(left>=right)
			return ;
		int mid = (left+right)/2;
		MergeSort(nums, left, mid);//归并排序左半部分
		MergeSort(nums, mid+1, right);//归并排序右半部分
		Merge(nums,left,mid,right);//将left~mid  和mid+1~right之间的合并
		
	}

	private static void Merge(int[] nums, int left, int mid, int right) {
		int[] tmp = new int[right-left+1];
		int i = left;//指向左半部分的首位
		int j = mid+1;//指向右半部分的首位
		int size = 0;
//		for( ; (i<=mid)&&(j<=right);size++){
//			if(nums[i]<=nums[j]){
//				tmp[size] = nums[i++];
//			}else{
//				tmp[size] = nums[j++];
//			}
//		}
		while(i<=mid&&j<=right){
			if(nums[i]<=nums[j]){
				tmp[size++] = nums[i++];
			}else{
				tmp[size++] = nums[j++];
			}
		}
		while(i<=mid){
			tmp[size++] = nums[i++];
		}
		while(j<=right){
			tmp[size++] = nums[j++];
		}
		for(int k = 0 ; k<size;k++){
			nums[left+k] = tmp[k];
		}
	}

}
