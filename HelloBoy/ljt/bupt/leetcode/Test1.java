/*package ljt.bupt.demo;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello boy");
		System.out.println("hello boy2");
		System.out.println(Test1.class.getCanonicalName());//ljt.bupt.demo.Test1
	}

}
*/
package ljt.bupt.leetcode;


import java.util.Arrays;


public class Test1 {

	public static void main(String[] args) {
		String a = "11000";
		String b = "10";
		String result = addBinary(a, b);
		System.out.println(result);
	}

	private static String addBinary(String a, String b) {
//		String s = ".........";
//		s = (new StringBuffer(s)).reverse().toString;
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		char[] chara = a.toCharArray();
		char[] charb = b.toCharArray();
		
		int lena = a.length();
		int lenb = b.length();
		int minlen = lena <= lenb ? lena : lenb;
		int maxlen = lena <= lenb ? lenb : lena;
		int[] array = new int[minlen+1];//储存进位信息
		System.out.println(Arrays.toString(array));
		char[] result = new char[maxlen+1];
		for(int i = 0 ; i < lena && i < lenb ; i++){
			int num1 = chara[i]-'0';
			int num2 = charb[i]-'0';
			int re = num1 + num2 + array[i];
			switch(re){
			case 0:{
				result[i] =  '0';
				break;
			}
			case 1:{
				result[i] =  '1';
				break;
				
			}
				
			case 2:{
				result[i] = '0';
				array[i+1] = 1;
				break;
				
			}
				
			case 3:{
				result[i] = '1';
				array[i+1] = 1;
				break;
			}
				
			}
		}
		
		return null;
	}

	private static String addBinary1(String a, String b) {//这方法当二进制的字符串非常长的时候，会产生异常
//		int aa = Integer.parseInt(a, 2);
//		int bb = Integer.parseInt(b, 2);
//		//System.out.println(aa+","+bb);
//		int sum = aa+ bb;
//		String result = Integer.toBinaryString(sum);
//		return result;
		long aa = Long.parseLong(a, 2);
		long bb = Long.parseLong(b, 2);
		//System.out.println(aa+","+bb);
		long sum = aa+ bb;
		String result = Long.toBinaryString(sum);
		return result;
	}

}
