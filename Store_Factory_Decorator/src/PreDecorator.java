
public class PreDecorator extends Decorator
{	
	Receipt rt;
	AddOn ao;
	
	public PreDecorator(Receipt rt, AddOn ao)
	{
		super(rt, ao);
	}
	public void printReceipt()
	{
		System.out.println(ao.getLines());
		callTrailer();
	}
}
