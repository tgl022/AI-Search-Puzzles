import java.util.Comparator;

/*
 * Tomas Larson
 * BFNodeComparator Class
 * 
 * Comparator for a PriorityQueue in Best-First Search.
 * Makes sure the PQ is sorted with the Node that has the 
 * highest similarity to the goal is front of the queue.
 * 
 */

public class BFNodeComparator implements Comparator<Node>{

	
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
		
		if (xSimilar > ySimilar) {
			return -1;
		} else if (xSimilar < ySimilar) {
			return 1;
		}
		return 0;
	}
}
