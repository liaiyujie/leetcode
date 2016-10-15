package ljt.bupt.leetcode;

import java.util.Arrays;

public class BulbSwitcher_319 {

	public static void main(String[] args) {
		int n = 9999;
//		int n = 8;
		long start = System.currentTimeMillis();
		int res = bulbSwitch(n);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(res);
	}
	
	// A bulb ends up on iff it is switched an odd number of times.
	//
	// Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if
	// d divides i. So bulb i ends up on if and only if it has an odd number of
	// divisors.
	//
	// Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3
	// and 4. Except when i is a square, like 36 has divisors 1 and 36, 2 and
	// 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on if and
	// only if i is a square.
	//
	// So just count the square numbers.
	//
	// Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n].
//	And 1 is the smallest root. So you have the roots from 1 to R, that's R roots. 
//	Which correspond to the R squares. So int(sqrt(n)) is the answer. 
//	(C++ does the conversion to int automatically, because of the specified return type).
	
	
//和我发现的规律一样，但是我没有发现这层规律 o(╯□╰)o

//    方法2：我们可以很容易地想到，最后状态是on的灯泡代表的标号，说明只有奇数个约数。
//
//    eg:在N足够大的情况下：
//        1号：因为只为1的倍数，只switch一次，on
//        2号：为1,2的倍数，switch两次，off
//        3号：为1,3的倍数，switch两次，off
//        4号：为1,2,4的倍数，switch三次，on
//        ...
//    而什么情况会只有奇数个约数呢，平方数。
//    因而只需找到在不大于N的范围内的平方数个数即可。
	private static int bulbSwitch(int n) {
		
		return (int) Math.sqrt(n);
		
		
//		if (n == 1)
//			return 1;
//		int count = 1;// 1为亮
//		int tmp = 2;
//		while(tmp*tmp<=n){
//			tmp++;
//			count++;
//		}
//		return count;
	}



	// 找数学规律，能定位每个数最后的状态，当这个数从2到这个数本身有偶数个倍数，着最后为亮
	// 比如4 有2和4 这两个倍数。所以最后为亮。6有2 3 6 三个倍数，最后为暗
	//时间复杂度更加高了，也更加慢了，没有更好的剪枝策略
	private static int bulbSwitch2(int n) {
		if (n == 1)
			return 1;
		int count = 1;// 1为亮
		for (int i = 2; i <= n; i++) {// 定位2 到n的每一个数的亮暗状态
			int c = 1;// 每个数都是自己的1倍
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					c++;
				}
			}
			if (c % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	// 明显超时，需要找到数学规律
	private static int bulbSwitch1(int n) {
		boolean[] bool = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			bool[i] = true;
		}
		for (int i = 2; i <= n; i++) {
			int tmp = i;
			while (tmp <= n) {
				if (bool[tmp]) {
					bool[tmp] = false;
				} else {
					bool[tmp] = true;
				}
				tmp = i + tmp;
			}
			 System.out.println(Arrays.toString(bool));
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (bool[i])
				count++;
		}
		return count;
	}

}
