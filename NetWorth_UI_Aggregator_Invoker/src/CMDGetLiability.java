
public class CMDGetLiability implements CommandInterface
{
	private Aggregator agg;
	public CMDGetLiability(Aggregator agg)
	{
		this.agg = agg;
	}
	public Liabilities execute()
	{
		return agg.getLiabilities();
	}
}