package ljt.bupt.leetcode;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 26;
		boolean bool = isPerfectSquare(num);
		System.out.println(bool);
	}
	//A square number is 1+3+5+7+..., 
	public boolean isPerfectSquare1(int num) {
	    int i = 1;
	    while (num > 0) {
	        num -= i;
	        i += 2;
	    }
	    return num == 0;
	}
	private static boolean isPerfectSquare(int num) {
		if(num<0)
			return false;
		if(num<=1)
			return true;
		//一个大于1的数
		int low = 1;
		int high = num ;
		while(low <= high){
			int mid = low + ((high-low)>>1);
			if((mid == num/mid)&&(num%mid==0)){
				return true;
			}else if(mid > num/mid){
				high = mid-1;
			}else{
				low = mid +1;
			}
		}
		return false;
	}

}
