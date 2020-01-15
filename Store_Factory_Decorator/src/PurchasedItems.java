import java.util.ArrayList;

public class PurchasedItems 
{
		private ArrayList<StoreItem> items;
		int current;
		double total;
		
		public PurchasedItems()
		{
			items = new ArrayList<StoreItem>();
			current = 0;
			total = 0.0;
		}
		public void addItem(StoreItem newItem)//with params
		{
			items.add(newItem);
			total += Double.parseDouble(newItem.getPrice());
		}
		public double getTotalCost()
		{
			return total;
		}
		public boolean containsItem(String itemCode)
		{
			reset();
			boolean match = false;
			do
			{
				if(getNext().getCode().equalsIgnoreCase(itemCode))
					match = true;
			}
			while(match == false);
			return match;		
		}
		public void reset()
		{
			current = 0;
		}
		public boolean hasNext()
		{
			if(items.size() <= current + 1)//may need to be <=
				return false;
			return true;
		}
		public StoreItem getNext()
		{
			if(current < items.size())
				current++;
			return items.get(current);
		}
}
