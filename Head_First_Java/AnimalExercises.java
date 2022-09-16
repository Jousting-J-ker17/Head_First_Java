public class AnimalExercises {
	public static void main (String []args) {
		// polymorphism in action as an array
		/*
		Animal[] animals = new Animal[5];
		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Wolf();
		animals[3] = new Hippo();
		animals[4] = new Lion();

		for (Animal animal : animals) { // loop through array and call one of the Animal-class methods
			animal.eat(); // the subclasses object will call its' version of the eat().
			animal.roam();
		}
		*/

		// polymorphism through aruments and return types
		/*
		public class Vet {
			public void giveShot(Animal a) {
				// code for give shot
				a.makeNoise();
			}
		}

		public class PetOwner {
			public void start() {
				Vet vet = new Vet();
				Dog dog = new Dog();
				Hippo hippo = new Hippo();
				vet.giveShot(dog); // Dog's makeNoise() runs
				vet.giveShot(hippo); // Hippo's makeNoise() runs
			}
		}
		*/

 	
	}
}