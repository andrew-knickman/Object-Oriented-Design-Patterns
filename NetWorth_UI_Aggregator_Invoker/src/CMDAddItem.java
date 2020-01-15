
public class CMDAddItem implements CommandInterface
{
	private Aggregator agg;
	private AssetItem a;
	public CMDAddItem(Aggregator agg, AssetItem a)
	{
		this.agg = agg;
		this.a = a;
	}
	public Assets execute()
	{
		agg.getAssets().addItem(a);
		return agg.getAssets();
	}
}
