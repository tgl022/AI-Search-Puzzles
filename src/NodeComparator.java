import java.util.Comparator;
/*
 * Tomas Larson
 * NodeComparator Class
 * 
 * Comparator for a PriorityQueue in Uniform-Cost Search.
 * Makes sure the PQ is sorted with the Node that has the 
 * lowest total cost in front of the queue.
 * 
 */

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node x, Node y) {
		if (x.totalCost > y.totalCost) {
			return 1;
		} else if (x.totalCost < y.totalCost) {
			return -1;
		}
		return 0;
	}
}
