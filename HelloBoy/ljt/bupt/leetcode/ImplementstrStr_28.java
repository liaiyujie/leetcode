package ljt.bupt.leetcode;

public class ImplementstrStr_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "ilcodeove";
		String needle = "ove";
		int res =strStr(haystack, needle);
		System.out.println(res);
	}

	private static int strStr(String haystack, String needle) {
		int i, j;
		 for (i = j = 0; i < haystack.length() && j < needle.length();) {
		        if (haystack.charAt(i) == needle.charAt(j)) {
		              ++i;
		              ++j;
		         } else {
		                 i -= j - 1; j = 0;
		         }
		   }
		   return j != needle.length() ? -1 : i - j;
		
		
	}

}
