package ljt.bupt.leetcode;

public class ConvertaNumbertoHexadecimal_405 {

	public static void main(String[] args) {
		int num = 26;
		String res = toHex(num);
		System.out.println(res);
	}
	/*public class Solution {
	    
	    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	    
	    public String toHex(int num) {
	        if(num == 0) return "0";
	        String result = "";
	        while(num != 0){
	            result = map[(num & 15)] + result; 
	            num = (num >>> 4);
	        }
	        return result;
	    }
	    
	    
	}````*/
	private static String toHex(int num) {
//		String s = Integer.toBinaryString(num);
		String ss = Integer.toHexString(num);
		if(num==0)
			return "0";
		StringBuilder sb = new StringBuilder();
		while(num!=0){
			int i = num&15;
			if(i>=0&&i<=9){
				sb.append(i);
			}else{
				sb.append((char)(i-10+'a'));
			}
			num = num>>>4;
		}
		return sb.reverse().toString();
	}

}
