//a store item should be immutable - no setters
public class StoreItem 
{
	private String code; //item code
	private String price; //item price
	private String desc; //item description
	
	public StoreItem(String code, String price, String desc)
	{
		this.code = code;
		this.price = price;
		this.desc = desc;
	}
	public String getCode()
	{
		return code;
	}
	public String getPrice()
	{
		return price;
	}
	public String getDescription()
	{
		return desc;
	}
	public String toString()
	{
		return "Item Code: " 
	+ getCode() 
	+ "\tItem Price: " 
	+ getPrice()
	+ "\tItem Description: " 
	+ getDescription();
	}
}
