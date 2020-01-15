
public abstract class Decorator implements Receipt
{
	private Receipt rt;
	private AddOn ao;
	
	public Decorator(Receipt rt, AddOn ao)
	{
		this.rt = rt;
		this.ao = ao;
	}
	protected void callTrailer()
	{
		rt.printReceipt();
	}
	public abstract void printReceipt();

}
