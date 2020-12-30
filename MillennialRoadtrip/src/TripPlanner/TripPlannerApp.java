package TripPlanner;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.In;

public class TripPlannerApp {

	public static TripPlanner newTrip() {
		//URL url1 = TripPlanner.class.getResource("/TripPlanner/StateAndTerritoryObjects.txt");
		//URL url2 = TripPlanner.class.getResource("/TripPlanner/UndirectedStateConnectionsByNumber2.txt");
		String statesFile = "/TripPlanner/StateAndTerritoryObjects.txt";
		String graphFile = "/TripPlanner/UndirectedStateConnectionsByNumber2.txt";
		//System.out.println(url1.toString() + "\n" + url2.toString());
		List<State> stateList = new ArrayList<State>();
		readStates(stateList, statesFile);
		TripPlanner trip = new TripPlanner(stateList, graphFile);
		return trip;
	}

	/**
	 * Reads a file into a list of States
	 * @param stateList
	 * @param stateFile
	 */
	private static void readStates(List<State> stateList, String stateFile)
	{
		In in = new In(stateFile);
		String line;
		//LandType[] ph = null;
		//stateList.add(new State("PH", "PlaceHolder", ph, 10));

		while ((line = in.readLine()) != null)
		{
			String[] split = line.split(",");
			String[] typeString = split[2].split(" ");
			LandType[] type = new LandType[typeString.length];
			
			for (int i = 0; i < typeString.length; i++)
				type[i] = LandType.valueOf(typeString[i]);
			
			stateList.add(new State(split[0], split[1], type, Integer.parseInt(split[3])));
		}
	}
}
