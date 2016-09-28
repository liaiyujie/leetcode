package ljt.bupt.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
//		int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
//		int result = nthSuperUglyNumber(100000,primes);
		int[] primes = {2,7,13,19};
		int result = nthSuperUglyNumber(11,primes);
		System.out.println(result);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		int i = 101;
		System.out.println(Math.sqrt(i));
	}
	
	private static int nthSuperUglyNumber(int n, int[] primes) {//效率超高
		int[] ugly = new int[n];
	    PriorityQueue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++){
	    	pq.add(new Num(primes[i], 1, primes[i]));
	    }
	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }
	    return ugly[n - 1];
	}

	public static int nthSuperUglyNumber1(int n,int[] primes) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		int count = 1;
		while(count<n){
			int head = queue.poll();
			while(queue.contains(head)){
				queue.poll();
			}
			for(int i = 0; i< primes.length; i++){
				queue.add(head*primes[i]);
			}
			count ++;
		}
		
		return queue.poll();
    }
}
class Num implements Comparable<Num> {
    int val;
    int idx;
    int p;

    public Num(int val, int idx, int p) {//val是这个num的值，idx是索引，p是primes中的值
        this.val = val;
        this.idx = idx;
        this.p = p;
    }
    @Override
    public int compareTo(Num that) {
        return this.val - that.val;
    }
}
