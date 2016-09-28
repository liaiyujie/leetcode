package ljt.bupt.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestElementinaSortedMatrix_378 {

	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{9,11,13},{12,13,15}};
		int k = 4;
		int res = kthSmallest(matrix, k);
		System.out.println(res);
	}

	private static int kthSmallest(int[][] matrix, int k) {//简短好理解，不过没有考虑矩阵的排序情况，矩阵是乱序的情况也可以
		//创建一个从小到大的优先队列,java的优先队列默认是队头是最小值
		 PriorityQueue<Integer> pq= new PriorityQueue<>(k, Collections.reverseOrder());
//		PriorityQueue<Integer> pq= new PriorityQueue<>(k, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 -o1;
//			}
//		});    
		    for(int i=0;i<matrix.length;i++){
		        for(int j=0;j<matrix[0].length;j++){
		            if(pq.size()<k)
		                pq.add(matrix[i][j]);
		            else{
		                int temp=pq.peek();
		                if(temp>matrix[i][j]){
		                    pq.poll();
		                    pq.offer(matrix[i][j]);
		                }
		            }
		        }
		    }
		    return pq.poll();
	}

	private static int kthSmallest2(int[][] matrix, int k) {//自己写的，不怎么好，参考上一个人写的
		int len = matrix[0].length;
		Number[][] num = new Number[len][len];
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j< matrix[i].length ; j++){
				num[i][j] = new Number(matrix[i][j],i,j);
			}
		}
		
		PriorityQueue<Number> queue = new PriorityQueue<>();
		Set<Number> set = new HashSet<>();
		queue.add(num[0][0]);
		set.add(num[0][0]);
		Number n = null;
		while(k>0){
			n = queue.poll();
			int x = n.x;
			int y = n.y;
			if(x+1<num.length&&y+1<num.length){
				if(!set.contains(num[x+1][y])){
					queue.add(num[x+1][y]);
					set.add(num[x+1][y]);
				}
				if(!set.contains(num[x][y+1])){
					queue.add(num[x][y+1]);
					set.add(num[x][y+1]);
				}
			}else if(x+1>=num.length&&y+1<num.length){
				if(!set.contains(num[x][y+1])){
					queue.add(num[x][y+1]);
					set.add(num[x][y+1]);
				}
			}else if(x+1<num.length&&y+1>=num.length){
				if(!set.contains(num[x+1][y])){
					queue.add(num[x+1][y]);
					set.add(num[x+1][y]);
				}
			}else{
				//do nothing
			}
			k--;
		}
		return n.val;
	}

	private static int kthSmallest1(int[][] matrix, int k) {//沒有利用數列的排序特性
		int len = matrix[0].length*matrix[0].length;
		int[] nums = new int[len];
		int count = 0;
		for(int i = 0 ;i<matrix.length ; i++){
			for(int j = 0 ;j<matrix[i].length;j++){
				nums[count++] = matrix[i][j];
			}
		}
		Arrays.sort(nums);
		
		return nums[k-1];
	}

}
class Number implements Comparable{
	int val ;
	int x;
	int y;
	public Number(int val, int x, int y) {
		super();
		this.val = val;
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		if (val != other.val)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	@Override
	public int compareTo(Object o) {
		Number n = (Number)o;
		return this.val - n.val;
	}
}
