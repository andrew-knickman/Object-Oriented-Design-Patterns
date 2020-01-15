
public class RestaurantReceipt implements Receipt
{
	private MenuItem[] orderItems;
	
	public RestaurantReceipt()
	{
		orderItems = new MenuItem[10];
		populate();
	}
	private void populate()
	{
		orderItems[0] = new MenuItem("Steak", 20.00);
		orderItems[1] = new MenuItem("Burger", 10.00);
		orderItems[2] = new MenuItem("Soup", 8.00);
		orderItems[3] = new MenuItem("Pasta", 12.00);
		orderItems[4] = new MenuItem("Ice Cream", 6.00);
		orderItems[5] = new MenuItem("Pizza", 14.00);
		orderItems[6] = new MenuItem("Tea", 3.50);
		orderItems[7] = new MenuItem("Soda", 3.00);
		orderItems[8] = new MenuItem("Garlic Bread", 8.00);
		orderItems[9] = new MenuItem("Salmon", 24.00);
	}
	public double getCost()
	{
		double sum = 0;
		for(int i = 0; i < orderItems.length; i++)
			sum += orderItems[i].getPrice();
		return sum;
	}
	public String display()
	{
		String receipt = "";
		for(int i = 0; i < orderItems.length; i++)
			receipt = receipt + orderItems[i].toString() + "\n";
		return receipt + "Total: " + getCost();
	}
}
