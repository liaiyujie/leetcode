package ljt.bupt.jiudu;

import java.math.BigInteger;
import java.util.Arrays;

public class jiudu_1335 {
	public static void main(String[] args) {
		String s1 = "999111111111111111111111111111111111111111111111111111";
		String s2 = "1111111111111111111111111111111111111111111111111111";
		BigInteger b1 = new BigInteger(s1);
		BigInteger b2 = new BigInteger(s2);
		BigInteger b = b1.add(b2);

		System.out.println(b.toString());
		
		
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
		
		int[] nums = {1,2,3,4};
//		 复制指定的数组，截取或用 0 填充（如有必要），以使副本具有指定的长度。
		int[] copy = Arrays.copyOf(nums, 5);//深复制
		copy[1] = 100;
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(nums));
		
		int[] newN = {1,2,3,4};
		int[] a = Arrays.copyOfRange(newN, 0, 3);
		System.out.println(Arrays.toString(newN));
		System.out.println(Arrays.toString(a));
		
		
		
		
		
	}
	
//	int go[][] = {
//			{-1,0},
//			{1,0},
//			{0,-1},
//			{0,1}
//	};
//    boolean[][] mark = null; 
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		while (in.hasNext()) {
//			int t = in.nextInt();
//			int[][] nums = new int[t][t];
//			for (int i = 0; i < t; i++) {
//				for (int j = 0; j < t; j++) {
//					nums[i][j] = in.nextInt();
//				}
//			}
//
//		}
//
//	}

}

class Num {
	int x;
	int y;
	int t;

}
