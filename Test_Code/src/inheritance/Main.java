package inheritance;



public class Main
{
	public static void main(String[] args)
	{
		Cat myCat = new Cat("Scooter", 12);
		Dog myDog = new Dog("Keahi", 12);
		
		System.out.println(myCat.getName());
		System.out.println(myCat.getAge());
		myCat.makeNoise();
		
		System.out.println("");
		
		System.out.println(myDog.getName());
		System.out.println(myDog.getAge());
		myDog.makeNoise();
		
		System.out.println("");
	}
}
