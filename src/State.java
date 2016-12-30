import java.util.HashMap;

/*
 * Tomas Larson
 * State Class
 * 
 * Holds the state of the puzzle in the tiles HashMap
 * also stores the cost of the previous move and the direction of that move.
 */


public class State {

	HashMap<String, Integer> tiles;
	int cost;
	
	//Direction of the previous move up=1, dn=2, l=3, r=4.
	int direction;
	
	public State() {
		tiles = new HashMap<String, Integer>();
	}
	
	//Constructor of initializing States from user input or hardcoded integers
	public State(int tr, int tm, int tl, 
			int mr, int mm, int ml, 
			int br, int bm, int bl) {
				
		tiles = new HashMap<String, Integer>();
		
		tiles.put("topLeft", tr);
		tiles.put("topMid", tm);
		tiles.put("topRight", tl);
		tiles.put("midLeft", mr);
		tiles.put("midMid", mm);
		tiles.put("midRight", ml);
		tiles.put("botLeft", br);
		tiles.put("botMid", bm);
		tiles.put("botRight", bl);
		
		cost = 0;
		direction = -1;
		
	}
	
	//State deep-copy constructor
	public State(State s) {
		tiles = new HashMap<String, Integer>();
		
		tiles.put("topLeft", s.tiles.get("topLeft"));
		tiles.put("topMid", s.tiles.get("topMid"));
		tiles.put("topRight", s.tiles.get("topRight"));
		tiles.put("midLeft", s.tiles.get("midLeft"));
		tiles.put("midMid", s.tiles.get("midMid"));
		tiles.put("midRight", s.tiles.get("midRight"));
		tiles.put("botLeft", s.tiles.get("botLeft"));
		tiles.put("botMid", s.tiles.get("botMid"));
		tiles.put("botRight", s.tiles.get("botRight"));
		
		cost = s.cost;
		direction = s.direction;
	}
	
	//State comparator
	public boolean equals(State s) {
		return tiles.equals(s.tiles);
	}
	
	//Function that moves a state in a certain direction
	//NOT USED IN THIS PROJECT
	public void shift(int direction) {
		String blank = getBlank();
		String swap = getSwap(blank, direction);
		if (!swap.equals("invalid")) {
			int swapValue = tiles.get(swap);
			tiles.put(blank, swapValue);
			tiles.put(swap, 0);			
		}	
		else return;
		
	}
	
	//Returns the 'location' on the game board of the blank tiles or '0 tile'
	public String getBlank() {
		if (tiles.get("topRight") == 0)
			return "topRight";
		else if (tiles.get("topMid") == 0)
			return "topMid";
		else if (tiles.get("topLeft") == 0)
			return "topLeft";
		else if (tiles.get("midRight") == 0)
			return "midRight";
		else if (tiles.get("midMid") == 0)
			return "midMid";
		else if (tiles.get("midLeft") == 0)
			return "midLeft";
		else if (tiles.get("botRight") == 0)
			return "botRight";
		else if (tiles.get("botMid") == 0)
			return "botMid";
		else if (tiles.get("botLeft") == 0)
			return "botLeft";
		return "";
	}
	
	
	//Function that returns the location of the tile next to the blank tile
	//in a certain direction. Returns 'invald' if a move cannot be made in the direction passed.
	public String getSwap(String blank, int dir) {
		//Direction of the previous move up=1, dn=2, l=3, r=4
		String swap = "";
		if (blank == "topLeft"){
			if (dir == 2) swap = "midLeft";
			else if (dir == 4) swap = "topMid";
			else swap = "invalid";
		}	
		else if (blank == "topMid") {
			if (dir == 2) swap = "midMid";
			else if (dir == 3) swap = "topLeft";
			else if (dir == 4) swap = "topRight";
			else swap = "invalid";

		}
		else if (blank == "topRight") {
			if (dir == 2) swap = "midRight";
			else if (dir == 3) swap = "topMid";
			else swap = "invalid";
		}
		else if (blank == "midLeft") {
			if (dir == 2) swap = "botLeft";
			else if (dir == 4) swap = "midMid";
			else if (dir == 1) swap = "topLeft";
			else swap = "invalid";
		}
		else if (blank == "midMid") {
			if (dir == 1) swap = "topMid";
			else if (dir == 2) swap = "botMid";
			else if (dir == 3) swap = "midLeft";
			else if (dir == 4) swap = "midRight";
			else swap = "invalid";
		}
		else if (blank == "midRight") {
			if (dir == 1) swap = "topRight";
			else if (dir == 2) swap = "botRight";
			else if (dir == 3) swap = "midMid";
			else swap = "invalid";
		}
		else if (blank == "botLeft") {
			if (dir == 1) swap = "midLeft";
			else if (dir == 4) swap = "botMid";
			else swap = "invalid";
		}
		else if (blank == "botMid") {
			if (dir == 1) swap = "midMid";
			else if (dir == 3) swap = "botLeft";
			else if (dir == 4) swap = "botRight";
			else swap = "invalid";
		}
		else if (blank == "botRight") {
			if (dir == 1) swap = "midRight";
			else if (dir == 3) swap = "botMid";
			else swap = "invalid";
		}
		
		return swap;
	}
	
	//Turns a State into a String
	//Spaces for readability.
	public String stateToString() {
		return "" + tiles.get("topLeft") + " " +
				   tiles.get("topMid") + " " + 
				   tiles.get("topRight") + " " +
				   tiles.get("midLeft") + " " +
				   tiles.get("midMid") + " " +
				   tiles.get("midRight") + " " +
				   tiles.get("botLeft") + " " +
				   tiles.get("botMid") + " " +
				   tiles.get("botRight");
	}
	
	//Prints the State String
	public void printState() {
		System.out.println(stateToString());
		//System.out.println(cost);
	}
	
	//Set the cost of previous move
	public void setCost(int c) {
		cost = c;
	}
	
	//set the direction of previous move
	public void setDirection(int d) {
		direction = d;
	}
	

}
