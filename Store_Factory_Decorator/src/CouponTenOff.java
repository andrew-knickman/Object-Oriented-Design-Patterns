//10 percent off coupon
public class CouponTenOff implements Coupon
{
	public boolean applies(PurchasedItems items)
	{
		return items.containsItem("6290160");
	}
	public String getLines()
	{
		return "***Get 10% off your next SAMSUNG purchase with code COSC6290160***";
	}
}
