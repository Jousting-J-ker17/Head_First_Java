// Understanding Constructors
public class UseADuck {
	public static void main(String[] args) {
		Duck d = new Duck(42);
	}
}

class Duck {
	int size;

	public Duck() {
		// supply default size
		size = 27;
	}


	public Duck(int duckSize) {

		// use duckSize parameter
		System.out.println("Quack");

		size = duckSize;

		System.out.println("size is " + size);
	}
}
