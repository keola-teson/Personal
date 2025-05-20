package inheritance;

public class Dog extends Animal
{
	public Dog(String name, int age)
	{
		super(name, age);
	}
	
	public void makeNoise()
	{
		System.out.println("Woof");
	}
}
