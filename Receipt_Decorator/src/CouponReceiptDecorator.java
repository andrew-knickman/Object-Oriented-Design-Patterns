
public class CouponReceiptDecorator extends ReceiptDecorator
{
	private int discount;
	private double total;
	public CouponReceiptDecorator(int discount, Receipt r)
	{
		super(r);
		this.discount = discount;
	}
	public String display()
	{
		return super.display() + "\nYou got a " + discount + "% discount!";
	}
}
