package ljt.bupt.leetcode;

public class Numberof1Bits_191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -11;
		int re = hammingWeight1(n);
		System.out.println(re);
	}

	private static int hammingWeight(int n) {
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1);
			n = n>>>1;
		}
		return ones;
	}

	private static int hammingWeight1(int n) {
		// TODO Auto-generated method stub
		String re = Integer.toBinaryString(n);
		System.out.println(re);
		int count = 0;
		char[] cha = re.toCharArray();
		for(int i = 0; i< cha.length;i++){
			if(cha[i] == '1'){
				count++;
			}
		}
		return count;
	}

}
