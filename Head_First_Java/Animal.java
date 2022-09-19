// example for inheritance, polymorphism that won't work because classes do not have code in methods.

public abstract class Animal {
	String food;
	boolean hunger;
	int boundaries; 
	int location;  // Animal HAS-A location

	public abstract String makeNoise(); // Even though an abstract class, not all methods need to be abstract
	public abstract void eat();
	public abstract void sleep();
	public abstract void roam();
}

abstract class Feline extends Animal {
	public void roam(){} // overridden method, inherits everything else from Animal
}

class Hippo extends Animal { // a concrete class
	public String MakeNoise(){} // overridden methods, inherits everything else from Animal
	public void roam(){}
}

abstract class Canine extends Animal {
	public void roam(){} // overridden method, inherits everything else from Animal
}

class Lion extends Feline { // a concrete class
	public String MakeNoise(){} // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat(){}
}

class Tiger extends Feline { // a concrete class
	public String MakeNoise(){} // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat(){}
}

class cat extends Feline implements Pet{  // a concrete class
	public void beFriendly(){}
	public void play(){}

	public String MakeNoise(){} // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat(){}
}

class Wolf extends Canine { // Wolf IS-A Animal and a concrete class
	public String MakeNoise(){} // overridden methods, inherits everything else from Canine and then Animal classes, respectfully
	public void eat(){}
}

class Dog extends Canine implements Pet{ // a concrete class
	public void beFriendly(){} // must implement Pet methods
	public void beFriendly(){}

	public String MakeNoise(){} // overridden methods, inherits everything else from Canine and then Animal classes, respectfully
	public void eat(){}
}

interface Pet {
	void beFriendly(); // interface methods are implicitly public and abstract, typing those keywords are optional
	void play();
}