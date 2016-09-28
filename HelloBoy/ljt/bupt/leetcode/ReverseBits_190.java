package ljt.bupt.leetcode;

public class ReverseBits_190 {

	public static void main(String[] args) {
		int re = reverseBits(43261596);
		System.out.println(re);
	}

	private static int reverseBits(int n) {
		int r = 0;
		for (int i = 0; i < 32; i++) {
			r <<= 1;// 一位一位的移动，r为保存的已经移动的值
			r |= n & 1;
			n >>= 1;
		}
		return r;
	}

	private static int reverseBits2(int n) {
		int reverse = 0;
		for (int i = 0; i < 32; i++) {
			reverse |= ((n >>> i) & 1) << (31 - i);
		}
		return reverse;
	}

	private static int reverseBits1(int n) {
		String s = Long.toBinaryString(n);
		System.out.println(s);
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ss = sb.reverse();
		while (ss.length() < 32) {
			ss.append("0");
		}
		String re = ss.toString();
		int res = (int) Long.parseLong(re, 2);
		return res;
	}

}
