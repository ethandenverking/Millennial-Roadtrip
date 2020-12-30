package TripPlanner;


public enum LandType {
	//DESERT(new String["You see a cactus.", ]), MOUNTAINOUS, COASTAL, FORESTED, PLAINS, MARSH, SUBTROPICAL, CONTINENTAL, ISLAND, CANADA;
	
	DESERT(StateDescriptions.getDesert()),
	MOUNTAINOUS(StateDescriptions.getMountain()),
	COASTAL(StateDescriptions.getCoastal()),
	FORESTED(StateDescriptions.getForested()),
	PLAINS(StateDescriptions.getPlains()),
	MARSH(StateDescriptions.getMarsh()),
	SUBTROPICAL(StateDescriptions.getSubtrop()),
	CONTINENTAL(StateDescriptions.getCont()),
	ISLAND(StateDescriptions.getIsland()),
	CANADA(StateDescriptions.getCanada());
	
	private String[] descriptions;
	LandType(String[] strings) {
		descriptions = strings;
	}
	
	/**
	 * @return the descriptions
	 */
	public String[] getDescriptions() {
		return descriptions;
	}

}