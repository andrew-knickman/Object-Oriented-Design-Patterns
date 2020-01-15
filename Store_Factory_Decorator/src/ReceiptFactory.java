import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReceiptFactory 
{
	StoreHeader store_header;
	private TaxComputationMethod[] tcms;
	private AddOn[] aos;
	private TaxComputationMethod stateTCM;
	File config;
	Scanner sc;
	
	public ReceiptFactory() throws FileNotFoundException
	{
		//Populate arrays for TaxComputationMethod and AddOn
		tcms = new TaxComputationMethod[3];
		tcms[0] = new MDTax();
		tcms[1] = new MATax();
		tcms[2] = new VATax();
		
		aos = new AddOn[4];
		aos[0] = new CouponTenOff();
		aos[1] = new CouponFiftyOff();
		aos[2] = new HolidayGreeting();
		aos[3] = new XboxRebate();
		
		//Read information from config file.
		config = new File("C:/Users/Andrew Knickman/Documents/TU Fall 2018/COSC 436/COSC 436 Workspace/COSC 436 Assignment 4/src/config.txt");
		sc = new Scanner(config);
		store_header = new StoreHeader(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		
		if(store_header.getState().equalsIgnoreCase("MD"))
			stateTCM = tcms[0];
		else if(store_header.getState().equalsIgnoreCase("MA"))
			stateTCM = tcms[1];
		else if(store_header.getState().equalsIgnoreCase("VA"))
			stateTCM = tcms[2];
	}
	public Receipt getReceipt(PurchasedItems items, ReceiptDate date)
	{
		BasicReceipt newReceipt = new BasicReceipt(items, date);
		newReceipt.setStoreHeader(store_header);
		newReceipt.setTaxMethod(stateTCM);
		for(int i = 0; i < aos.length; i++)
		{
			if(aos[i].applies(items))
			{
				if(aos[i] instanceof SecondaryHeader)
					return new PreDecorator(newReceipt, aos[i]);
				if(aos[i] instanceof Rebate || aos[i] instanceof Coupon)
					return new PostDecorator(newReceipt, aos[i]);
			}
		}
		return newReceipt;
	}

}
