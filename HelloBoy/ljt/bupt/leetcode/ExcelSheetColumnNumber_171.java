package ljt.bupt.leetcode;

public class ExcelSheetColumnNumber_171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AG";
		int res = titleToNumber(s);
		System.out.println(res);
	}

	private static int titleToNumber(String s) {
		int len =s.length();
		int res = 0;
		for(int i = len-1 ; i >= 0 ;i--){
			int c =  s.charAt(len - i-1)-64;
			//System.out.println(c);
			res +=  c * Math.pow(26, i);
		}
		return res;
	}

}
