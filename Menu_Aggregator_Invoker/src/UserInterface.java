import java.util.Scanner;

public class UserInterface 
{
	private SystemInterface si;
	
	public UserInterface(SystemInterface si)
	{
		this.si = si;
	}
	public void start()
	{
		boolean go = true;
		while(go)
		{
			displayUserOptions(); //imp supporting method
			int option = getOption(); //imp supporting method
			switch(option)
			{
			case 1: displayMenu(); break;
			case 2: submitOrder(); break;
			case 3: displayTab(); break;
			case 4: System.out.println("Goodbye!"); go = false;
			
			}
		}
	}

	private void displayScreen(String[] lines)
	{
		for(int i = 0; i < lines.length; i++)
			System.out.println(lines[i]);
		
	}
	private void displayUserOptions()
	{
		System.out.println("1 - Get Menu "
				+ "\n2 - Submit Order "
				+ "\n3 - Display Tab"
				+ "\n4 - Quit");
	}
	private int getOption()
	{
		int option = -1;
		Scanner k = new Scanner(System.in);
		do
		{
			if(k.hasNextInt())
				option = k.nextInt();			
		}
		while(option < 1 || option > 4);
		return option;
	}
	private String[] displayMenu()
	{
		System.out.println("Restaurant Menu:");
		String[] menu_lines;
		menu_lines = si.getMenu();
		displayScreen(menu_lines);//imp supporting method
		return menu_lines;
	}
	private String[] submitOrder()
	{
		Scanner k = new Scanner(System.in);
		displayMenu();
		System.out.println("Select an item from the menu by item number:");
		int ino = k.nextInt();
		
		System.out.println("Order Submitted!");
		
		//returns order acknowledgement with list of orders
		String[] order_lines;
		order_lines = si.submitOrder(ino);

		System.out.println("Previous Orders:");
		if(order_lines.length < 1)
			System.out.print(" No previous orders\n");
		displayScreen(order_lines);
		return order_lines;
	}
	private String[] displayTab()
	{
		System.out.println("Here is your tab:");
		String[] tab_lines;
		tab_lines = si.getTab();
		displayScreen(tab_lines);
		return tab_lines;
		//returns a customer tab
	}
	
}
