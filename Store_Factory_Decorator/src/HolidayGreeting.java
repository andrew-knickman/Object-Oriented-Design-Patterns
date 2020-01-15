
public class HolidayGreeting implements SecondaryHeader
{
	public boolean applies(PurchasedItems items)
	{
		return true;
	}
	public String getLines()
	{
		return "HAPPY HOLIDAYS from BEST BUY! :D";
	}
}
