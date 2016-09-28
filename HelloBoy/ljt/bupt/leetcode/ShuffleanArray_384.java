package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleanArray_384 {
	private int[] arr ;

    public ShuffleanArray_384(int[] nums) {
        this.arr = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	return arr;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {//使用random随机数
    	int len = this.arr.length;
    	int[] newArr = new int[len];
    	for(int i = 0 ; i< len ; i++ ){
    		newArr[i] = this.arr[i];
    	}
//    	System.out.println(Arrays.toString(newArr));
    	for(int i = 0 ; i< len ; i++){
    		Random r = new Random();
    		int randomIndex = r.nextInt(len-i)+i;
    		if(randomIndex != i){
    			//交换下标为i和randomIndex的数字
    			int tmp = newArr[i];
    			newArr[i] = newArr[randomIndex];
    			newArr[randomIndex] = tmp;
    		}
    	}
    	return newArr;
    }
    
    
    public int[] shuffle1() {//使用集合框架的工具类Collections的Shuffle方法
    	int len = this.arr.length;
    	int[] newArr = new int[len];
    	List list = new ArrayList();
    	for(int i = 0 ; i< len ; i++){
    		list.add(this.arr[i]);
    	}
    	Collections.shuffle(list);
    	for(int i = 0 ; i< len ; i++){
    		newArr[i] = (int) list.get(i);
    	}
    	return newArr;
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7,8,9};
    	ShuffleanArray_384 obj = new ShuffleanArray_384(nums);
    	int[] param_2 = obj.shuffle();
   	 	System.out.println(Arrays.toString(param_2));
    	int[] param_1 = obj.reset();
    	System.out.println(Arrays.toString(param_1));
    	int[] param_3 = obj.shuffle();
   	 	System.out.println(Arrays.toString(param_3));
//    	List list = new ArrayList();
//    	list.add(1);
//    	list.add(2);
//    	list.add(3);
//    	Collections.shuffle(list);
//    	System.out.println(list);
    	 
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
