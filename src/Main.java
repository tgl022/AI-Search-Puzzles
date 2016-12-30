import java.util.Scanner;
/*
 * Tomas Larson
 * Main Class
 * 
 * Runs from this function.
 * Contains all the UI code and Search Object.
 * 
 */

public class Main {

	//Main Function
	public static void main(String[] args){
		
		State hard = new State(5,6,7,4,0,8,3,2,1);
		State easy = new State(1,3,4,8,6,2,7,0,5);
		State medium = new State(2,8,1,0,4,3,7,6,5);
		
		boolean cont = true;
		
		State difState = easy;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello, human.");
		
		while (cont) {
		
		System.out.println("Please enter the difficulty you would like to set the puzzle state to.");
		System.out.println("Enter a '!' to kill the program.");
		String dif = in.next().toLowerCase();
		
		if (dif.equals("easy"))
			difState = easy;
		else if (dif.equals("medium"))
			difState = medium;
		else if (dif.equals("hard"))
			difState = hard;
		else if (dif.equals("!"))
			break;
		System.out.println();
		System.out.println("Please enter the algorithm you would like to run.");
		System.out.println("Type 'bf', 'df', 'uc', 'bestf', 'a*1' or 'a*2' ");
		System.out.println("or enter 'all' to run them all.");
		System.out.println("Enter a '!' to kill the program.");
		dif = in.next().toLowerCase();
		
		System.out.println("Running " + dif + "...");
		
		Search s = new Search();
		
		if (dif.equals("bf"))
			s.bfSearch(difState);
		else if (dif.equals("df"))
			s.dfSearch(difState);
		else if (dif.equals("uc"))
			s.ucSearch(difState);
		if (dif.equals("bestf"))
			s.bestfSearch(difState);
		else if (dif.equals("a*1"))
			s.aSearch(difState);
		else if (dif.equals("a*2"))
			s.a2Search(difState);
		else if (dif.equals("!"))
			break;
		else if (dif.equals("all")) {
			s.bfSearch(difState);
			s.dfSearch(difState);
			s.ucSearch(difState);
			s.bestfSearch(difState);
			s.aSearch(difState);
			s.a2Search(difState);
			}
		
		System.out.println();
		System.out.println("Welcome back, human.");
		
		}
		in.close();
		
	}
		
	
	
}
