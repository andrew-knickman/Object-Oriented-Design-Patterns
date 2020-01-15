
public class DollarOffDecorator extends ReceiptDecorator
{
	private int off;
	public DollarOffDecorator(int off, Receipt r)
	{
		super(r);
		this.off = off;
	}
	public String display()
	{
		return super.display() + "\nYou received $" + off + " your next purchase!";
	}
}
