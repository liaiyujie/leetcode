package ljt.bupt.leetcode;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,3,2,1,6,7,8,9,8,7,5,1,2,3,4,5};
		TreeSet set = new TreeSet();
		for(int i : nums){
			set.add(i);
		}
		System.out.println(set);
		SortedSet subset = set.subSet(4, 10);
		System.out.println(subset);
		int floor = (int) set.floor(10);
		int ceil = (int)set.ceiling(6);
		System.out.println(floor +":" +ceil);
		
	}

}
