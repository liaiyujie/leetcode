package ljt.bupt.leetcode;

public class Sqrt_x {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2147483647;
		System.out.println(mySqrt(x));
	}

	private static int mySqrt(int x) {
		// 使用二分查找法搜索整个整数域的值，找到某个整数y满足 y*y<= x <(y+1)*(y+1)
//		if (x <= 1)
//			return x;
//		int l = 1, r = x;
//		while (l < r) {
//			int m = l + (r - l) / 2;
//			if (m * m / m != m || m * m > x)
//				r = m;
//			else
//				l = m + 1;
//		}
//		return r - 1;
		if (x <= 1)
			return x;
		int low = 1;
		int high = x;
		while (low < high) {
			int mid = low + (high - low)/2;
			if(mid * mid / mid != mid || mid*mid > x){
				high = mid;
			}else{
				low = mid +1;
			}
		}
		return high -1;
	}

	private static int mySqrt1(int x) {
		// 使用javaAPI
		if (x <= 0)
			return 0;
		else
			return (int) Math.sqrt(x);
	}

}
