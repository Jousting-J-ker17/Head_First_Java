public class SimpleStartupTestDrive{
	public static void main(String[] args){
		SimpleStartup dot = new SimpleStartup();

		int[] locations = {2, 3, 4};
		dot.setLocationCells(locations);

		int userGuess = 2;
		String result = dot.checkYourself(userGuess);

		String testResult = "failed";
		if (result.equals("hit")) {
			testResult = "passed";
		}

		System.out.println(testResult);
	}
}

class SimpleStartup {
			private int[] locationCells;
			private int numOfHits = 0;
			
			public String checkYourself(int guess){
				String result = "miss";
				
				for (int cell: locationCells) {
					if (guess == cell){
						result = "hit";
						numOfHits++;
						break;
					}
				}
				
				if (numOfHits == locationCells.length){
					result = "kill";
				}

				System.out.println(result);

				return result;
			}

			public void setLocationCells(int[] loc){
				locationCells = loc;
			}

		}