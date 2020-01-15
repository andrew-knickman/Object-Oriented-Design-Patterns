
public abstract class ReceiptDecorator implements Receipt
{
	private Receipt receipt;
	
	public ReceiptDecorator(Receipt receipt)
	{
		this.receipt = receipt;
	}
	public String display()
	{
		return receipt.display();
	}
}
