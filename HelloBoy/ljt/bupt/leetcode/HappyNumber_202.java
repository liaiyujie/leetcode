package ljt.bupt.leetcode;


public class HappyNumber_202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bool = isHappy(20);
		System.out.println(bool);
	}

	private static boolean isHappy(int n) {
		
	    int slow = n;
	    int fast = n;
	    do {
	        slow = digitSquareSum(slow);
	        fast = digitSquareSum(fast);
	        fast = digitSquareSum(fast);
	    } while(slow != fast);
	    if (slow == 1) return true;
	    else return false;
	}

	private static int digitSquareSum(int n) {
		int sum = 0, tmp;
	    while (n!=0) {
	        tmp = n % 10;
	        sum += tmp * tmp;
	        n /= 10;
	    }
	    return sum;
	}

}
