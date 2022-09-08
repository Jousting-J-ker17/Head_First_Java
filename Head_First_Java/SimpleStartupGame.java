class SimpleStartupGame {
	public static void main(String[] args){
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();

		SimpleStartup theStartup = new SimpleStartup();
		int randomNum = (int) (Math.random() * 5);

		int[] locations = {randomNum, randomNum+1, randomNum+2};
		theStartup.setLocationCells(locations);
		boolean isAlive = true;

		while (isAlive){
			int guess = helper.getUserInput("Enter a number");		
			String checkGuess = theStartup.checkYourself(guess);
			numOfGuesses++;
			
			if (checkGuess.equals("kill")) {
				isAlive = false;
				System.out.println("Number of guesses: " + numOfGuesses);
			}
		}
	}
}