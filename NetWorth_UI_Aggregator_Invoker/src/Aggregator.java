
public class Aggregator 
{
	private Assets asts;
	private Liabilities lias;
	
	public Aggregator()
	{
		asts = new Assets();
		lias = new Liabilities();
	}
	private void addLiability(LiabilityItem l)
	{
		lias.addItem(l);
	}
	private void addAsset(AssetItem a)
	{
		asts.addItem(a);
	}
	public Assets getAssets()
	{
		return asts;
	}
	public Liabilities getLiabilities()
	{
		return lias;
	}
}
