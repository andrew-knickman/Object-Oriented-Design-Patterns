
public class CMDGetMenu implements CMDInterface
{
	private Aggregator agg;
	
	public CMDGetMenu(Aggregator agg)
	{
		this.agg = agg;
	}
	
	public Menu execute()
	{
		return (Menu) agg.getMenu(); //clone method
	}

}
