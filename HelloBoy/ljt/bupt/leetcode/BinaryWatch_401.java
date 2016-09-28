package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch_401 {
	static int[] min = new int[] { 1, 2, 4, 8, 16, 32 };
	static int[] hour = new int[] { 1, 2, 4, 8 };

	public static void main(String[] args) {
		int num = 1;
		List<String> res = readBinaryWatch(num);
		System.out.println(res);

	}

	private static List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> timeNumMap = new HashMap<>();
//      预先将所有的可能性放入map中
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				String time = String.format("%d:%02d", i, j);
				int num1 = bitCount(i) + bitCount(j);
				timeNumMap.put(time, num1);
			}
		}
		for (Map.Entry<String, Integer> entry : timeNumMap.entrySet()) {
			int num1 = entry.getValue();
			if (num1 == num) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
	//计算一个整数二进制中含有多少个1
	private static int bitCount(int d) {
		int cnt = 0;
		while (d > 0) {
			cnt++;
			d &= (d - 1);
		}
		return cnt;
	}
	
	

	// Backtracking
	private static List<String> readBinaryWatch3(int num) {
		List<String> res = new ArrayList();
		if (num > 8) { // impossible if num>8 because the max time is 11:59
			return res;
		}
		if (num == 0) {
			String ans = "0:00"; // return the basic situation of num=0
			res.add(ans);
			return res;
		}
		int temp[] = { 8, 4, 2, 1, 32, 16, 8, 4, 2, 1 };// hours and minutes in an array!

		boolean index[] = new boolean[10];// boolean array to check if used!
		helper(res, temp, index, num, 0);
		return res;
	}

	static void helper(List<String> res, int[] temp, boolean[] index, int num, int start) {
		if (num == 0) {// num=0,it is time to return answers!
			int hour = 0;
			int minute = 0;
			for (int k = 0; k < 10; k++) {
				if (index[k] == true && k <= 3) {
					hour += temp[k];
				}
				if (index[k] == true && k > 3) {
					minute += temp[k];
				}
			}
			if (hour >= 12 || minute >= 60) {// impossible cases!
				return;
			} else {// Two situations of minutes to add to the string!!
				if (minute < 10) {
					String answer = "" + hour + ":" + "0" + minute;
					res.add(answer);
					return;
				} else {
					String answer = "" + hour + ":" + minute;
					res.add(answer);
					return;
				}

			}
		}
		for (int i = start; i < temp.length; i++) {// Backtracking Loop from
													// here!
			index[i] = true;
			helper(res, temp, index, num - 1, i + 1);
			index[i] = false;
		}
	}

	private static List<String> readBinaryWatch2(int num) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i <= Math.min(num, 4); i++) {
			List<String> hours = new ArrayList<>();
			List<String> mins = new ArrayList<>();
			getHours(i, hour, 0, 0, hours, 0);
			getMin(num - i, min, 0, 0, mins, 0);
			for (String hour : hours) {
				for (String min : mins) {
					if (!res.contains(hour + ":" + min))
						res.add(hour + ":" + min);
				}
			}
		}
		return res;
	}

	private static void getHours(int num, int[] hour, int index, int k, List<String> list, int sum) {
		if (num == 0) {
			list.add("0");
			return;
		} else {
			if (k == num && sum < 12) {
				list.add(Integer.toString(sum));
				return;
			}
			for (int i = index; i < hour.length; i++) {
				sum += hour[i];
				getHours(num, hour, i + 1, k + 1, list, sum);
				sum -= hour[i];
			}
		}
	}

	private static void getMin(int num, int[] min, int index, int k, List<String> list, int sum) {
		if (num == 0) {
			list.add("00");
			return;
		}
		if (k == num && sum <= 59) {

			if (sum < 10)
				list.add("0" + Integer.toString(sum));
			else
				list.add(Integer.toString(sum));
			return;
		}
		if (index == min.length)
			return;

		for (int i = index; i < min.length; i++) {
			sum += min[i];
			getMin(num, min, i + 1, k + 1, list, sum);
			sum -= min[i];
		}
	}

	private static List<String> readBinaryWatch1(int num) {// simple stupid 打表
		List<String> res = new ArrayList<>();
		if (num < 0 || num > 8)
			return res;
		for (int i = 0; i <= num; i++) {
			String[] hour = getHour(i);
			if (i > 3 || num - i > 5)
				continue;
			String[] minute = getMinute(num - i);
			List<String> tmp = new ArrayList<>();
			// 将这种情况的组合加入tmp
			for (int j = 0; j < hour.length; j++) {
				for (int k = 0; k < minute.length; k++) {
					String t = hour[j] + ":" + minute[k];
					tmp.add(t);
				}
			}
			res.addAll(tmp);
		}
		return res;
	}

	private static String[] getMinute(int i) {
		String[] nums = null;
		if (i == 0) {// d
			nums = new String[1];
			nums[0] = "00";
		}
		if (i == 1) {// d
			nums = new String[6];
			nums[0] = "01";
			nums[1] = "02";
			nums[2] = "04";
			nums[3] = "08";
			nums[4] = "16";
			nums[5] = "32";
		}
		if (i == 2) {// d
			nums = new String[15];
			nums[0] = "03";
			nums[1] = "05";
			nums[2] = "09";
			nums[3] = "17";
			nums[4] = "06";
			nums[5] = "10";
			nums[6] = "18";
			nums[7] = "12";
			nums[8] = "20";
			nums[9] = "24";
			nums[10] = "33";
			nums[11] = "34";
			nums[12] = "36";
			nums[13] = "40";
			nums[14] = "48";

		}
		if (i == 3) {
			nums = new String[20];
			nums[0] = "07";
			nums[1] = "11";
			nums[2] = "19";
			nums[3] = "35";
			nums[4] = "13";
			nums[5] = "21";
			nums[6] = "37";
			nums[7] = "25";
			nums[8] = "41";
			nums[9] = "49";
			nums[10] = "14";
			nums[11] = "22";
			nums[12] = "38";
			nums[13] = "26";
			nums[14] = "42";
			nums[15] = "50";
			nums[16] = "28";
			nums[17] = "44";
			nums[18] = "52";
			nums[19] = "56";
		}
		if (i == 4) {// d
			nums = new String[14];
			nums[0] = "58";
			nums[1] = "15";
			nums[2] = "23";
			nums[3] = "27";
			nums[4] = "29";
			nums[5] = "30";
			nums[6] = "39";
			nums[7] = "43";
			nums[8] = "51";
			nums[9] = "45";
			nums[10] = "53";
			nums[11] = "57";
			nums[12] = "46";
			nums[13] = "54";
		}
		if (i == 5) {// d
			nums = new String[4];
			nums[0] = "31";
			nums[1] = "47";
			nums[2] = "55";
			nums[3] = "59";
		}
		return nums;
	}

	private static String[] getHour(int i) {// i的取值可能性为0 1 2 3
		String[] nums = null;
		if (i == 0) {
			nums = new String[1];
			nums[0] = "0";
		}
		if (i == 1) {
			nums = new String[4];
			nums[0] = "1";
			nums[1] = "2";
			nums[2] = "4";
			nums[3] = "8";
		}
		if (i == 2) {
			nums = new String[5];
			nums[0] = "3";
			nums[1] = "5";
			nums[2] = "9";
			nums[3] = "6";
			nums[4] = "10";
		}
		if (i == 3) {
			nums = new String[2];
			nums[0] = "7";
			nums[1] = "11";
		}
		return nums;
	}

}
