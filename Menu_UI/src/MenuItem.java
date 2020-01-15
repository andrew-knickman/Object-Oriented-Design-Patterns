
public class MenuItem 
{
	
	private int ino;
	private String ina;
	private int cat;
	private boolean hrt;
	private double pri;
	
	public MenuItem(int ino, String ina, int cat, boolean hrt, double pri)
	{
		this.ino = ino;
		this.ina = ina;
		this.cat = cat;
		this.hrt = hrt;
		this.pri = pri;
	}
	//creates empty item
	public MenuItem()
	{
		this.ino = -1;
		this.ina = "N/A";
		this.cat = -1;
		this.hrt = false;
		this.pri = -1.0;
	}
	public int getItemNumber()
	{
		return ino;
	}
	public String getItemName()
	{
		return ina;
	}
	public int getCategory()
	{
		return cat;
	}
	public boolean isHeartHealthy()
	{
		return hrt;
	}
	public double getPrice()
	{
		return pri;
	}
	public boolean isEmpty()
	{
		if (ino > 0)
				return false;
		return true;
	}
	public void emptyItem()
	{
		this.ino = -1;
		this.ina = "N/A";
		this.cat = -1;
		this.hrt = false;
		this.pri = -1.0;
	}
	public String toString()
	{
		if(cat == 1)
			return "\nItem Number:" + ino 
					+ " | Item Name:" + ina 
					+ " | Category: Appetizer"  
					+ " | Hearth Healthy:" + hrt 
					+ " | Price:" + pri;
		else if(cat == 2)
			return "\nItem Number: " + ino 
					+ " | Item Name: " + ina 
					+ " | Category: Main Dish" 
					+ " | Hearth Healthy: " + hrt 
					+ " | Price: " + pri;
		
		return "\nItem Number:" + ino 
				+ " | Item Name:" + ina 
				+ " | Category: Dessert" 
				+ " | Hearth Healthy:" + hrt 
				+ " | Price:" + pri;
	}
	public String toMenu()
	{
		return getItemName() + " | $" + getPrice();
	}
	public String toNumber()
	{
		return getItemNumber() + " " + getItemName();
	}
}
