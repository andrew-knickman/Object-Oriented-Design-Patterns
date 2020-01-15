import java.util.ArrayList;

public class Tab 
{
	private Orders orders;
	private double total;
	
	//construct tab with information from both the menu and orders
	public Tab(Orders orders)
	{
		this.orders = orders; //indicates what items ordered
		total = 0.0;
	}
	public String[] getTab()
	{
		//reset total for calculation
		if(total > 0.0)
			total = 0.0;
		
		//create collection of strings included orders and total price of orders
		ArrayList<String> tab = new ArrayList<>();
		
		orders.reset();
		while(orders.hasNext())
		{
			//get next order for toString, ItemName, and ItemPrice
			OrderItem next = orders.getNextOrder();
			
			tab.add(next.toString() 
					+ "	" 
					+ next.getMenuItem().getItemName() 
					+ " $" 
					+ next.getMenuItem().getPrice());
			
			total += next.getMenuItem().getPrice();
		}
		OrderItem last = orders.getNextOrder();
		tab.add(last.toString() 
				+ "	" 
				+ last.getMenuItem().getItemName() 
				+ " $" 
				+ last.getMenuItem().getPrice());
		total += last.getMenuItem().getPrice();
		
		tab.add("Total: $" + String.valueOf(total));
		
		orders.reset();
		String[] convertedLines = new String[tab.size()];
		for(int i = 0; i < convertedLines.length; i++)
		{
			if(orders.hasNext())
				convertedLines[i] = tab.get(i);
		}
				
		return convertedLines;
		
		//return collection strings to array
		//return (String[]) tab.toArray();		class cast exception
	}
	

}
