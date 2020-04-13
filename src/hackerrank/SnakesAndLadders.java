package hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/the-quickest-way-up/problem
 * 
 */
public class SnakesAndLadders {

	// Complete the quickestWayUp function below.
	private static int quickestWayUp(int[][] ladders, int[][] snakes) {
		
		List<Integer> visited  = new ArrayList<Integer>();
		Queue<Cell> cellQueue = new LinkedList<Cell>();

		cellQueue.add(new Cell(1));
		visited.add(1);

		return quickestWayUp(ladders, snakes, cellQueue, visited);
	}

	private static int quickestWayUp(int[][] ladders, int[][] snakes, Queue<Cell> queue, List<Integer> visited) {
		
		// No path possible if queue is empty. 
		if (queue.peek() == null) {
			return -1;
		}
		
		Cell currentCell = queue.remove();

		// We will start with maximum dice roll and keep reducing by 1, if the next cell
		// is not valid.
		int diceRoll = 6;
		int nextCellId = currentCell.getCellId() + diceRoll;
		
		// Check if we have reached destination i.e 100
		if (currentCell.getCellId() == 100) {
			// Since we are at destination, so we don't have to roll a dice here. 
			return currentCell.getLength();
		}else if ((100 - currentCell.getCellId()) <= 6) {
			// Increasing counter for current roll. 
			return currentCell.getLength()+1;
		}
		
		// Check if we have any cell with ladder before we role 6
		List<Integer> nextLadderCellIds = getNextSnakesOrLadderCells(currentCell.getCellId(), currentCell.getCellId()+diceRoll, ladders, visited); 
		
		if (nextLadderCellIds.size() != 0) {
			// Add ladder cell to queue
			for(Integer cellId : nextLadderCellIds) {
				addToQueue(queue, visited, new Cell(cellId, currentCell.getLength()+1));
			}
		}

		List<Integer> nextSnakesCellIds = getNextSnakesOrLadderCells(currentCell.getCellId(), currentCell.getCellId()+diceRoll, snakes, visited); 
		
		if (nextSnakesCellIds.size() != 0) {
			// Add ladder cell to queue
			for(Integer cellId : nextSnakesCellIds) {
				
				addToQueue(queue, visited, new Cell(cellId, currentCell.getLength()+1));
			}
		}

		while (diceRoll != 0) {
			if (addToQueue(queue, visited, new Cell(nextCellId, currentCell.getLength()+1))) {
				break;
			}
			
			diceRoll--;
		}

		return quickestWayUp(ladders, snakes, queue, visited);
	}

	private static boolean addToQueue(Queue<Cell> queue, List<Integer> visited, Cell inputCell) {
		// If we have not visited this cell before. 
		if (!visited.contains(inputCell.getCellId())) {
			visited.add(inputCell.getCellId());
			queue.add(inputCell);
			return true;
		}
		
		return false;
	}
	
	// This function returns destination cell id if ladder/snakes is present in between first and second cell, else returns
	// -1. If multiple ladders are present then returns the ladder with maximum length.  
	// Also it marks the source of ladder/snake as visited.
	private static List<Integer> getNextSnakesOrLadderCells(int firstCellId, int secondCellId, int[][] laddersOrSnakes, List<Integer>visited) {
		int numElements = laddersOrSnakes.length;
		List<Integer> output = new ArrayList<Integer>();
		for(int i=0; i<numElements;i++) {
			// Check if a ladder is in between first and second cell. 
			if (laddersOrSnakes[i][0] > firstCellId && laddersOrSnakes[i][0] <= secondCellId) {
				visited.add(laddersOrSnakes[i][0]);
				output.add(laddersOrSnakes[i][1]);
			}
		}
		
		return output;
	}


	public static void main(String[] args) throws IOException {

			
//			Ans 3
//			int[][] ladders = {{32, 62},{42, 68},{12, 98}};
//			int[][] snakes = {{95, 13},{97, 25},{93, 37},{79, 27},{75, 19},{49, 47},{67, 17}};
		
// 			Ans 5
//			int[][] ladders = {{8, 52},{6, 80},{26, 42},{2,72}};
//			int[][] snakes = {{51, 19},{39, 11},{37, 29},{81,3},{59,5},{79, 23},{53, 7},{43, 33},{77, 21}};

//			Ans 3
//			int[][] ladders = {{3, 54},{37, 100}};
//			int[][] snakes = {{56,33}};

//			Ans 2
//			int[][] ladders = {{3, 57},{8, 100}};
//			int[][] snakes = {{88,44}};
			
//			Ans 2
//			int[][] ladders = {{7, 98}};
//			int[][] snakes = {{99,1}};
		
//			Ans -1
			int[][] ladders = {{3, 90}};
			int[][] snakes = {{99, 10},{97, 20},{98,30},{96, 40},{95, 50},{94, 60},{93, 70}};
		
			int result = quickestWayUp(ladders, snakes);
			System.out.println(result);
	}
}

class Cell {
	int cellId;
	int length;

	public Cell(int cellId, int length) {
		this.cellId = cellId;
		this.length = length;
	}

	public Cell(int cellId) {
		this.cellId = cellId;
		this.length = 0;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cell) {
			Cell otherCell = (Cell) obj;
			return this.getCellId() == otherCell.getCellId();
		}else {
			return super.equals(obj);
		}
	}
}
