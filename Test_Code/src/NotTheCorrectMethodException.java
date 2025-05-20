
public class NotTheCorrectMethodException extends RuntimeException
{
	private static final long serialVersionUID = -4062993266381950298L;
	
	public NotTheCorrectMethodException()
	{
		super("The method called isn't the correct method. Please call the appropriate one");
	}
	
	public NotTheCorrectMethodException(String message)
	{
		super(message);
	}
	
	public NotTheCorrectMethodException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
