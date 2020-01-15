
public class CMDGetTab 
{
	private Aggregator agg;
	
	public CMDGetTab(Aggregator agg)
	{
		this.agg = agg;
	}
	
	public Tab execute()
	{
		return new Tab(agg.getOrders());
		//return agg.getMenu().clone(); //clone method
	}


}
