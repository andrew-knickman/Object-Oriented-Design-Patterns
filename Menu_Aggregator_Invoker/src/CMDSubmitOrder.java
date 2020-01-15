
public class CMDSubmitOrder 
{
	private Aggregator agg;
	
	public CMDSubmitOrder(Aggregator agg)
	{
		this.agg = agg;
	}
	
	public Orders execute()
	{
		return (Orders) agg.getOrders();
		//return agg.getMenu().clone(); //clone method
	}

}
