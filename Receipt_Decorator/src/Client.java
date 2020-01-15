
public class Client 
{
	public static void main(String[] args)
	{
		RestaurantReceipt r = new RestaurantReceipt();
		ReceiptDecorator cpd = new CouponReceiptDecorator(100, r);
		ReceiptDecorator dod = new DollarOffDecorator(15, cpd);
		System.out.println(dod.display());
	}

}
