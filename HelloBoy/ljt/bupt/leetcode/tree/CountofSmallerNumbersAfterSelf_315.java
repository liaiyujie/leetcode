package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {

	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
//		int res = count(nums);
		List<Integer> res2 = countSmaller(nums);
//		System.out.println(res);
		System.out.println(res2);
	}

//	The basic idea is to do merge sort to nums[]. To record the result, 
//	we need to keep the index of each number in the original array. 
//	So instead of sort the number in nums, we sort the indexes of each number.
//	Example: nums = [5,2,6,1], indexes = [0,1,2,3]
//	After sort: indexes = [3,1,0,2]
//	While doing the merge part, say that we are merging left[] and right[], 
//	left[] and right[] are already sorted.
//	We keep a rightcount to record how many numbers from right[] we have added 
//	and keep an array count[] to record the result.
//	When we move a number from right[] into the new sorted array, 
//	we increase rightcount by 1.
//	When we move a number from left[] into the new sorted array, 
//	we increase count[ index of the number ] by rightcount.
	
	static int[] count;
	
	private static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();     

	    count = new int[nums.length];
	    int[] index = new int[nums.length];
	    for(int i = 0; i < nums.length; i++){
	    	index[i] = i;
	    }
	    mergesort(nums, index, 0, nums.length - 1);
	    for(int i = 0; i < count.length; i++){
	    	res.add(count[i]);
	    }
	    return res;
	}
	
	private static void mergesort(int[] nums, int[] index, int start, int end){
		if(end <= start){
			return;
		}
		int mid = (start + end) / 2;
		mergesort(nums, index, start, mid);
		mergesort(nums, index, mid + 1, end);
		
		merge(nums, index, start,mid, end);
	}
	private static void merge(int[] nums, int[] index, int start, int mid,int end){
		int i = start;
		int j = mid+1;
		int rightcount = 0;    	//这个是比较关键的变量
		int[] tmp = new int[end - start + 1];

		int size = 0;
		while(i <= mid && j <= end){
			if(nums[index[j]] < nums[index[i]]){// 这是一个逆序对
				tmp[size] = index[j];
				rightcount++;// 这是一个逆序对，所以这里加1
				j++;
			}else{
				tmp[size] = index[i];
				count[index[i]] += rightcount;
				i++;
			}
			size++;
		}
		while(i <= mid){
			tmp[size] = index[i];
			count[index[i]] += rightcount;
			i++;
			size++;
		}
		while(j <= end){
			tmp[size++] = index[j++];
		}
		for(int k = start; k <= end; k++){
			index[k] = tmp[k - start];
		}
	}
	
	


	// 下面方法只能算出逆序数的总对数，没有得到数组中的每个数对应有几个逆序数
	//利用归并排序的思想  计算该数组中总的逆序对的数量
	//对应邹博ppt 查找排序的12页，因为java没有按引用传值，所以这里的count无法直接传进方法里面
	private static int count(int[] nums) {
		int count = 0;
		count = MergeSort(nums,0,nums.length-1);
		return count;
	}


	private static int MergeSort(int[] nums, int left, int right) {
		int count = 0;  
		if(left>=right)
			return count;
		int mid = (left+right)>>1;
		count += MergeSort(nums, left, mid);
		count += MergeSort(nums, mid+1, right);
		count += Merger(nums,left,mid,right);
		return count;
	}

	private static int Merger(int[] nums, int left, int mid, int right) {
		int count =0;
		int i = left;
		int j = mid +1;
		int[] tmp = new int[right-left+1];
		int size = 0;
		while(i<=mid&&j<=right){
			if(nums[i]<nums[j]){
				//正常情况，不是逆序
				tmp[size++] = nums[i++];
			}else{
				count += (mid-i+1);
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
		return count;
	}

	//求一个数组的逆序对，朴素解法，肯定超时
	private static List<Integer> countSmaller1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums.length==0||nums == null)
			return res;
		for(int i = 0 ; i<nums.length-1 ;i++){
			int c = 0 ;
			for(int j = i+1;j<nums.length;j++){
				if(nums[i]>nums[j]){
					c++;
				}
			}
			res.add(c);
		}
		res.add(0);
		return res;
	}

}
