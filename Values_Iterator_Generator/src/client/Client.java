package client;
import iterator.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) 
	{
		RandomIntList rList = new RandomIntList(20);
		IntListItrInterface itr = rList.getAllValuesIterator();
		Scanner k = new Scanner(System.in);
		int o = -1;
		
		do
		{
			o = displayMenu(o, k);
			if(o == 1)
				itr = rList.getAllValuesIterator();
			else if(o == 2)
				itr = rList.getEvenValuesIterator();
			else if(o == 3)
			{
				itr = rList.getAllValuesIterator();
				System.out.println("\nOriginal List:");
				displayIterator(itr);
				System.out.println("\nFibonacci Sequence:");
				itr = rList.getFibonacciIterator();
			}
			if(o != 4)
				displayIterator(itr);
		}while(o != 4 || o == -1);
		
		System.out.println("Goodbye!");
		
		k.close();
	}
	public static int displayMenu(int o, Scanner k)
	{
		do
		{
			System.out.println("\nChoose an Iterator:");
			System.out.println("1 - All Values"
					+ "\n2 - Even Values"
					+ "\n3 - Fibonacci"
					+ "\n4 - Quit");
			o = k.nextInt();
		}while(o < 1 && o > 4);
		return o;
	}
	public static void displayIterator(IntListItrInterface itr)
	{
		int linect = 0;
		int val;
		System.out.print("[");
		while(itr.hasNext())
		{
			val = itr.next();
			if(val != -1)
			{
				System.out.print(val + ", ");
				linect++;
			}
			if(linect == 10)
			{
				System.out.println();
				linect = 0;
			}
		}
		System.out.print("]");
	}
}
