package TripPlanner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
/**
 * A class that visually displays the user going on a trip
 * between the locations input in the constructor
 * @author Ethan King
 *
 */
public class TripPlanner {
	List<State> stateList;
	Graph g;
	boolean checkForContinue = true;
	
	String formatCar = "<br/>______<br/>" + 
			" /|_||_\\`.__<br/>" + 
			"(   _    _ _\\<br/>" + 
			"=`-(_)--(_)- <br/>";
	
	String formatTruck = "<br/>  ================\\<br/>" + 
			"  |----------||@  \\\\   ___<br/>" + 
			"  |____|_____|||_/_\\\\_|___|_<br/>" + 
			" <|  ___\\    ||     | ____  |<br/>" + 
			" <| /    |___||_____|/    | |<br/>" + 
			" ||/  O  |__________/  O  |_||<br/>" + 
			"    \\___/            \\___/<br/>";
	
	String formatCycle = "<br/>        (_\\<br/>" + 
			"       / \\<br/>" + 
			"  `== / /\\=,_<br/>" + 
			"   ;--==\\\\  \\\\o<br/>" + 
			"   /____//__/__\\<br/>" + 
			"  =`(0)     (0)<br/>";
	
	/**
	 * Constructs the TripPlanner with a list of states and a graph
	 * file representing those states
	 * @param stateList
	 * @param graphFile
	 */
	TripPlanner(List<State> stateList, String graphFile)
	{
		this.stateList = stateList;
		In in = new In(graphFile);
		g = new Graph(in);
	}
	
	public void setCheckForContinue(boolean bool)
	{
		checkForContinue = bool;
	}
	
	public void tripSetup(String startingState, String endingState, int carType, boolean isCycle, TripVisualizer gui)
	{
		int startingIndex;
		int endingIndex;
		
		startingIndex = getStateIndex(startingState);
		endingIndex = getStateIndex(endingState);
		travel(startingIndex, endingIndex, carType, isCycle, gui);
	}
	
	/**
	 * Given the startingState and endingState, using BFS to find the fastest
	 * route. Will cycle back on a different route if isCycle is true. 
	 * Uses ASCII images and text to create a more interesting experience
	 * @param startingState
	 * @param endingState
	 */
	private void travel(int startingIndex, int endingIndex, int carType, boolean isCycle, TripVisualizer gui) 
	{
		boolean[] visited = new boolean[g.V()];
		BreadthFirstPathsModified bfs = new BreadthFirstPathsModified(g, startingIndex, visited);
		
		int count = 0;
		Stack<Integer> route = bfs.pathTo(endingIndex);
		for (int i : route)
		{
			checkForContinue = true;
			if (i == endingIndex && !isCycle)
				endTravel(stateList.get(i), carType, gui);
			else if (count > 0)
				travelTo(stateList.get(i), carType, gui);
			count++;	
		}
		
		
		
		try
		{
			if (isCycle)
			{
				visited = bfs.getVisited();
				bfs = new BreadthFirstPathsModified(g, endingIndex, visited);
				count = 0;
				route = bfs.pathTo(startingIndex);
				
				for (int i : route)
				{
					checkForContinue = true;
					if (i == startingIndex)
						endTravel(stateList.get(i), carType, gui);
					else if (count > 0)
						travelTo(stateList.get(i), carType, gui);
					count++;
				}
				
			}
		}
		catch (NullPointerException error)
		{
			String output = String.format("Could not find different route back to %s from %s",
					stateList.get(startingIndex).getName(),
					stateList.get(endingIndex).getName());
			gui.updateTitle(output);
		}
		
	}
	
	
	private void endTravel(State state, int carType, TripVisualizer gui) {
		String name = state.getName();
		int distance = state.getRadius();
		
		StringBuilder display = new StringBuilder("");
		display.append(drawCar(carType));
		display.append("Driving to " + name);
		
		for (int i = 0; i < distance / 60; i++)
		{
			if (i % 4 == 0)
			{
				display = new StringBuilder("");
				display.append(drawCar(carType));
				display.append("Driving to " + name);
			}
			gui.updateTitle(display.toString());
			display.append(".");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		display = new StringBuilder("");
		display.append(drawCar(carType));
		display.append("\nYou've arrived at " + state.name + "!\n");
		display.append(state.getRandomEvent());
		display.append("\nYou've completed your drive!!!");
		gui.updateTitle(display.toString());
		gui.setIsWaiting(true);
		while (checkForContinue)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Displays the act of driving from one location to the other
	 * @param distance
	 * @param name
	 */
	private void travelTo(State state, int carType, TripVisualizer gui)
	{
		
		String name = state.getName();
		int distance = state.getRadius();
		StringBuilder display = new StringBuilder("");
		display.append(drawCar(carType));
		display.append("Driving to " + name);
		for (int i = 0; i < distance / 40; i++)
		{
			if (i % 4 == 0)
			{
				display = new StringBuilder("");
				display.append(drawCar(carType));
				display.append("Driving to " + name);
			}
			gui.updateTitle(display.toString());
			display.append(".");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearScreen();
		}
		display = new StringBuilder("");
		display.append(drawCar(carType));
		display.append("\nYou've arrived at " + state.name + "!\n");
		display.append(state.getRandomEvent());
		display.append("\nPress Start to continue: ");
		gui.updateTitle(display.toString());
		gui.setIsWaiting(true);
		while (checkForContinue)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * "Clears" the console by printing 50 blank lines
	 */
	private void clearScreen()
	{
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	/**
	 * Draws an ASCII image of a car with a parameter leftMargin
	 * determining how far from the left it is
	 * @param leftMargin
	 */
	private String drawCar(int drawType)
	{	
		switch (drawType)
		{
			case (0):
				return formatCar;
				
			case (1):
				return formatTruck;
				
			case (2):
				return formatCycle;
				
			default:
				return formatCar;
		}	
	}
	
	/**
	 * Returns the index value of a state if it matches the String name
	 * @param name
	 * @return
	 */
	private int getStateIndex(String name)
	{
		for (State s : stateList)
		{
			if (s.getAbvr().equals(name) || s.getName().equals(name))
				return stateList.indexOf(s);
		}
		
		throw new IllegalArgumentException(name + " does not exist in list of states!");
	}
	
	
}
