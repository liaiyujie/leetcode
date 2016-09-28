package ljt.bupt.leetcode;

public class FractiontoRecurringDecimal_166 {

	public static void main(String[] args) {
		int numerator = 1;
		int denominator = 6;

		String res = fractionToDecimal(numerator, denominator);
		System.out.println(res);
	}

	private static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		int mod = numerator % denominator;
		int res = numerator / denominator;
		if (mod == 0) {//整除
			sb.append(res);
			return sb.toString();
		}else if(true){//有小数的除
			//Todo  
			
			
			
		}else {//无线循环小数   还不完善，比如说1/6 的表达式为0.1666666  0.1(6),该程序还得不出答案
			sb.append(res).append('.').append('(');
		}
		int modtmp = mod;
		do{
			modtmp = 10 * modtmp;
			res = modtmp / denominator;
			sb.append(res);
			if(modtmp >= denominator){
				modtmp = modtmp % denominator;
			}
//			modtmp = 10 * modtmp;
		}while(modtmp!=mod);
		sb.append(')');
		
		return sb.toString();
	}

}
