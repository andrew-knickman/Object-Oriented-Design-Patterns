
public class XboxRebate implements Rebate
{
	public boolean applies(PurchasedItems items)
	{
		return items.containsItem("6289122");
	}
	public String getLines()
	{
		return "Mail-In Rebate for Item 6289122: Xbox One S"
				+ "\nName:\tAddress:\t"
				+ "\nMail To: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
	}

}
