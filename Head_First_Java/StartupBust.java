import java.util.ArrayList;

public class StartupBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<Startup> startups = new ArrayList<Startup>();
	private int numOfGuesses = 0;

	// make Startups and give locations
	public void setUpGame() {
		Startup one = new Startup();
		one.setName("Pinta");
		Startup two = new Startup();
		two.setName("Nina");
		Startup three = new Startup();
		three.setName("Santa Maria");
		startups.add(one);
		startups.add(two);
		startups.add(three);

		System.out.println("Your goal is to sink three Startups.");
		System.out.println("Pinta, Nina, and Santa Maria");
		System.out.println("Try to sink them all in the fewest number of guesses");

		for (Startup startup : startups) {
			ArrayList<String> newLocation = helper.placeStartup(3);
			startup.setLocationCells(newLocation);
		}
	}

	private void startPlaying() {
		while (!startups.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";

		for (Startup startupToTest : startups) {
			result = startupToTest.checkYourself(userGuess);

			if (result.equals("hit")) {
				break;
			}

			if (result.equals("kill")) {
				startups.remove(startupToTest);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame() {
		System.out.println("All Startups are dead! Your stock is now worthless");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough... " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

	public static void main(String[] args) {
		StartupBust game = new StartupBust();
		game.setUpGame();
		game.startPlaying();
	}
}