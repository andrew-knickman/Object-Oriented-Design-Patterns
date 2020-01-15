
public class CMDAddLiability implements CommandInterface
{
	private Aggregator agg;
	private LiabilityItem l;
	public CMDAddLiability(Aggregator agg, LiabilityItem l)
	{
		this.agg = agg;
		this.l = l;
	}
	public Liabilities execute()
	{
		agg.getLiabilities().addItem(l);
		return agg.getLiabilities();
	}
}
