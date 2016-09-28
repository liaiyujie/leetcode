package ljt.bupt.leetcode;

public class CompareVersionNumbers_165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "1.0";
		String version2 = "1";
		int res = compareVersion(version1, version2);
		System.out.println(res);
	}

	private static int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	private static int compareVersion2(String version1, String version2) {
		int l1 = version1.length();
		int l2 = version2.length();
		int v1 = 0;
		int v2 = 0;

		int i1 = 0;
		int i2 = 0;

		while (i1 < l1 || i2 < l2) {

			while (i1 < l1 && version1.charAt(i1) != '.') {
				v1 = 10 * v1 + (version1.charAt(i1) - '0');
				i1++;
			}

			while (i2 < l2 && version2.charAt(i2) != '.') {
				v2 = 10 * v2 + (version2.charAt(i2) - '0');
				i2++;
			}

			if (v1 > v2)
				return 1;
			else if (v1 < v2)
				return -1;
			else {
				v1 = 0;
				v2 = 0;
				i1++;
				i2++;
			}
		}

		return 0;
	}

	private static int compareVersion1(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");

		int[] tmp1 = new int[str1.length];
		int[] tmp2 = new int[str2.length];

		for (int i = 0; i < str1.length; i++) {
			tmp1[i] = Integer.parseInt(str1[i]);
		}
		for (int i = 0; i < str2.length; i++) {
			tmp2[i] = Integer.parseInt(str2[i]);
		}
		int len = (str1.length < str2.length) ? str1.length : str2.length;
		for (int i = 0; i < len; i++) {
			if (tmp1[i] == tmp2[i]) {
				continue;
			} else if (tmp1[i] < tmp2[i]) {
				return -1;
			} else {
				return 1;
			}
		}
		if (str1.length == str2.length) {
			return 0;
		} else if (str1.length > str2.length) {
			for (int i = str2.length; i < str1.length; i++) {
				if (tmp1[i] != 0) {
					return 1;
				}
			}
			return 0;
		} else {
			for (int i = str1.length; i < str2.length; i++) {
				if (tmp2[i] != 0) {
					return -1;
				}
			}
			return 0;
		}
	}

}
