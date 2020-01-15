/* nothing with decorators here yet because you can add
 * decorators as an after thought to add more to the class
 * without changing the basic class
 * e.g. we'll implement Receipt as our decorator
 * and the Receipt class will include a printReceipt method
 * which is established in the basic receipt class*/
public class BasicReceipt implements Receipt
{
	private StoreHeader hdr;
	private TaxComputationMethod tcm; //interface type
	private ReceiptDate date;
	private PurchasedItems items;
	
	public BasicReceipt(PurchasedItems items, ReceiptDate date)
	{
		this.items = items;
		this.date = date;
	}
	public void setStoreHeader(StoreHeader hdr)
	{
		this.hdr = hdr;
	}
	public void setTaxMethod(TaxComputationMethod tcm)
	{
		this.tcm = tcm;
	}
	public void printReceipt()
	{
		System.out.println(hdr);
		items.reset();
		while(items.hasNext())
		{
			System.out.println(items.getNext().toString());
		}
		System.out.println("Balance:\t" + items.getTotalCost());
		System.out.println("Tax:\t" + tcm.computeTax(items, date));
		System.out.println("Total:\t" + (items.getTotalCost() + tcm.computeTax(items, date)));
	}

}
