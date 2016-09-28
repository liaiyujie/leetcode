package ljt.bupt.leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII_220 {

	public static void main(String[] args) {
		int[] nums = {5,4,2,8,6};
		boolean bool = containsNearbyAlmostDuplicate(nums,3, 100);
		System.out.println(bool);
	}
	
	private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {
            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }
        return false;
    }
	
	
//	维持一个长度为k的window, 每次检查新的值是否与原来窗口中的所有值的差值有小于等于t的.
//	如果用两个for循环会超时O(nk). 使用treeset( backed by binary search tree) 
//	的subSet函数,可以快速搜索. 复杂度为 O(n logk)
	private static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {  
        //input check  
        if(k<1 || t<0 || nums==null || nums.length<2) return false;  
          
        SortedSet<Long> set = new TreeSet<Long>();  
          
        for(int j=0; j<nums.length; j++) {
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
            if(!subSet.isEmpty()) 
            	return true;  
            if(j>=k) {
                set.remove((long)nums[j-k]);  
            }  
            set.add((long)nums[j]);  
        }  
        return false;  
    }  
	
	
	private static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {//超時
		for(int i = 0; i<nums.length-k;i++){
            for(int j = i+1;j<=i+k&&j<nums.length;j++){
                if(nums[i]-nums[j]<=t){
                	return true;
                }
            }
        }
		 return false;
	}

}
