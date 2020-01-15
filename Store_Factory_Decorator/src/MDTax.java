
public class MDTax extends TaxComputationMethod
{
	public double computeTax(PurchasedItems items, ReceiptDate date)
	{
		if(taxHoliday(date))
			return 0.00; //return 0 dollar tax value
		return (double) items.getTotalCost() * 0.06; //return a 6 percent tax value
	}
	protected boolean taxHoliday(ReceiptDate date)
	{
		if(date.getMonth() == 8)
		{
			if(date.getDay() >= 12 && date.getDay() <= 18)
				return true;
		}
		return false;
	}
}
