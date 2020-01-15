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
			do
			{
				displayOptions();
				int opt = getOption();
				switch(opt)
				{
				case 1: addAsset(); break;
				case 2: addLiability(); break;
				case 3: getNetWorth(); break;
				case 4: System.out.println("Goodbye!"); go = false;
				}
			}while(go);
		}
		private int getOption()
		{
			int opt = -1;
			Scanner k = new Scanner(System.in);
			do
			{
				if(k.hasNextInt())
					opt = k.nextInt();
			}while(opt < 1 || opt > 4);

			return opt;
		}
		private void displayOptions()
		{
			System.out.println("\n1 - Add Asset"
					+ "\n2 - Add Liability"
					+ "\n3 - View Net Worth Details");
		}
		private String addAsset()
		{
			Scanner k = new Scanner(System.in);
			System.out.println("Enter Asset Name:");
			String name = k.nextLine();
			System.out.println("Enter Asset Value:");
			Double value = k.nextDouble();
			String assets;
			assets = si.addItem(name, value);
			
			System.out.println("Your Assets:\n" + assets);
			return assets;
		}
		private String addLiability()
		{
			Scanner k = new Scanner(System.in);
			System.out.println("Enter Liability Name:");
			String name = k.nextLine();
			System.out.println("Enter Liability Cost:");
			Double value = k.nextDouble();
			String liabilities;
			liabilities = si.addLiability(name, value);
			
			System.out.println("Your Liabilities:\n" + liabilities);
			return liabilities;
		}
		private Double getNetWorth()
		{
			System.out.println("---ASSETS---\n" + si.getAssets());
			System.out.println("\n---LIABILITIES---\n" + si.getLiabilities());
			Double nw = si.getNetWorth();
			System.out.println("\nYour Net Worth:\n$" + nw);
			return nw;
		}
		
}
