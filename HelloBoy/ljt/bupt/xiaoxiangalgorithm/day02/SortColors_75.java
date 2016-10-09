package ljt.bupt.xiaoxiangalgorithm.day02;

import java.util.Arrays;

public class SortColors_75 {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 2, 1, 2, 1, 0, 0, 2, 1, 2, 0, 0, 1, 2, 1, 2, 0 };
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
//  还有一种解法就是两次使用partition  先选0最为key，将不是0d的都放后面，然后选1作为key
//    class Solution {  
//    public:  
//        void sortColors(int A[], int n) {  
//            int mid = Partition(A,0,n-1,0);  
//            Partition(A,mid,n-1,1);  
//        }  
//      
//        int Partition(int A[],int begin,int end,int key){  
//            int i,j;  
//      
//            for(i = j = begin;j <= end;j++){  
//                if(A[j] == key){  
//                    Swap(&A[i],&A[j]);  
//                    i++;  
//                }  
//            }  
//            return i;  
//        }  
//      
//        void Swap(int *a,int *b){  
//            int temp = *a;  
//            *a = *b;  
//            *b = temp;  
//        }  
//    };  
	
	
	// 荷兰国旗问题，借助快排的思想partition ，start cur end 三个指针
	private static void sortColors(int[] nums) {
		int len = nums.length;
		int start = 0;
		int cur = 0;
		int end = len - 1;
		while (cur <= end) {
			if (nums[cur] == 0) {
				if (start != cur)
					swap(nums, cur, start);
				start++;
				cur++;
			} else if (nums[cur] == 1) {
				cur++;
			} else {
				swap(nums, cur, end);
				end--;
			}
		}
	}

	private static void swap(int[] nums, int cur, int end) {
		int tmp = nums[cur];
		nums[cur] = nums[end];
		nums[end] = tmp;
	}

	// A rather straight forward solution is a two-pass algorithm using counting
	// sort.
	// First, iterate the array counting number of 0's, 1's, and 2's, then
	// overwrite array with total number of 0's, then 1's and followed by 2's.
	//
	// Could you come up with an one-pass algorithm using only constant space?
	private static void sortColors1(int[] nums) {
		int zeroC = 0;
		int oneC = 0;
		int twoC = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroC++;
			}
			if (nums[i] == 1) {
				oneC++;
			}
			if (nums[i] == 2) {
				twoC++;
			}
		}
		for (int j = 0; j < zeroC; j++)
			nums[j] = 0;
		for (int j = 0; j < oneC; j++)
			nums[j + zeroC] = 1;
		for (int j = 0; j < twoC; j++)
			nums[j + zeroC + oneC] = 2;
	}

}
