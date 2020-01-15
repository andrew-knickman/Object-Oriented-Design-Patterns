
public class CMDGetNetWorth implements CommandInterface 
{
	private Aggregator agg;
	public CMDGetNetWorth(Aggregator agg)
	{
		this.agg = agg;
	}
	public Double execute()
	{
		return agg.getAssets().total() - agg.getLiabilities().total();
	}

}
