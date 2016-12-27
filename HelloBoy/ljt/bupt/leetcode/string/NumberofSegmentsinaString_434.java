package ljt.bupt.leetcode.string;

public class NumberofSegmentsinaString_434 {

	public static void main(String[] args) {
//		String s = "Hello, my name is John";
//		String s = "The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";
		String s = ", , , ,        a, eaefa";
		int res = countSegments(s);
		System.out.println(res);
	}

	private static int countSegments(String s) {
		int count = 0;
		char[] c = s.toCharArray();
		boolean flag = false;
		for(int i = 0 ; i< c.length ;i++){
			if(flag){
				if(!isChar(c[i])){
					flag = false;
				}
				continue;
			}
			if(isChar(c[i])){
				flag = true;
				count++;
			}
		}
		return count;
	}
	private static boolean isChar(char c) {
		if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='\''||c=='-')
			return true;
		return false;
	}
}
