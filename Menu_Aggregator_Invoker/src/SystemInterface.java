import java.util.*;

public class SystemInterface 
{
	private Invoker invoker;
	
	public SystemInterface(Invoker invoker)
	{
		this.invoker = invoker;
	}
	public String[] getMenu()
	{
		Menu menu = invoker.getMenu();
		
		//convert Menu object to array of strings
		ArrayList<String> displayLines = new ArrayList<>();
		
		menu.reset();
		while(menu.hasNext())
		{
			displayLines.add(menu.getNextItem().toString());
		}

		//got can't cast Object to String exception with this return
		//return (String[]) displayLines.toArray();
		
		menu.reset();
		String[] convertedLines = new String[displayLines.size()];
		for(int i = 0; i < convertedLines.length; i++)
		{
			if(menu.hasNext())
				convertedLines[i] = displayLines.get(i);
		}
				
		return convertedLines;
		

		//return display_lines
		
	}
	public String[] submitOrder(int item_number)
	{
		Orders order = invoker.submitOrder();
		Menu menu = invoker.getMenu();
		boolean match = false;
		
		order.reset();
		menu.reset();
		while(menu.hasNext() && match == false)
		{
			MenuItem next = menu.getNextItem();
			if(next.getItemNumber() == item_number)
			{
				order.addOrder(new OrderItem(next));
				System.out.println("Added " + next.getItemName() + " to your order!");//confirms order added to orders received from invoker
				match = true;
			}
		}
		
		if(match == false)
			System.out.println("No such item number found! Please select another option.");
		
		ArrayList<String> orderLines = new ArrayList<>();
		
		order.reset();
		menu.reset();
		while(order.hasNext())
		{
			orderLines.add(order.getNextOrder().toString());
		}
		
		order.reset();
		menu.reset();
		String[] convertedLines = new String[orderLines.size()];
		for(int i = 0; i < convertedLines.length; i++)
		{
			if(menu.hasNext())
				convertedLines[i] = orderLines.get(i);
		}
				
		return convertedLines;
		
		//return (String[]) orderLines.toArray();		class cast exception
	}
	public String[] getTab()
	{
		Tab tab = invoker.getTab();
		
		return tab.getTab();
	}
}
