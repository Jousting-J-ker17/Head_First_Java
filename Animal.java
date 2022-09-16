public class Animal {
	String food;
	boolean hunger;
	int boundaries; 
	int location;  // Animal HAS-A location

	public String makeNoise();
	public void eat();
	public void sleep();
	public void roam();
}

public class Feline extends Animal {
	public void roam(); // overridden method, inherits everything else from Animal
}

public class Hippo extends Animal {
	public String MakeNoise(); // overridden methods, inherits everything else from Animal
	public void roam();
}

public class Canine extends Animal {
	public void roam(); // overridden method, inherits everything else from Animal
}

public class Lion extends Feline {
	public String MakeNoise(); // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat();
}

public class Tiger extends Feline {
	public String MakeNoise(); // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat();
}

public class cat extends Feline { 
	public String MakeNoise(); // overridden methods, inherits everything else from Feline and then Animal classes, respectfully
	public void eat();
}

public class Wolf extends Canine { // Wolf IS-A Animal
	public String MakeNoise(); // overridden methods, inherits everything else from Canine and then Animal classes, respectfully
	public void eat();
}

public class Dog extends Canine {
	public String MakeNoise(); // overridden methods, inherits everything else from Canine and then Animal classes, respectfully
	public void eat();
}