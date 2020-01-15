
public abstract class TaxComputationMethod
{
	public abstract double computeTax(PurchasedItems items, ReceiptDate date);
	protected abstract boolean taxHoliday(ReceiptDate date);
}
