
public class SystemInterface 
{
	private Invoker ivkr;
	
	public SystemInterface(Invoker ivkr)
	{
		this.ivkr = ivkr;
	}
	public String addItem(String des, double val)
	{
		Assets asts = ivkr.addAsset(des, val);
		return asts.toString();
	}
	public String addLiability(String des, double val)
	{
		Liabilities lbts = ivkr.addLiability(des, val);
		return lbts.toString();
	}
	public Double getNetWorth()
	{
		Double nwd = ivkr.getNetWorth();
		return nwd;
	}
	public String getAssets()
	{
		String asts = ivkr.getAssets();
		return asts;
	}
	public String getLiabilities()
	{
		String lbts = ivkr.getLiabilities();
		return lbts;
	}
}
