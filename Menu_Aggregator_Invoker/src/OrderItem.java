
public class OrderItem 
{
	private MenuItem item;
	private int ino;
	
	//order item must be established with existing menuitem
	//menuitem is also used to calculate total on tab
	public OrderItem(MenuItem item)
	{
		this.item = item;
		this.ino = item.getItemNumber();
	}
	public MenuItem getMenuItem()
	{
		return item;
	}
	public int getItemNumber()
	{
		return ino;
	}
	public String toString()
	{
		return "Item Number " + getItemNumber();
	}
}
