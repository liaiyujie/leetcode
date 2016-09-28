package ljt.bupt.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomizedSet_380 {

	 Set<Integer> set  = null;
    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        set = new HashSet<>(); 
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	return set.add(val);
    }
    
    /** Deletes a value from the set. Returns true if the set contained the specified element. */
    public boolean delete(int val) {
        if(set.contains(val)){
        	return set.remove(val);
        }else{
        	return false;
        }
    }
    /** Get a random element from the set. */
    public int getRandom() {
        Iterator<Integer> it = set.iterator();
        int size = set.size();
        Random random = new Random();
    	int r = random.nextInt(size)+1;
    	while(true){
    		int value = it.next();
    		r--;
    		if(r==0){
    			return value;
    		}
    	}
    }
    
    
    
    
    /** Get a random element from the set. */
//    public int getRandom() {   //leetcode不识别Random这个类
//        Iterator<Integer> it = set.iterator();
//        int size = set.size();
//        Random random = new Random();
//    	int r = random.nextInt(size)+1;
//    	while(true){
//    		int value = it.next();
//    		r--;
//    		if(r==0){
//    			return value;
//    		}
//    	}
//    }
    public static void main(String[] args) {
    	RandomizedSet_380 obj = new RandomizedSet_380();
    	 boolean param_1 = obj.insert(5);
    	
    	 boolean param_2 = obj.insert(7);
    	 //boolean param_5 = obj.insert(9);
    	 System.out.println(param_1);
    	 System.out.println(param_2);
    	// System.out.println(param_5);
    	 boolean param_3 = obj.delete(7);
    	 System.out.println(param_3);
    	 int param_4 = obj.getRandom();
    	 System.out.println(param_4);
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.delete(val);
 * int param_3 = obj.getRandom();
 */