import java.util.Scanner;
public class MenuDemo {

	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		
		int input = -1;
		String menuopt = "X";
		Menu testmenu = new Menu();
		populateMenu(testmenu);
		
		do
		{
			while(input < 0 || input > 9)
			{
				System.out.println(menuDisplay());
				//if(!kb.hasNextInt()) not helping with NoSuchElementException
				input = kb.nextInt();
			}
			if(input == 0)
				System.out.println("Goodbye!");
			else
			{
				menuControl(input, testmenu);
				input = 0;
			}
		}
		while(input != 0);
		kb.close();
	}
	public static String menuDisplay()
	{
		return "\nSelect one of the following inputs (0 to Exit Menu):"
				+ "\n1 – Display all menu items"
				+ "\n2 – Display all appetizers"
				+ "\n3 – Display all main dishes"
				+ "\n4 – Display all desserts"
				+ "\n5 – Display all hearty healthy items"
				+ "\n6 – Display all main dishes under a specified price"
				+ "\n7 – Add menu item"
				+ "\n8 – Remove menu item (by item number)"
				+ "\n9 – Remove menu item (by index)";
	}
	public static void populateMenu(Menu mnu)
	{
		MenuItem[] items = new MenuItem[6];
		items[0] = new MenuItem(10, "Burger and Fries", 2, false, 9.99);
		items[1] = new MenuItem(11, "Salad", 1, true, 7.99);
		items[2] = new MenuItem(12, "Ice Cream", 3, false, 5.99);
		items[3] = new MenuItem(13, "Apple Slices", 1, true, 3.99);
		items[4] = new MenuItem(14, "Apple Pie", 3, false, 6.99);
		items[5] = new MenuItem(15, "Steak", 2, false, 21.99);
		mnu.addItem(items[0]);
		mnu.addItem(items[1]);
		mnu.addItem(items[2]);
		mnu.addItem(items[3]);
		mnu.addItem(items[4]);
		mnu.addItem(items[5]);
	}
	public static void menuControl(int opt, Menu mnu)
	{
		MenuItem itm;
		MenuInterface itr;
		double price = -1.00;
		Scanner k = new Scanner(System.in);
		if(opt == 1)
		{
			System.out.println("All Menu Items:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 2)
		{
			System.out.println("All Appetizers:");
			itr = mnu.getItemIterator(mnu.APPETIZERS);
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 3)
		{
			System.out.println("All Main Dishes:");
			itr = mnu.getItemIterator(mnu.MAIN_DISH);
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 4)
		{
			System.out.println("All Desserts:");
			itr = mnu.getItemIterator(mnu.DESSERT);
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 5)
		{
			System.out.println("All Heart Healthy Options:");
			itr = mnu.getHeartHealthyIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 6)
		{
			System.out.println("Specify a price:");
			while(price < 0)
				price = k.nextDouble();
			System.out.printf("\nAll Main Dishes Under $%.2f:\n", price);
			itr = mnu.getPriceIterator(price);
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 7)
		{
			System.out.println("Adding a Menu Item:");
			System.out.println("Specify an Item Number(int), Item Name(String), Item Category(1-3), Heart Healthy Option(boolean), and Price(double)");
			System.out.println("(All values should be separated by spaces):");
			mnu.addItem(new MenuItem(k.nextInt(), k.next(), k.nextInt(), k.nextBoolean(), k.nextDouble()));
			System.out.println("Updated Menu Items:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toString());
			}
		}
		else if(opt == 8)
		{
			System.out.println("Menu Items by Number:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toNumber());
			}
			
			System.out.println("Remove Item by Number:");
			mnu.deleteItemByNumber(k.nextInt());
			
			System.out.println("Updated Menu Items:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		else if(opt == 9)
		{
			int counter = 1;
			System.out.println("Menu Items by Index:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(counter + " " + itm.toMenu());
				counter++;
			}
			
			System.out.println("Remove Item by Index:");
			mnu.deleteItemByPointer(k.nextInt());
			
			System.out.println("Updated Menu Items:");
			itr = mnu.getAllItemsIterator();
			while(itr.hasNext())
			{
				itm = itr.next();
				System.out.println(itm.toMenu());
			}
		}
		k.close();
	}
}
