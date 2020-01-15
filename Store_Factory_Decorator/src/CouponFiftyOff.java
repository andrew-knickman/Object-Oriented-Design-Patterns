
public class CouponFiftyOff implements Coupon
{
	public boolean applies(PurchasedItems items)
	{
		return items.containsItem("5091315");
	}
	public String getLines()
	{
		return "***Get 50% off your next CANON purchase with code COSC5091315***";
	}
}
