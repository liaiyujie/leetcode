package ljt.bupt.leetcode;

public class ExcelSheetColumnTitle_168 {

	public static void main(String[] args) {
		String s = convertToTitle(52);
		System.out.println(s);
		String ss = Integer.toHexString(28);
		System.out.println(ss);
	}
	private static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		do{
			int re = (n-1)%26;
			char c = (char) ('A' + re);
			sb.append(c);
			n=(n-1)/26;
		}while(n>0);
		
		return sb.reverse().toString();
	}
	/*int shang = 0;  //商   
	 * int yushu = 0;  //余数   
	 * int value = 1;  //权值    
	  while(value <= n)    {
	 
	     value = value * 16;      
		yushu = n % value;      
		shang = yushu * 16 / value;       
	       if(shang>=0 && shang<=9)
	          v2.push_back(itos(shang));        
			else 
	         v2.push_back(ctos(char(shang+55)));    
	}*/
//	Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, 
//	and then here comes the base 26 representation, 
//	it's similar when you convert a number from base 10 to base 2
	private static String convertToTitle1(int n) {
		 String res = "";
		    while(n != 0) {
		        char ch = (char)((n - 1) % 26 + 'A');
		        n = (n - 1) / 26;
		        res = ch + res;
		    }
		    return res;
	}
	private static String toOct(int n) {
		StringBuilder sb = new StringBuilder();
		do{
			int re = n%8;
			sb.append(re);
			n=n/8;
		}while(n>0);
		
		return sb.reverse().toString();
	}

}
