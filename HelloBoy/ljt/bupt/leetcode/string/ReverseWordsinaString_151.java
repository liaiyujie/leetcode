package ljt.bupt.leetcode.string;

//ReverseWordsinaStringII 题目说的是这个字符串是一个标准的不带前导后导空格，并且每个字符串被一个空格分隔
//要求in-place的算法。
//这道题要求in-place做法，不能使用extra space, 那么，做法跟Rotate Array那道题非常相似
//（1）reverse the whole array
//（2）reverse each subarray seperated by ' '
public class ReverseWordsinaString_151 {

	public static void main(String[] args) {
		String s = "  the sky is   blue   ";
		String res = reverseWords(s);
		System.out.println(res);
	}

	private static String reverseWords(String s) {
		if(s.length() ==0||s==null){
			return s;
		}
		s = s.trim();//去掉前导后导空格
		String[] ss = s.split("\\s+");//  \\s就是指空格
//		String[] ss = s.split(" +");//以一个或者多个空格作为切割正则
//		String res = "";
		StringBuilder sb = new StringBuilder();
		for(int i = ss.length-1;i>=0;i--){
			sb.append(ss[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
