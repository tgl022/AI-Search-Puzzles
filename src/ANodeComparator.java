import java.util.Comparator;

/*
 * Tomas Larson
 * ANodeComparator Class
 * 
 * Comparator for a PriorityQueue in A*1 Search.
 * Makes sure the PQ is sorted with the Node that has the 
 * highest similarity and lowest distance to the goal is front of the queue.
 * 
 * This heuristic does not worth well with its g(n) however.
 * Since you want a lower cost and a higher similarity.
 * h(n) + g(n) is not a way to optimize performance. 
 * 
 * This is why I decided to subtract h(n) from g(n)
 * The solution I got with this formula was much better.
 * 
 */

public class ANodeComparator implements Comparator<Node>{

	
	@Override
	public int compare(Node x, Node y) {
		
		char[] goal = "123804765".toCharArray();
		
		char[] xString = x.state.stateToString().replaceAll("\\s+","").toCharArray();
		char[] yString = y.state.stateToString().replaceAll("\\s+","").toCharArray();
		int xSimilar = 0;
		int ySimilar = 0;
		
		for (int i = 0; i < goal.length; i++) {
			if (xString[i] == goal[i]) 
				 xSimilar++;
			if (yString[i] == goal[i])
				ySimilar++;
		}
		
		int xtotal = x.totalCost -xSimilar;
		int ytotal = y.totalCost -ySimilar;
		
		if (xtotal > ytotal) {
				return 1;
		} else if (xtotal < ytotal) {
			return -1;
		}
		return 0;
	}
}
