
public class MenuItem 
{
	private int ino;
	private String ina;
	private double pri;
	
	public MenuItem(int ino, String ina, double pri)
	{
		this.ino = ino;
		this.ina = ina;
		this.pri = pri;
	}
	public int getItemNumber()
	{
		return ino;
	}
	public String getItemName()
	{
		return ina;
	}
	public double getPrice()
	{
		return pri;
	}
	public String toString()
	{
		return "Item Number: " 
				+ getItemNumber() 
				+ ", Item: " 
				+ getItemName() 
				+ ", Price: $" 
				+ getPrice();
	}

}
