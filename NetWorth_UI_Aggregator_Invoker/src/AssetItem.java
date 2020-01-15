
public class AssetItem 
{
	private String des;
	private double val;
	
	public AssetItem(String des, double val)
	{
		this.des = des;
		this.val = val;
	}
	public String getDescription()
	{
		return des;
	}
	public double getValue()
	{
		return val;
	}
	public String toString()
	{
		return "Asset: " + des + "\t$" + val;
	}

}
