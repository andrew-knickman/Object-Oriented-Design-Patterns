
public class PostDecorator extends Decorator
{
	Receipt rt;
	AddOn ao;
	
	public PostDecorator(Receipt rt, AddOn ao)
	{
		super(rt, ao);
	}
	public void printReceipt()
	{
		callTrailer();
		System.out.println(ao.getLines());
	}
}
