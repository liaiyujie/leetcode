package ljt.bupt.leetcode.bfs_dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CourseSchedule_207 {

	public static void main(String[] args) {
		int numCourses = 3;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 2, 1 } };
		boolean res = canFinish(numCourses, prerequisites);
		System.out.println(res);
	}

	// 这是一道图论的题目，考察的是拓扑排序。拓扑排序需要邻接表存储图。四年没用邻接表了，复习了下邻接表再来做的这个题目。
	// 拓扑排序的思路：
	// 入度为0的顶点入队列
	// 队列每出一个顶点，这个顶点所有边的另一头元素的入度减一。如果入度减到0了，入队列。
	// 循环第二步，直至队列为空。
	// 邻接表解法
	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		Edge[] edges = new Edge[numCourses];
		int[] indgree = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			edges[i] = new Edge(-1);

		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			Edge e = new Edge(edge[1]);
			int edgeHead = edge[0];
			e.next = edges[edgeHead].next;
			edges[edgeHead].next = e;

			indgree[edge[1]]++;
		}
		Queue<Integer> q = new ArrayDeque<Integer>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			if (indgree[i] == 0)
				q.add(i);
		}
		if (q.isEmpty())
			return false;

		while (!q.isEmpty()) {
			int ver = q.poll();
			visited[ver] = true;
			Edge head = edges[ver].next;
			while (head != null) {
				if (--indgree[head.num] == 0)
					q.add(head.num);
				head = head.next;
			}
		}

		boolean result = true;
		for (boolean v : visited)
			result &= v;
		return result;
	}

	// 用一个队列维护所有入度为0的节点，每次弹出一个节点v，查看从v可达的所有节点u;
	// 将u的入读减一，若u的入度此时为0, 则将u加入队列。
	// 在队列为空时，检查所有节点的入度，若所有节点入度都为0, 则存在这样的一个拓扑排序 —— 有向图中不存在环。
	// AC 52ms
	private static boolean canFinish2(int numCourses, int[][] prerequisites) {
		// 根据prerequisites 直接生成入度数组
		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			indegree[prerequisites[i][0]] += 1;
		}
		System.out.println(Arrays.toString(indegree));
		// 入度的数组indegree建立完成，现在检索里面为零的元素
		int countR = 0;
		do {
			int countZ = 0;
			for (int i = 0; i < numCourses; i++) {
				if (indegree[i] == 0) {
					// i的入度为0，现在去更新i指向的节点的入度
					countR++;
					countZ++;
					for (int j = 0; j < prerequisites.length; j++) {
						if (prerequisites[j][1] == i) {
							indegree[prerequisites[j][0]] -= 1;
						}
					}
					indegree[i] = Integer.MAX_VALUE;
				}
			}
			if (countZ == 0) {
				return false;
			}

		} while (countR < numCourses);

		if (countR == numCourses) {
			return true;
		}
		return false;
	}

	// 自己创建了一个邻接矩阵，超时了
	// 这是判断一幅图是否含有环，可以用拓扑排序来解
	//邻接矩阵解法
	private static boolean canFinish1(int numCourses, int[][] prerequisites) {
		// 先将prerequisites 转化为一幅图的邻接矩阵
		int[][] matri = new int[numCourses][numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int col = prerequisites[i][0];// 纵坐标
			int row = prerequisites[i][1];// 横坐标
			matri[row][col] = 1;
		}
		// 邻接矩阵matri建立完成，现在需要一个表示入度的数组indegree[]
		// matri的每一列的和为该点的入度
		int[] indegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			int sum = 0;
			for (int j = 0; j < numCourses; j++) {
				sum += matri[j][i];
			}
			indegree[i] = sum;
		}
		// 入度的数组indegree建立完成，现在检索里面为零的元素
		int countR = 0;
		do {
			int countZ = 0;
			for (int i = 0; i < numCourses; i++) {
				if (indegree[i] == 0) {
					// i的入度为0，现在去更新i指向的节点的入度
					countR++;
					countZ++;
					for (int j = 0; j < numCourses; j++) {
						if (matri[i][j] == 1) {
							indegree[j]--;
						}
					}
					indegree[i] = Integer.MAX_VALUE;
				}
			}
			if (countZ == 0) {
				return false;
			}

		} while (countR < numCourses);
		if (countR == numCourses) {
			return true;
		}
		return false;
	}

}

class Edge {
	public Edge(int n) {
		num = n;
	}

	public int num;
	public Edge next = null;
}