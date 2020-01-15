
public class CMDGetItem implements CommandInterface
{
	private Aggregator agg;
	public CMDGetItem(Aggregator agg)
	{
		this.agg = agg;
	}
	public Assets execute()
	{
		return agg.getAssets();
	}
}

