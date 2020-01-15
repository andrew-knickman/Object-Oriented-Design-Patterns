
public class MenuItem 
{
	private String desc;
	private double price;
	
	public MenuItem(String desc, double price)
	{
		this.desc = desc;
		this.price = price;
	}
	public MenuItem()
	{
		desc = "";
		price = 0.0;
	}
	public String toString()
	{
		return "Item: " + desc + ", Price: " + price;
	}
	public double getPrice()
	{
		return price;
	}
	public boolean isEmpty()
	{
		if(desc.compareTo("") == 0 && price == 0.0)
			return true;
		return false;
	}

}
