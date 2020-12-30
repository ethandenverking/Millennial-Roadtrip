package TripPlanner;

public class StateDescriptions {

	private static String[] desert = { "You see a cactus.", "Living in this heat is a tribute to the hubris of man.",
			"Boy, do you wish your AC still worked.",
			"You don't like sand. It's coarse and rough and irritating — and it gets everywhere.",
			"Soda is no substitute for water." };

	private static String[] mountain = { "You get the sudden urge to go hiking.", "Your ears pop for the twelfth time.",
			"Your phone loses its signal... yet again.", "The sunsets are fantastic.",
			"The weather changes every five minutes." };

	private static String[] coastal = { "Dang, are hotels pricy. You sleep in your car.",
			"You take a break to go swimming.", "You see the sun rise on the water.",
			"You give up on being able to even slightly control your hair.", "The takeout here is superb." };

	private static String[] forested = { "They say the clowns disappeared into those trees.",
			"The leaves are pretty this time of year.", "Stupid pollen allergy.", "Can't they mark the roads better?",
			"You wonder if you should've backpacked for this part?" };

	private static String[] plains = { "You coincidentally decide to check if it's flood season.",
			"The entire world stretches before you.", "You drive through another ghost town",
			"Home, home on the range..." };

	private static String[] marsh = { "You say later to a gator.", "You long to explore the bayou.",
			"You somehow feel both over and under-dressed for the weather.", "You stop at a Cajun restauraunt.",
			"You remember an odd number of Mark Twain quotes." };

	private static String[] subtrop = { "You eye spies a crocodile.", "There are some really unfortunate statues.",
			"Farm, factory, farm, factory, farm, factory...",
			"If the heat doesn't get you, you feel like the humidity will.",
			"Everyone you meet is half your age or twice your age. There is no in-between." };

	private static String[] cont = { "The traffic feels uniquely bad.", "Weird number of fruit trees.",
			"You see the largest building you've ever seen.", "You see the smallest 'town' you've ever seen.",
			"What state are you in again?" };

	private static String[] island = {
			"I don't know how, but you did it, you crazy son of a gun. Your high school swim coach would be proud.",
			"Man, are your arms tired.",
			"Your car may be old, but it gets surprisingly good mileage as a flotation device", "So many tourists.",
			"What you wouldn't do for a pina coloda." };

	private static String[] canada = { "You encounter a wandering mountie on your journey. Roll initiative.",
			"A moose bit your sister.", "You pickup a commemorative maple leaf." };

	/**
	 * @return the desert
	 */
	public static String[] getDesert() {
		return desert;
	}

	/**
	 * @return the mountain
	 */
	public static String[] getMountain() {
		return mountain;
	}

	/**
	 * @return the coastal
	 */
	public static String[] getCoastal() {
		return coastal;
	}

	/**
	 * @return the forested
	 */
	public static String[] getForested() {
		return forested;
	}

	/**
	 * @return the plains
	 */
	public static String[] getPlains() {
		return plains;
	}

	/**
	 * @return the marsh
	 */
	public static String[] getMarsh() {
		return marsh;
	}

	/**
	 * @return the subtrop
	 */
	public static String[] getSubtrop() {
		return subtrop;
	}

	/**
	 * @return the cont
	 */
	public static String[] getCont() {
		return cont;
	}

	/**
	 * @return the island
	 */
	public static String[] getIsland() {
		return island;
	}

	/**
	 * @return the canada
	 */
	public static String[] getCanada() {
		return canada;
	}

	
}
