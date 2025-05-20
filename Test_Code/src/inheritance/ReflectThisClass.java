package inheritance;

public class ReflectThisClass
{
	private String string;
	
	public ReflectThisClass(String string) { this.string = string; }
	
	public String getString()
	{
		return string;
	}
	
	public static void thisIsAStaticMethod()
	{
		System.out.println("I do NOT rely on an attribute");
	}
	
	public void thisIsntAStaticMethod()
	{
		System.out.println("I DO rely on an attribute");
		System.out.println("Attribute in question: \"" + string + "\"");
		System.out.println("");
	}
	
	public void thisIsAPublicMethod()
	{
		System.out.println("This is public");
	}
	
	private void thisIsAPrivateMethod()
	{
		System.out.println("This is private. HOW DID YOU GET HERE????");
	}
}
