package leetcode.thirtyday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class InefficientMinimumPathSum {
	public int minPathSum(int[][] grid) {
		int minCost = Integer.MAX_VALUE;

		int destX = grid.length - 1;
		int destY = grid[0].length - 1;

		Queue<Cell_MPS> q = new LinkedList<>();
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };
		Cell_MPS c = new Cell_MPS(grid[0][0], 0, 0);
		q.add(c);

		HashSet<Cell_MPS> isVisited = new HashSet<Cell_MPS>();
		isVisited.add(c);

		while (!q.isEmpty()) {
			Cell_MPS curr = q.remove();
			if (curr.dist > minCost) {
				continue;
			} else if (curr.x == destX && curr.y == destY && curr.dist < minCost) {
				minCost = curr.dist;
			} else {

				for (int[] is : dirs) {
					int nextX = curr.x + is[0];
					int nextY = curr.y + is[1];
					if (isValid(grid.length, grid[0].length, nextX, nextY)) {
						Cell_MPS nextC = new Cell_MPS(curr.dist + grid[nextX][nextY], nextX, nextY);
						if (!isVisited.contains(nextC)) {
							isVisited.add(nextC);
							q.add(nextC);
						}
					}
				}
			}
		}

		return minCost;
	}

	private boolean isValid(int rangeX, int rangeY, int x, int y) {
		return x >= 0 && y >= 0 && x < rangeX && y < rangeY;
	}

	public static void main(String[] args) {

//		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
//		int[][] grid = new int[][] { { 1, 2 }, { 1, 1 } };
		int[][] grid = new int[][] { { 1, 2 }, { 1, 1 } };
		
//		int[][] grid = new int[][] { { 1, 4, 8, 6, 2, 2, 1, 7 }, { 4, 7, 3, 1, 4, 5, 5, 1 }, { 8, 8, 2, 1, 1, 8, 0, 1 },
//				{ 8, 9, 2, 9, 8, 0, 8, 9 }, { 5, 7, 5, 7, 1, 8, 5, 5 }, { 7, 0, 9, 4, 5, 6, 5, 6 },
//				{ 4, 9, 9, 7, 9, 1, 9, 0 } };
		System.out.println(new InefficientMinimumPathSum().minPathSum(grid));
	}
	
	
}

class Cell_MPS {
	int dist;
	int x;
	int y;

	public Cell_MPS(int dist, int x, int y) {
		this.dist = dist;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + "][" + y + "] : [" + dist + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Cell_MPS c = (Cell_MPS) obj;

		return c.x == this.x && c.y == this.y && c.dist == this.dist;
	}

	@Override
	public int hashCode() {
		String s = this.x + " " + this.y + " " + this.dist;
		return s.hashCode();
	}

}
