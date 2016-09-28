package ljt.bupt.leetcode;

public class Powxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 8.88;
		int n = 3;
		double result = x;
		for(int i = 0; i< n-1; i++){
			result*=x;
		}
		System.out.println(result);
		System.out.println(myPow(x, n));
		System.out.println(Math.pow(x, n));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}

	private static double myPow(double x, int n) {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}

}
