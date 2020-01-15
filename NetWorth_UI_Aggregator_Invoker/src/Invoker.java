
public class Invoker 
{
	Aggregator agg;
	public Invoker (Aggregator agg)
	{
		this.agg = agg;
	}
	public Assets addAsset(String des, double val)
	{
		return (Assets) new CMDAddItem(agg, new AssetItem(des, val)).execute();
	}
	public Liabilities addLiability(String des, double val)
	{
		return (Liabilities) new CMDAddLiability(agg, new LiabilityItem(des,val)).execute();
	}
	public Double getNetWorth()
	{
		return (Double) new CMDGetNetWorth(agg).execute();
	}
	public String getAssets()
	{
		return (String) new CMDGetItem(agg).execute().toString();
	}
	public String getLiabilities()
	{
		return (String) new CMDGetLiability(agg).execute().toString();
	}
}
