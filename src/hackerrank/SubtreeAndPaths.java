package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author debanjandhar
 * 
 * Incomplete due to insufficient question description. 
 *
 */
public class SubtreeAndPaths {

	static void performOperation(int[][] graph, String[] queries) {
		int[] weights = new int[graph.length];
		boolean[] isVisited;

		for (String query : queries) {
			String[] operands = query.split(" ");
			switch (operands[0]) {
			case "add":
				addWeightSubtree(Integer.parseInt(operands[1]), Integer.parseInt(operands[2]), graph, weights);
				break;
			case "max":
				int a = Integer.parseInt(operands[1]);
				isVisited = new boolean[graph.length];
				Queue<TraverseNode> q = new LinkedList<TraverseNode>();
				q.add(new TraverseNode(a, weights[a]));
				isVisited[a] = true; 

				System.out.println(findMaxWtBtwnRoutes(q, Integer.parseInt(operands[2]), graph, weights, isVisited));
			}
		}
	}

	private static int findMaxWtBtwnRoutes(Queue<TraverseNode> q, int dest, int[][] graph, int[] weights, boolean[] isVisited) {
		if (q.isEmpty()) {
			return -1;
		}

		TraverseNode currentNode = q.remove();

		if (currentNode.nodeId == dest) {
			return currentNode.maxWeight;
		}

		for (int i = 1; i < graph.length; i++) {
			if (!isVisited[i] && graph[currentNode.nodeId][i] == 1) {
				TraverseNode tn = new TraverseNode(i);
				if (currentNode.maxWeight >= weights[i]) {
					tn.maxWeight = currentNode.maxWeight;
				} else {
					tn.maxWeight = weights[i];
				}
				
				isVisited[i] = true;
				q.add(tn);
			}
		}

		return findMaxWtBtwnRoutes(q, dest, graph, weights, isVisited);
	}

	private static void addWeightSubtree(int nodeId, int weight, int[][] graph, int[] weights) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(nodeId);

		weights[nodeId] += weight;

		while (!q.isEmpty()) {
			int currNode = q.remove();

			for (int i = currNode + 1; i < weights.length; i++) {
				if (graph[currNode][i] == 1) {
					weights[i] += weight;
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfEdges = Integer.parseInt(br.readLine());
		int[][] graph = new int[numOfEdges + 1][numOfEdges + 1];

		for (int i = 0; i < numOfEdges - 1; i++) {
			String[] inputNode = br.readLine().split(" ");
			int a = Integer.parseInt(inputNode[0]);
			int b = Integer.parseInt(inputNode[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		int numQueries = Integer.parseInt(br.readLine());
		String[] queries = new String[numQueries];
		for (int i = 0; i < numQueries; i++) {
			queries[i] = br.readLine();
		}

		performOperation(graph, queries);

	}
}

class TraverseNode {
	public int nodeId;
	public int maxWeight;

	public TraverseNode(int nodeId) {
		this.nodeId = nodeId;
		this.maxWeight = 0;
	}

	public TraverseNode(int nodeId, int maxWeight) {
		this.nodeId = nodeId;
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return nodeId + ", " + maxWeight;
	}
}