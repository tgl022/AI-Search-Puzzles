import java.util.ArrayList;
/*
 * Tomas Larson
 * Node Class
 * 
 * Contains a State object, Array of children, and a parent Node.
 * holds a total cost of all its parents and itself
 * 
 */

public class Node {

	Node parent;
	int depth = 0;
	int totalCost;
	Boolean exp = true;
	ArrayList<Node> childNodes = new ArrayList<Node>();
	
	//Direction of the previous move up=1, dn=2, l=3, r=4.
	int direction;
	State state;
	
	public Node() {
		
	}
	
	//Node constructor
	//adds the previous totalCost to the current Node.state.cost
	public Node(Node p, State rstate, int tc) {
		parent = p;
		state = new State(rstate);
		totalCost = tc + state.cost;
	}
		
	//Add a child not to the childNodes ArrayList
	public void addChild(Node n) {
		childNodes.add(n);
	}
	
	//Prints the Node
	public void nodePrint() {
		state.printState();
		System.out.println("Direction: " + state.direction + ", Cost: " + state.cost + 
				" Total Cost: " + totalCost +"\n");
	}
}
