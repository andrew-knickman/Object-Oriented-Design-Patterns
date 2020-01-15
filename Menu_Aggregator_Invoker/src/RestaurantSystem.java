
public class RestaurantSystem 
{
	public static void main(String[] args) 
	{
		Aggregator agg = new Aggregator();
		populate(agg.getMenu());
		Invoker invoker = new Invoker(agg);
		SystemInterface si = new SystemInterface(invoker);
		UserInterface ui = new UserInterface(si);
		ui.start();
	}
	public static void populate(Menu menu)
	{
		menu.addItem(new MenuItem(1, "Steak", 22.00));
		menu.addItem(new MenuItem(2, "Burger", 12.00));
		menu.addItem(new MenuItem(3, "Salad", 9.00));
		menu.addItem(new MenuItem(4, "Turkey Sandwich", 11.00));
		menu.addItem(new MenuItem(5, "Spaghetti", 14.00));
		menu.addItem(new MenuItem(6, "Salmon", 20.00));
		menu.addItem(new MenuItem(7, "Ice Cream", 8.00));
		menu.addItem(new MenuItem(8, "Cake", 9.00));	
	}
}
