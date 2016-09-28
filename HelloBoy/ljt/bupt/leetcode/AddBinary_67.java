package ljt.bupt.leetcode;

import java.math.BigInteger;

public class AddBinary_67 {

	public static void main(String[] args) {
		String a = "1110";
		String b = "111";
		System.out.println(addBinary(a,b));

	}
	private static String addBinary(String a, String b) {
		StringBuilder sb1 = new StringBuilder(a);
		StringBuilder sb2 = new StringBuilder(b);
		String aa = sb1.reverse().toString();
		String bb = sb2.reverse().toString();
		StringBuilder res = new StringBuilder();
		
		int carry = 0;
		int lenmin = (a.length() < b.length() ? a.length() : b.length());
		int lenmax = (a.length() > b.length() ? a.length() : b.length());
		
		if(lenmin == lenmax){//两个字符串长度相等
			
			for(int i = 0 ; i <lenmax ; i++){
				int aNum = aa.charAt(i) - '0';
				int bNum = bb.charAt(i) - '0';
				int sum = aNum + bNum + carry ;
				carry = sum/2;
				res.append(sum%2);
			}
			if(carry!=0){
				res.append(carry);
			}
		}else{
			
			for(int i = 0 ; i <lenmin ; i++){//先把相等长度的部分加上
				int aNum = aa.charAt(i) - '0';
				int bNum = bb.charAt(i) - '0';
				int sum = aNum + bNum + carry ;
				carry = sum/2;
				res.append(sum%2);
			}
			if(aa.length()>bb.length()){
				for(int i = lenmin; i<lenmax ; i++){
					int aNum = aa.charAt(i) - '0';
					int sum = aNum + carry ;
					carry = sum/2;
					res.append(sum%2);
				}
				if(carry!=0){
					res.append(carry);
				}
			}
			
			if(aa.length()< bb.length()){
				for(int i = lenmin; i<lenmax ; i++){
					int bNum = bb.charAt(i) - '0';
					int sum = bNum + carry ;
					carry = sum/2;
					res.append(sum%2);
				}
				if(carry!=0){
					res.append(carry);
				}
			}
		}
		
		return res.reverse().toString();
	}
	
	
	private static String addBinary2(String a, String b) {//使用api
		BigInteger aa = new BigInteger(a, 2);
		BigInteger bb = new BigInteger(b, 2);
		aa = aa.add(bb);
		String s = aa.toString(2);
		return s;
	}
	public static String addBinary1(String a, String b) {//溢出
	       long aa = Long.parseLong(a, 2);
			long bb = Long.parseLong(b, 2);
			//System.out.println(aa+","+bb);
			long sum = aa+ bb;
			String result = Long.toBinaryString(sum);
			return result;
	    }
}
