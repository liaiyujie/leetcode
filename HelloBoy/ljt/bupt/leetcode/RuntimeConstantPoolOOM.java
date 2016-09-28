package ljt.bupt.leetcode;

public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//该程序在jdk1.6和之前会得到两个false，1。7即之后得到一个true一个false
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("dou").append("ble").toString();
		System.out.println(str2.intern() == str2);
	}

}
