public class PhraseOMatic{
	public static void main (String[] args){
		// make three sets of words to choose from.
		String[] wordListOne = {"super cool", "foolhearty", "brave", "crazy", "creative", "functional", "awesome", "clever", "goofy", "bizarre"};
		
		String[] wordListTwo = {"loosely coupled", "six sigma", "asynchronous", "event driven", "pub-sub", "IoT", "cloud native", "service oriented", "containerized", "serverless", "microservices", "distributed ledger"};

		String[] wordListThree = {"framework", "library", "DSL", "REST API", "repository", "pipeline", "service mesh", "architecture", "persepective", "design", "orientation"};

		// find out how many words are in each list
		int oneLength = wordListOne.length;	
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;

		// generate three random numbers
		java.util.Random randomGenerator = new java.util.Random();
		int rand1 = randomGenerator.nextInt(oneLength);
		int rand2 = randomGenerator.nextInt(twoLength);
		int rand3 = randomGenerator.nextInt(threeLength);

		// build a phrase
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

		// print out the phrase
		System.out.println("What we need is a " + phrase);
	}
}