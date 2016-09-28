package ljt.bupt.leetcode;

public class ZigZagConversion_6 {

	public static void main(String[] args) {
		String s = "ABCDEFGHIJKLMNOPQ";
		int numRows = 4;
		String res = convert(s, numRows);
		System.out.println(res);
	}

	private static String convert(String s, int numRows) {
		char[] cha = s.toCharArray();
		char[] mycha = new char[cha.length];
		int x = -1;
		if (numRows <= 1 || s.length() == 0) {
			return s;
		} else {
			for (int i = 0; i < numRows; i++) {
				int index = i;
				boolean flag = true;
				while (index < cha.length) {
					x++;
					mycha[x] = cha[index];
					if (flag) {// （第奇数次计算）
						if (i == numRows - 1) {
							index = index + 2 * (numRows - 1);
							flag = false;
						} else {
							index += (numRows - i - 1) * 2;
							flag = false;
						}
					} else {// （第偶数数次计算）
						if (i == 0 || i == numRows - 1) {
							index = index + 2 * (numRows - 1);
							flag = false;
						} else {
							index = index + 2 * (numRows - 1) - (numRows - i - 1) * 2;
							flag = true;
						}
					}
				}
			}
			String result = new String(mycha);
			return result;
		}
	}
}
