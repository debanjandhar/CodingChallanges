package leetcode.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	class Cell {
		int x;
		int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		Queue<Cell> q = new LinkedList<>();

		if (image.length == 0) {
			return image;
		}

		boolean[][] visited = new boolean[image.length][image[0].length];
		q.add(new Cell(sr, sc));
		visited[sr][sc] = true;
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		int oldColor = image[sr][sc];

		while (!q.isEmpty()) {
			Cell currCell = q.remove();

			image[currCell.x][currCell.y] = newColor;

			for (int[] is : dirs) {
				int newX = currCell.x + is[0];
				int newY = currCell.y + is[1];

				if (isValid(newX, newY, image.length, image[0].length) && !visited[newX][newY]
						&& image[newX][newY] == oldColor) {
					visited[newX][newY] = true;
					q.add(new Cell(newX, newY));
				}
			}

		}

		return image;
	}

	private boolean isValid(int x, int y, int xRange, int yRange) {
		return x >= 0 && x < xRange && y >= 0 && y < yRange;
	}

	private void print(int[][] arr) {
		System.out.println("Printing new 2-D array...");
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

	public static void main(String[] args) {
		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		FloodFill f = new FloodFill();

		f.print(image);
		f.print(f.floodFill(image, 1, 1, 2));

	}
}
