package TripPlanner;

import edu.princeton.cs.algs4.StdRandom;

/**
 * A class representing a state or piece of land, including its abbreviation, name, 
 * climate and land type, and it's average distance from it's center to it's edge
 * @author Ethan King
 *
 */
public class State {
	String abvr;
	String name;
	LandType[] type;
	int radius;
	
	/**
	 * Constructs a state with an abbreviation, name, LandType, and distance
	 * @param abvr
	 * @param name
	 * @param type
	 * @param radius
	 */
	State(String abvr, String name, LandType[] type, int radius)
	{
		this.abvr = abvr;
		this.name = name;
		this.type = type;
		this.radius = radius;
	}
	
	/**
	 * @return the abvr
	 */
	public String getAbvr() {
		return abvr;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the type
	 */
	public LandType[] getType() {
		return type;
	}


	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Returns a string depicting a random event that could occur in that
	 * state's given LandType
	 * @return
	 */
	public String getRandomEvent()
	{
		LandType randType = type[StdRandom.uniform(type.length)];
		switch(randType)
		{
			case DESERT:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case MOUNTAINOUS:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case COASTAL:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case FORESTED:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case PLAINS:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case MARSH:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case SUBTROPICAL:
			{String[] list = randType.getDescriptions();
			return list[StdRandom.uniform(list.length)];
			}
			
			case CONTINENTAL:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case ISLAND:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			case CANADA:
			{
				String[] list = randType.getDescriptions();
				return list[StdRandom.uniform(list.length)];
			}
			
			default:
				break;
		}
		
		return "Nothing happens";
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append(abvr + ", " + name + ", ");
		for (LandType t : type)
			str.append(t + ", ");
		str.append(radius);
		return str.toString();
	}
	
	
}
