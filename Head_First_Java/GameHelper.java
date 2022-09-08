import java.util.*;

public class GameHelper {
	private static final String ALPHABET = "abcdefg";
	private static final int GRID_LENGTH = 7;
	private static final int GRID_SIZE = 49;
	private static final int MAX_ATTEMPTS = 200;
	static final int HORIZONTAL_INCREMENT = 1; // for better code use enum
	static final int VERTICAL_INCREMENT = GRID_LENGTH; // for better code use enum

	private final int[] grid = new int[GRID_SIZE];
	private final Random random = new Random();
	private int startupCount = 0;

	public String getUserInput(String prompt) {
		System.out.print(prompt + ": ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toLowerCase();
	}

	public ArrayList<String> placeStartup(int StartupSize) {
		// holds index to grid (0-48)
		int[] startupCoords = new int[StartupSize]; // current candidate coords
		int attempts = 0; // current attempts counter
		boolean success = false; // flag = found a good location?

		startupCount++; // nth Startup to place
		int increment = getIncrement(); // alternate vert & horiz alignment

		while (!success & attempts++ < MAX_ATTEMPTS) { // main search loop
			int location = random.nextInt(GRID_SIZE); // get random starting point

			for (int i = 0; i < startupCoords.length; i++) { // create array of propsed coords
				startupCoords[i] = location; // put current location in array
				location += increment; // calculate the next location
			}

			if (startupFits(startupCoords, increment)) { // startup fits on the grid?
				success = coordsAvailable(startupCoords); // ...and locations aren't taken?
			}
		}
		savePositionToGrid(startupCoords); // coords passed checks, save
		ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
		// System.out.println("Placed at: " + alphaCells); // tells where the Startup is
		// located.
		return alphaCells;
	}

	private boolean startupFits(int[] startupCoords, int increment) {
		int finalLocation = startupCoords[startupCoords.length - 1];
		if (increment == HORIZONTAL_INCREMENT) {
			// check end is on same row as start
			return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
		} else {
			return finalLocation < GRID_SIZE; // check end isn't off the bottom
		}
	}

	private boolean coordsAvailable(int[] startupCoords) {
		for (int coord : startupCoords) { // check all potential positions
			if (grid[coord] != 0) { // this position already taken
				// System.out.println("position: " + coord + " already taken.");
				return false; // NO success
			}
		}
		return true; // there were no clashes, yay!
	}

	private void savePositionToGrid(int[] startupCoords) {
		for (int index : startupCoords) {
			grid[index] = 1; // mark grid position as 'used'
		}
	}

	private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		for (int index : startupCoords) { // for each grid coordinate
			String alphaCoords = getAlphaCoordsFromIndex(index); // turn it into an "a0" style
			alphaCells.add(alphaCoords); // add to a list
		}
		return alphaCells; // return the "a0" - style coords
	}

	private String getAlphaCoordsFromIndex(int index) {
		int row = calcRowFromIndex(index); // get row value
		int column = index % GRID_LENGTH; // get numeric column value
		String letter = ALPHABET.substring(column, column + 1); // convert to letter
		return letter + row;
	}

	private int calcRowFromIndex(int index) {
		return index / GRID_LENGTH;
	}

	private int getIncrement() {
		if (startupCount % 2 == 0) { // if EVEN Startup
			return HORIZONTAL_INCREMENT; // place horizontally
		} else { // else ODD
			return VERTICAL_INCREMENT; // place vertically
		}
	}
}