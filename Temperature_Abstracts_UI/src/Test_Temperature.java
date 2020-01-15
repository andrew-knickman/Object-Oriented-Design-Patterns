import java.util.Scanner;

public class Test_Temperature 
{
	public static void main(String[] args) 
	{
		boolean r = true;//run
		int o = -1; //option
		Scanner k = new Scanner(System.in);
		Temperature temp = getValue(k, getScale(k));
		
		do
		{
			o = menu(k);
			if(o == 2)
				temp = temp.toFahrenheit();
			else if(o == 3)
				temp = temp.toCelsius();
			else if(o == 4)
				temp = temp.toKelvin();
			else if(o == 5)
			{
				System.out.println("Enter a new value:");
				temp.setTemp(k.nextDouble());
			}
			System.out.println(temp.toString());
			
			System.out.println("Continue? (Y/N)");
			if(k.next().equalsIgnoreCase("n"))
				r = false;
		}while(r);
		
		k.close();
	}
	public static String getScale(Scanner k)
	{
		String s = "";

		System.out.println("Enter a scale (C, F, or K):");
		s = k.next();
		if(!(s.equalsIgnoreCase("C")||s.equalsIgnoreCase("F")||s.equalsIgnoreCase("K")))
				System.out.println("Invalid scale! Defaulting to K.");
		/*
		do
		{
			System.out.println("Enter a scale");
			s = k.next();
		}while(!s.equalsIgnoreCase("c") 
				|| !s.equalsIgnoreCase("k") 
				|| !s.equalsIgnoreCase("f"));*/
		return s;
		
	}
	public static Temperature getValue(Scanner k, String s)
	{
		Temperature temp;
		double t;

		System.out.println("Enter a value:");
		t = k.nextDouble();
		if(s.equalsIgnoreCase("c"))
			temp = new Celsius(t);
		else if(s.equalsIgnoreCase("f"))
			temp = new Fahrenheit(t);
		else
			temp = new Kelvin(t);
		/*
		do
		{
			System.out.println("Enter a value:");
			t = k.nextDouble();
			if(s.equalsIgnoreCase("c"))
				temp = new Celsius(t);
			else if(s.equalsIgnoreCase("f"))
				temp = new Fahrenheit(t);
			else
				temp = new Kelvin(t);
		}while(!temp.invalid());*/
		
		return temp;	
	}
	public static int menu(Scanner k)
	{
		int o = -1;

		System.out.println("Select one of the following options:"
				+ "\n1 - Get Temperature"
				+ "\n2 - Convert To Fahrenheit"
				+ "\n3 - Convert To Celsius"
				+ "\n4 - Convert To Kelvin"
				+ "\n5 - Set Temperature");
		o = k.nextInt();
		/*do
		{
			System.out.println("Select one of the following options:"
					+ "\n1 - Get Temperature"
					+ "\n2 - Convert To Fahrenheit"
					+ "\n3 - Convert To Celsius"
					+ "\n4 - Convert To Kelvin"
					+ "\n5 - Set Temperature");
			opt = k.nextInt();
		}while(opt != 1 || opt != 2 || opt != 3 || opt != 4 || opt != 5);*/
		return o;
	}
}
