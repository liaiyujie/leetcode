package ljt.bupt.leetcode.greedy;

import java.util.Arrays;

public class QueueReconstructionbyHeight_406 {

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] res = reconstructQueue(people);
		for (int i = 0; i < people.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}

	// 贪心思想  AC 88ms
	//有点像邹博介绍的由康拓数组还原出原来的数似的。每一次从数组中找出k==0 且h最小的元素作为当前元素。
	//并且找到这个元素后，遍历整个数组，将没有确定的并且h小于等于刚刚找出来的h对应的k减一
	//{ 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 }
	//找的过程---{7,0}{5,0}选h小的{5,0}，并将整个数组h小于等于5的k减一得到
	//{ 7, 0 }, { 4, 3 }, { 7, 1 },  { 6, 1 }, { 5, 1 }   选{7,0}
	// { 4, 2 }, { 7, 0 },  { 6, 0 }, { 5, 0 }  选{5,0}
	//{ 4, 1 }, { 7, 0 },  { 6, 0 }  选{6,0}
	//{4,0}，{7,0} 选{4,0}
	//{7,0}  选{7,0}
	private static int[][] reconstructQueue(int[][] people) {
		int[][] tmp = new int[people.length][2];
		for(int i = 0 ; i< people.length ;i++){
			for(int j = 0 ; j< 2; j++){
				tmp[i][j] = people[i][j];
			}
		}
		
		int[][] res = new int[people.length][2];
		boolean[] used = new boolean[people.length];
		
		for (int i = 0; i < tmp.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = Integer.MAX_VALUE;
			for(int j = 0 ; j< tmp.length ;j++){
				if(tmp[j][1] == 0&&used[j]==false){
					if(tmp[j][0]<min){
						min = tmp[j][0];
						minIndex = j;
					}
				}
			}
			used[minIndex] = true;
			res[i] = new int[]{min,people[minIndex][1]};
			//找到了一个为people[j][1]==0的点，然后遍历这个people，将所有的people[j][0] 小于之前的数都减一
			int t = tmp[minIndex][0];
			for(int j = 0 ; j< tmp.length ;j++){
				if(tmp[j][0] <= t &&used[j]==false){
					tmp[j][1]--;
				}
			}
		}
		return res;
	}

	// 贪心思想, 下面的算法错误，没想清楚，得不出答案
	private static int[][] reconstructQueue1(int[][] people) {
		int[][] res = new int[people.length][2];
		boolean[] used = new boolean[people.length];
		for (int i = 0; i < people.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = Integer.MAX_VALUE;
			for (int j = 0; j < people.length; j++) {
				if(people[j][1]<=i&&used[j]==false){
					if(people[j][0]<min){
						min = people[j][0];
						minIndex = j;
					}
				}
			}
			used[minIndex] = true;
			res[i] = new int[]{min,people[minIndex][1]};
		}
		return res;
	}

}
