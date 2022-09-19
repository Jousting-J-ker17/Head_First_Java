// polymorphism in action, everything has Object "class" methods.

public class MyAnimalList {
	private Animal[] animals = new Animal[5];
	private int nextIndex = 0;

	public void add(Animal a) {
		if (nextIndex < animals.length) {
			animals[nextIndex] = a;
			System.out.println("Animal added at " + nextIndex);
			nextIndex++;
		}
	}
}

public class AnimalTestDrive {
	public static void main(String []args) {
		MyAnimalList list = new MyAnimalList();
		Dog dog = new Dog();
		Cat cat = new Cat();
		list.add(dog);
		list.add(cat);
	}
}