
public class VATax extends TaxComputationMethod 
{
	public double computeTax(PurchasedItems items, ReceiptDate date)
	{
		if(taxHoliday(date))
			return 0.00; //return 0 dollar tax value
		return (double) items.getTotalCost() * 0.043; //return a 4.3 percent tax value
	}
	protected boolean taxHoliday(ReceiptDate date)
	{
		if(date.getMonth() == 8)
		{
			if(date.getDay() >= 3 && date.getDay() <= 5)
				return true;
		}
		return false;
	}
}
