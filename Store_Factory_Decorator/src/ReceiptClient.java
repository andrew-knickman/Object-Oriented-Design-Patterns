import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class ReceiptClient 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner k = new Scanner(System.in);
		ArrayList<StoreItem> storeItems = populateStore(); //items in the store
		PurchasedItems pItems = new PurchasedItems(); //items purchased i.e. shopping cart
		ReceiptFactory rMaker = new ReceiptFactory(); //receipt factory
		ReceiptDate rd; //receipt date
		
		rd = setDate(k); //set receipt date
		
		clientLoop(k, storeItems, pItems, rMaker, rd);
	}
	public static void displayInterface()
	{
		System.out.println("\n**************************************************"
				+ "\nWELCOME TO BEST BUY!\nPlease select one of the following options:\n");
		System.out.println(
				"1 - DISPLAY STORE ITEMS"
				+ "\n2 - ADD ITEM TO SHOPPING CART"
				+ "\n3 - DISPLAY SHOPPING CART"
				+ "\n4 - CHECKOUT AND GET RECEIPT"
				+ "\n**************************************************");
	}
	public static ArrayList<StoreItem> populateStore()
	{
		ArrayList<StoreItem> storeItems = new ArrayList<StoreItem>();
		storeItems.add(new StoreItem("6290160", "799.99", "Samsung 65in LED TV"));
		storeItems.add(new StoreItem("6201041", "829.99", "Lenovo Touch-Screen Laptop"));
		storeItems.add(new StoreItem("5822948", "49.99", "Amazon Fire Tablet 8GB"));
		storeItems.add(new StoreItem("6289122", "299.99", "Microsoft Xbox One S 1TB"));
		storeItems.add(new StoreItem("5577872", "159.99", "Apple AirPods"));
		storeItems.add(new StoreItem("5477500", "39.99", "Amazon Fire TV Stick"));
		storeItems.add(new StoreItem("5622669", "399.99", "Bebop 2 Quadcopter Drone"));
		storeItems.add(new StoreItem("5091315", "749.99", "Canon EOS Rebel T6 DSLR Camera"));
		storeItems.add(new StoreItem("6280532", "299.99", "iRobot Roomba 675"));
		storeItems.add(new StoreItem("6234447", "24.99", "Avengers: Infinity War Blu-Ray"));
		storeItems.add(new StoreItem("6304811", "89.99", "HP All-In-One Instant Ink Printer"));
		return storeItems;
	}
	public static void displayStore(ArrayList<StoreItem> storeItems)
	{
		System.out.println("Available Store Items:");
		for(StoreItem item : storeItems)
		{
			System.out.println(item.toString());
		}
	}
	public static PurchasedItems addStoreItem(String itemCode, PurchasedItems pItems, ArrayList<StoreItem> storeItems)
	{
		PurchasedItems newPItems = pItems;
		System.out.println("Searching store for item number...");
		for(StoreItem item : storeItems)
		{
			if(item.getCode().equalsIgnoreCase(itemCode))
			{
				System.out.println("Adding " + item.getDescription() + " to your cart.");
				newPItems.addItem(item);
				return newPItems;
			}
		}
		return pItems;
	}
	public static ReceiptDate setDate(Scanner k)
	{
		ReceiptDate rd;
		//Enter date
		do
		{
			System.out.println("Please enter a day, month, and year (integers separated by spaces):");
			int[] date = new int[3];
			for(int i = 0; i < 3; i++)
				date[i] = k.nextInt();
			rd = new ReceiptDate(date[0], date[1], date[2]);
		}while(rd.getDay() > 31 || rd.getDay() < 1 || rd.getMonth() > 12 || rd.getMonth() < 1);
		
		//test if date entered correctly
		System.out.println("User Entered Date: " + rd.toString());
		
		return rd;
		
	}
	public static void clientLoop(Scanner k, ArrayList<StoreItem> storeItems, PurchasedItems pItems, ReceiptFactory rMaker, ReceiptDate rd)
	{
		int opt;
		Receipt r;
		do
		{

			displayInterface();
			
			do
			{
				opt = -1;
				if(k.hasNextInt())
					opt = k.nextInt();
			}while(opt < 1 || opt > 4);
			
			if(opt == 1)
				displayStore(storeItems);
			else if(opt == 2)
			{
				displayStore(storeItems);
				System.out.println("Enter an item number:");
				Integer ino = k.nextInt();
				PurchasedItems newPItems = addStoreItem(ino.toString(), pItems, storeItems);
				if(newPItems.equals(pItems)) //checks if a new PurchasedItems was returned
				{
					System.out.println("Item #" + ino + " added!");
					pItems = newPItems;
				}
				else
					System.out.println("Item not found...");
			}
			else if(opt == 3)
			{
				pItems.reset();
				if(!pItems.hasNext())
				{					
					System.out.println("No items in your shopping cart...");
				}
				else
				{
					System.out.println("\n****************\n--SHOPPING CART--\n****************");
					do
					{
						System.out.println(pItems.getNext().toString());
					}while(pItems.hasNext());
				}
			}
			else if(opt == 4)	
			{
				//could not separate creating and printing a receipt
				//condition to make receipt functional
				//BUT condition to print receipt could not know if receipt was initialized
				r = rMaker.getReceipt(pItems, rd);
				r.printReceipt();
			}
		}while(opt != 4);
		k.close();
		
	}
}
