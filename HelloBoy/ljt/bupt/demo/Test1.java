package ljt.bupt.demo;

import java.math.BigInteger;
import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		
		int val = 4;
		val = changeVal(val);
		System.out.println(val);
		
		/*String s1 = "999111111111111111111111111111111111111111111111111111";
		String s2 = "1111111111111111111111111111111111111111111111111111";
		BigInteger b1 = new BigInteger(s1);
		BigInteger b2 = new BigInteger(s2);
		BigInteger b = b1.add(b2);

		System.out.println(b.toString());*/
		
		
		/*int[] nums = {1,2,3,4};
		int[] copy = nums.clone();//深复制
		copy[1] = 100;
		System.out.println(copy==nums);
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(nums));
		
		
		int[] num = nums;//浅复制
		num[1] = 900;
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(nums));*/
		
//		int[] nums = {1,2,3,4};
//		 复制指定的数组，截取或用 0 填充（如有必要），以使副本具有指定的长度。
//		int[] copy = Arrays.copyOf(nums, 5);//深复制
//		copy[1] = 100;
//		System.out.println(Arrays.toString(copy));
//		System.out.println(Arrays.toString(nums));
//		
//		int[] newN = {1,2,3,4};
//		int[] a = Arrays.copyOfRange(newN, 0, 3);
//		System.out.println(Arrays.toString(newN));
//		System.out.println(Arrays.toString(a));
	}

	private static int changeVal(int val) {
		return val = 5;
		
	}

}
