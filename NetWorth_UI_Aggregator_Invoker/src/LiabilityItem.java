
public class LiabilityItem 
{
	private String des;
	private double val;
	
	public LiabilityItem(String des, double val)
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
		return "Liability: " + des + "\t$" + val;
	}

}
