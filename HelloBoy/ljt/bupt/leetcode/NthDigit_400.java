package ljt.bupt.leetcode;

public class NthDigit_400 {

	public static void main(String[] args) {
		for(int i = 1 ; i <1000 ; i++){
			int res = findNthDigit(i);
		System.out.println(res);
		}
		
	}

	private static int findNthDigit(int n) {
		int len = 0;
		for (int i = 0; i < 20; i++) {
			int tmp = (int) (9 * (i + 1) * Math.pow(10, i));
			if (n - tmp > 0) {
				n -= tmp;
			} else {
				len = i + 1;
				break;
			}

		}
		int start = (int) Math.pow(10, len - 1);
		n--;
		int rank1 = n / len;
		int rank2 = n % len;
		int num = start + rank1;
		char c = String.valueOf(num).charAt(rank2);
		int res = c - '0';

		return res;
	}

}
