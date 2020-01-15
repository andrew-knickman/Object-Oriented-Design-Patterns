
public class Invoker 
{
	private Aggregator agg;
	
	public Invoker(Aggregator agg)
	{
		this.agg = agg;
	}
	public Menu getMenu()
	{
		return (Menu) new CMDGetMenu(agg).execute();
	}
	public Orders submitOrder()
	{
		return (Orders) new CMDSubmitOrder(agg).execute();
	}
	public Tab getTab()
	{
		return (Tab) new CMDGetTab(agg).execute();
	}
}
