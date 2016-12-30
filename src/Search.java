import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
/*
 * Tomas Larson
 * Search Class
 * 
 * Contains all the search methods, their successor funstions, and some utility functions
 * 
 */

public class Search {
	State goal = new State(1,2,3,8,0,4,7,6,5);
	State hard = new State(5,6,7,4,0,8,3,2,1);
	State easy = new State(1,3,4,8,6,2,7,0,5);
	State medium = new State(2,8,1,0,4,3,7,6,5);
	
	public Search() {
		
	}
	
	//BREDTH FIRST SEARCH
	//**********************************************************
	public void bfSearch(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		ArrayList<Node> nodeQueue = new ArrayList<Node>();
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeQueue.add(root);
			
		while(!nodeQueue.isEmpty() && !goalSet) {
			if (nodeQueue.size() > max) 
				max = nodeQueue.size();
			Node n = nodeQueue.remove(0);
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				bfSuccessor(n, nodeQueue, testedStates);
			} else {
				goal = n;
				goalSet = true;
			
			}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
	
	//Successor to bfSerch(). Adds valid successor nodes to nodeQueue.
	public void bfSuccessor(Node cur, ArrayList<Node> nodeQueue, HashSet<String> testedStates) {
		ArrayList<State> stateList = getSucStates(cur.state, testedStates);
		for (State s : stateList) {
			testedStates.add(s.stateToString());
			Node n = new Node(cur, s, cur.totalCost);
			cur.addChild(n);
			nodeQueue.add(n);
		}
	}
	//DEPTH FIRST SEARCH
	//**********************************************************
	public void dfSearch(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		ArrayList<Node> nodeStack = new ArrayList<Node>();
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeStack.add(root);
	
		while(!nodeStack.isEmpty() && !goalSet) {
			if (nodeStack.size() > max) 
				max = nodeStack.size();
			Node n = nodeStack.remove(0);
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				dfSuccessor(n, nodeStack, testedStates);
			} else {
				goal = n;
				goalSet = true;
			}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
	
	//Successor to dfSerch(). Adds valid successor nodes to nodeStack.
	public void dfSuccessor(Node cur, ArrayList<Node> nodeStack, HashSet<String> testedStates) {
		ArrayList<State> stateList = getSucStates(cur.state, testedStates);
		for (State s : stateList) {
			testedStates.add(s.stateToString());
			Node n = new Node(cur, s, cur.totalCost);
			cur.addChild(n);
			nodeStack.add(0, n);
		}
	}
	
	//UNIFORM-COST SEARCH
	//**********************************************************
	public void ucSearch(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		Comparator<Node> comp = new NodeComparator();
		PriorityQueue<Node> nodeStack = new PriorityQueue<Node>(comp);
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeStack.add(root);
	
		while(!nodeStack.isEmpty() && !goalSet) {
			if (nodeStack.size() > max) 
				max = nodeStack.size();
			Node n = nodeStack.poll();
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				pqSuccessor(n, nodeStack, testedStates);
			} else {
				goal = n;
				goalSet = true;
				
			}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
	
	
	//BEST FIRST SEARCH
	//**********************************************************
	public void bestfSearch(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		Comparator<Node> comp = new BFNodeComparator();
		PriorityQueue<Node> nodeStack = new PriorityQueue<Node>(comp);
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeStack.add(root);
	
		while(!nodeStack.isEmpty() && !goalSet) {
			if (nodeStack.size() > max) 
				max = nodeStack.size();
			Node n = nodeStack.poll();
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				pqSuccessor(n, nodeStack, testedStates);
			} else {
				goal = n;
				goalSet = true;
					
				}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
	
	
	//A* SEARCH
	//**********************************************************
	public void aSearch(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		Comparator<Node> comp = new ANodeComparator();
		PriorityQueue<Node> nodeStack = new PriorityQueue<Node>(comp);
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeStack.add(root);
	
		while(!nodeStack.isEmpty() && !goalSet) {
			if (nodeStack.size() > max) 
				max = nodeStack.size();
			Node n = nodeStack.poll();
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				pqSuccessor(n, nodeStack, testedStates);
			} else {
				goal = n;
				goalSet = true;
				
			}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
	
	//A*2 SEARCH
	//**********************************************************
	public void a2Search(State difficulty) {
		Node root = new Node(null, difficulty, 0);
		Comparator<Node> comp = new A2NodeComparator();
		PriorityQueue<Node> nodeStack = new PriorityQueue<Node>(comp);
		HashSet<String> testedStates = new HashSet<String>();
		Node goal = new Node();
		boolean goalSet = false;
		int nodesVisited = 0;
		int max = 0;
		nodeStack.add(root);
	
		while(!nodeStack.isEmpty() && !goalSet) {
			if (nodeStack.size() > max) 
				max = nodeStack.size();
			Node n = nodeStack.poll();
			testedStates.add(n.state.stateToString());
			nodesVisited++;
			if (!goalTest(n)) {
				pqSuccessor(n, nodeStack, testedStates);
			} else {
				goal = n;
				goalSet = true;
						
			}
		}
		System.out.println();
		if (goalSet) goalTrace(goal, nodesVisited, max);
		else System.out.println("No goal nodes found.");
	}
		
	
	//GENERAL SEARCH TOOLS
	//**********************************************************
	
	//Successor to all PriorityQueue users. Adds valid successor nodes to nodeStack.
	//The different computations are done at insertion to the PQ. This is done with different Comparator 
	//Objects. Each algorithm has its own Comparator class.
	public void pqSuccessor(Node cur, PriorityQueue<Node> nodeStack, HashSet<String> testedStates) {
		ArrayList<State> stateList = getSucStates(cur.state, testedStates);
		for (State s : stateList) {
			testedStates.add(s.stateToString());
			Node n = new Node(cur, s, cur.totalCost);
			cur.addChild(n);
			nodeStack.add(n);
		}
	}

	//Traces the goal back to the root and prints out every node in between.
	//At the end Max queue size, Length, and Total Nodes Visited are printed as well.
	public void goalTrace(Node cur, int nodesVisited, int max) {
		Node temp = cur;
		ArrayList<Node> goalList = new ArrayList<Node>();
		int length = 0;
		while (temp.parent != null) {
			goalList.add(0, temp);
			temp = temp.parent;
		}
		goalList.add(0, temp);
			
		for (Node n : goalList) {
			n.nodePrint();
			length++;
		}
		System.out.println("Total Nodes Visited: " + nodesVisited + " Length: " + length);
		System.out.println("Max length: " + max);
	}
	
	
	//Simple Test to see if the passed nodes state matches the goal state.
	public boolean goalTest(Node cur) {
		if (cur.state.tiles.equals(goal.tiles))
			return true;
		return false;
	}
		
	//Utility function for the Successors. Tests all moves on a state to see if they are valid.
	//Valid moves are the check to see if they are in the HashSet of all tested States.
	//If the state is not in the HashSet it is added to the state list and sent back to the
	//successor function to determine how it will be placed in its data structure.
	public ArrayList<State> getSucStates(State s, HashSet<String> testedStates) {
		ArrayList<State> newStates = new ArrayList<State>();
		
		for (int dir = 0; dir <= 4; dir ++) {
			State copyState = new State(s);
			
			String blank = copyState.getBlank();
			String swap = copyState.getSwap(blank, dir);
			
			if (!swap.equals("invalid")) {
				int swapValue = copyState.tiles.get(swap);
				copyState.setCost(swapValue);
				copyState.setDirection(dir);
				copyState.tiles.put(blank, swapValue);
				copyState.tiles.put(swap, 0);
				if (!testedStates.contains(copyState.stateToString())) {
					newStates.add(copyState);
				}
			}	
		}
		return newStates;
	}	
}
