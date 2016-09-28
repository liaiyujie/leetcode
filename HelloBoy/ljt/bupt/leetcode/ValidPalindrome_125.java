package ljt.bupt.leetcode;

public class ValidPalindrome_125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		boolean bool = isPalindrome(s);
		System.out.println(bool);
	}

	private static boolean isPalindrome(String s) {
		if ("".equals(s) || s.trim().equals(""))
			return true;
		String ss = s.toLowerCase();
		int left = 0;
		int right = ss.length() -1;
		while(left < right){
			if(!isValid(ss.charAt(left))){
				left++;
			}else if(!isValid(ss.charAt(right))){
				right--;
			}else{
				if(ss.charAt(left)!=ss.charAt(right)){
					return false;
				}else{
					left++;
					right--;
				}
			}
		}
		return true;
	}

	private static boolean isValid(char charAt) {
		if ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
			return true;
		}
		return false;
	}

	private static boolean isPalindrome1(String s) {//超时
		//两行解决问题，使用正则表达式
//		s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
//		return new StringBuilder(s).reverse().toString().equals(s);		
		if ("".equals(s) || s.trim().equals(""))
			return true;
		String ss = s.toLowerCase();
		String re = "";
		for (int i = 0; i < ss.length(); i++) {
			if ((ss.charAt(i) >= '0' && ss.charAt(i) <= '9') || (ss.charAt(i) >= 'a' && ss.charAt(i) <= 'z')) {
				re += ss.charAt(i);
			}
		}
		// System.out.println(re);
		if ("".equals(re))
			return true;
		StringBuilder sb = new StringBuilder(re);
		if(sb.reverse().toString().equals(re))
			return true;
		return false;
	}

}
