import java.util.ArrayList;

public class Liabilities 
{
	private ArrayList<LiabilityItem> liabilities;
	public Liabilities()
	{
		liabilities = new ArrayList<LiabilityItem>();
		populate();
	}
	private void populate()
	{
		liabilities.add(new LiabilityItem("Student Debt", 20000.00));
		liabilities.add(new LiabilityItem("Mortgage", 500000.00));
		liabilities.add(new LiabilityItem("Car Payments", 3000.00));
	}
	public void addItem(LiabilityItem l)
	{
		liabilities.add(l);
	}
	public double total()
	{
		Object[] liabilitylist = liabilities.toArray();
		double total = 0.0;
		for(int i = 0; i < liabilitylist.length; i++)
		{
			LiabilityItem l = (LiabilityItem) liabilitylist[i];
			total += l.getValue();
		}
		return total;
	}
	public String toString()
	{
		Object[] liabilitylist = liabilities.toArray();
		String all_Liabilities = "";
		for(int i = 0; i < liabilitylist.length; i++)
		{
			LiabilityItem current = (LiabilityItem) liabilitylist[i];
			all_Liabilities = all_Liabilities + current.toString() + "\n";
		}
		all_Liabilities = all_Liabilities + "\nLiability Total: $" + total();

		return all_Liabilities;
	}

}
