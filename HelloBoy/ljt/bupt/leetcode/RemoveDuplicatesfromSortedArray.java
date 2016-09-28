package ljt.bupt.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		int len = removeDuplicates(nums);
		System.out.println(len);
	}

	private static int removeDuplicates(int[] nums) {
		// TODO Auto-generated method stub
		//使用set集合去重
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length ; i++){
			set.add(nums[i]);
		}
		int len = set.size();
		return len;
	}

	private static int removeDuplicates2(int[] nums) {
		// TODO Auto-generated method stub
//		这道题要我们从有序数组中去除重复项，和之前那道 Remove Duplicates from Sorted List 
//		移除有序链表中的重复项 的题很类似，但是要简单一些，因为毕竟数组的值可以通过下标直接访问，而链表不行。
//		那么这道题的解题思路是，我们使用快慢指针来记录遍历的坐标，最开始时两个指针都指向第一个数字，
//		如果两个指针指的数字相同，则快指针向前走一步，如果不同，则两个指针都向前走一步，
//		这样当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数组的个数
//		int removeDuplicates(int A[], int n) {
//	        if (n <= 1) return n;
//	        int pre = 0, cur = 0;
//	        while (cur < n) {
//	            if (A[cur] == A[pre]) ++cur;
//	            else A[++pre] = A[cur++];
//	        }
//	        return pre + 1;
//	    }
		if(nums == null || nums.length==0)  
	        return 0;  
	    int index = 1;  
	    for(int i=1;i<nums.length;i++)  
	    {  
	        if(nums[i]!=nums[i-1])  
	        {  
	            nums[index]=nums[i];  
	            index++;  
	        }  
	    }  
	    return index;  
	}

	private static int removeDuplicates1(int[] nums) {
		// TODO Auto-generated method stub
		if(nums.length == 0){
			return 0;
		}
		if(nums.length==1){
			return 1;
		}
		if(nums.length ==2){
			if(nums[1]==nums[0]){
				return 1;
			}
			return 2;
		}
		int count = nums.length-2;
		int i = 0;
		int k= 0;
		while(k!=count){
			k++;
			i++;
			if(nums[i]!= nums[i-1]){
				continue;
			}else{
				for(int j = i ; j<nums.length-1 ; j++){
					nums[j] = nums[j+1];
				}
				nums[nums.length-1] = Integer.MAX_VALUE;
				i--;
			}
		}
	/*	for(int i = 1; i< nums.length ; i++){
			if(nums[i]!= nums[i-1]){
				continue;
			}else{
				for(int j = i ; j<nums.length-1 ; j++){
					nums[j] = nums[j+1];
				}
				nums[nums.length-1] = Integer.MAX_VALUE;
				//i--;
			}
		}*/
		int len = 0;
		for(int x = 0; x< nums.length ; x++ ){
			if(nums[x]==Integer.MAX_VALUE){
				break;
			}
			len++;
		}
		
		return len;
	}

}
