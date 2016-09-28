package ljt.bupt.leetcode;

public class PowerofTwo_231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		boolean bool = isPowerOfTwo(n);
		System.out.println(bool);
	}
//Power of 2 means only one bit of n is '1',
	//so use the trick n&(n-1)==0 to judge whether that is the case
	private static boolean isPowerOfTwo(int n) {
		if(n<=0) return false;
		int bool = n&(n-1);
        return bool>0? false: true;
	}

	private static boolean isPowerOfTwo1(int n) {
		if(n<1)
			return false;
		if(n==1)
			return true;
		while(n!=1){
			if(n%2==0){
				n/=2;
			}else{
				return false;
			}
		}
		return true;
	}

}
