import java.util.Comparator;
import java.lang.Math;

/*
 * Tomas Larson
 * ANodeComparator Class
 * 
 * Comparator for a PriorityQueue in A*1 Search.
 * Makes sure the PQ is sorted with the Node that has the 
 * lowest Manhattan distance and lowest distance to the goal is front of the queue.
 * 
 * Has a better h(n) than a*1
 */

public class A2NodeComparator implements Comparator<Node>{

	
	@Override
	public int compare(Node x, Node y) {
		
		char[] goal = "123804765".toCharArray();
		
		char[] xString = x.state.stateToString().replaceAll("\\s+","").toCharArray();
		char[] yString = y.state.stateToString().replaceAll("\\s+","").toCharArray();
		int xmDist = 0;
		int ymDist = 0;
		
		for (int i = 0; i < goal.length; i++) {
			int xdist = 0;
			int ydist = 0;
			
			for (int j = 0; j < goal.length; j++) {
				if (yString[j] == goal[i]) {
					ydist = Math.max(i, j)- Math.min(i, j);
					ymDist += ydist;
				}
				
				if (xString[j] == goal[i]) {
					xdist = Math.max(i, j)- Math.min(i, j);
					xmDist += xdist;
				}
					
			}
		}
		
		int xtotal = x.totalCost + xmDist;
		int ytotal = y.totalCost + ymDist;
		
		if (xtotal > ytotal) {
				return 1;
		} else if (xtotal < ytotal) {
			return -1;
		}
		return 0;
	}
}
