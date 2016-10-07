package ljt.bupt.leetcode.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;

public class CourseScheduleII_210 {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] res = findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(res));
	}

	private static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		LinkedList<Integer> queue = new LinkedList<>();
		//先根据prerequisites 产生入度数组
		int[] indegree = new int[numCourses];
		for(int i = 0 ; i< prerequisites.length ;i++){
			indegree[prerequisites[i][0]] += 1;
		}
		System.out.println(Arrays.toString(indegree));
		for(int i = 0 ; i< indegree.length ;i++){
			if(indegree[i] == 0){
				queue.offer(i);
			}
		}
		if(queue.isEmpty())
			return res;
		int count = 0 ;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res[count++] = cur;
			//更新cur为出度的节点的入度的值
			for(int i = 0 ; i< prerequisites.length ;i++){
				if(prerequisites[i][1] == cur){
					indegree[prerequisites[i][0]] -= 1;
					if(indegree[prerequisites[i][0]] ==0){
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}
		//queue现在为空，现在判断indegree是否全为0
		for(int i = 0 ; i < indegree.length ;i++){
			if(indegree[i]!=0)
				return new int[1];
		}
		return res;
	}

}
