package ljt.bupt.leetcode;

public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		String[] strs = {  };
		String res = longestCommonPrefix(strs);
		System.out.println(res);
//		System.out.println("".length());
	}

	
	
	//暴力法
	private static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		String s = "";
		int len = Integer.MAX_VALUE;
		//得到最小的长度
		for(int i = 0 ; i< strs.length ;i++){
			len = len > strs[i].length() ? strs[i].length() :len ;
		}
		if(len == 0){//有“”元素
			return s;
		}
		boolean flag = true;
		for(int i = 0 ; i< len ;i++){
			for(int j = 1 ; j< strs.length ;j++){
				if(strs[j].charAt(i)!=strs[j-1].charAt(i)){
					flag = false;
				}
			}
			if(flag){
				s += strs[0].charAt(i);
			}
		}
		
		return s;
	}

}
