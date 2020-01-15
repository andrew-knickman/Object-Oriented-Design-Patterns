
public class Aggregator 
{
	private Menu menu;
	private Orders orders;
	private Tab tabs;
	
	public Aggregator()
	{
		menu = new Menu();
		//populateMenu();
		
		orders = new Orders();
		
		tabs = new Tab(orders);
	}
	
	public Menu getMenu()
	{
		return menu;
	}
	public Orders getOrders()
	{
		return orders;
	}
	public Tab getTabs()
	{
		return tabs;
	}
	/*private void populateMenu()
	{
		menu.addItem(new MenuItem(1, "Steak", 22.00));
		menu.addItem(new MenuItem(2, "Burger", 12.00));
		menu.addItem(new MenuItem(3, "Salad", 9.00));
		menu.addItem(new MenuItem(4, "Turkey Sandwich", 11.00));
		menu.addItem(new MenuItem(5, "Spaghetti", 14.00));
		menu.addItem(new MenuItem(6, "Salmon", 20.00));
		menu.addItem(new MenuItem(7, "Ice Cream", 8.00));
		menu.addItem(new MenuItem(8, "Cake", 9.00));
	}*/
}
