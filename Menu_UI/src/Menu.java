
public class Menu 
{
	public static final int APPETIZERS = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	
	public static final boolean HEART_HEALTHY = true;
	
	private MenuItem[] items;
	
	public Menu()
	{
		items = new MenuItem[0];
	}
	
	//Append Item Method
	public void addItem(MenuItem item)
	{
		//create temporary items list at items length n + 1
		MenuItem[] tempItems = new MenuItem[(items.length + 1)];
		
		//fill tempItems with items
		for(int i = 0; i < items.length; i++)
			tempItems[i] = items[i];
		
		//replace items with new items array at length n + 1
		items = new MenuItem[tempItems.length];
		
		//fill items in new array with temporary items
		for(int j = 0; j < tempItems.length; j++)
			items[j] = tempItems[j];
		
		//fill last item in new items array with appended MenuItem
		items[tempItems.length - 1] = item;
	}

	//Delete Methods
	public void deleteItemByNumber(int delIno)
	{
		MenuItem[] tempItems = new MenuItem[(items.length - 1)];
		
		for(int i = 0; i < items.length; i++)
		{
			if(delIno == items[i].getItemNumber())
				items[i].emptyItem();
		}
		
		for(int j = 0; j < tempItems.length; j++)
		{
			if(items[j].getItemNumber() != -1)
				tempItems[j] = items[j];
		}
		
		items = new MenuItem[tempItems.length];
		
		for(int k = 0; k < tempItems.length; k++)
			items[k] = tempItems[k];	
	}
	public void deleteItemByPointer(int index)
	{
		MenuItem[] tempItems = new MenuItem[(items.length - 1)];

		items[index].emptyItem();
		
		for(int i = 0; i < items.length; i++)
		{
			if(items[i].getItemNumber() != -1)
				tempItems[i] = items[i];
		}
		
		items = new MenuItem[tempItems.length];
		
		for(int j = 0; j < tempItems.length; j++)
			items[j] = tempItems[j];
	}
	
	//Factory Getters
	public AllItemsIterator getAllItemsIterator()
	{
		return new AllItemsIterator();
	}
	public ItemIterator getItemIterator(int cat)
	{
		return new ItemIterator(cat);
	}
	public HeartHealthyIterator getHeartHealthyIterator()
	{
		return new HeartHealthyIterator();
	}
	public PriceIterator getPriceIterator(double pri)
	{
		return new PriceIterator(pri);
	}
	
	//Inner Classes
	private class AllItemsIterator implements MenuInterface
	{
		private int index;
		public AllItemsIterator()
		{
			index = 0;
		}
		public boolean hasNext()
		{
			while(index < items.length && !items[index].isEmpty())
			{
				return true;
			}
			return false;
		}
		public MenuItem next()
		{
			if(hasNext())
			{
				MenuItem mi = items[index];
				index++;
				return mi;
			}
			return new MenuItem();
		}
	}
	private class ItemIterator implements MenuInterface
	{
		private int cat;
		private int index;
		
		public ItemIterator(int cat)
		{
			this.cat = cat;
			index = 0;
		}
		public boolean hasNext()
		{
			while(index < items.length && !items[index].isEmpty())
			{
				if(items[index].getCategory()==cat)
					return true;
				index++;
			}
			return false;
		}
		public MenuItem next()
		{
			if(hasNext())
			{
				MenuItem mi = items[index];
				index++;
				return mi;
			}
			return new MenuItem();
		}
	}
	private class HeartHealthyIterator implements MenuInterface
	{
		private boolean hrt;
		private int index;
		public HeartHealthyIterator()
		{
			this.hrt = true;
			index = 0;
		}
		public boolean hasNext()
		{
			while(index < items.length && !items[index].isEmpty())
			{
				if(items[index].isHeartHealthy())
					return true;
				index++;
			}
			return false;
		}
		public MenuItem next()
		{
			if(hasNext())
			{
				MenuItem mi = items[index];
				index++;
				return mi;
			}
			return new MenuItem();
		}
	}
	private class PriceIterator implements MenuInterface
	{
		private double pri;
		private int index;
		public PriceIterator(double pri)
		{
			this.pri = pri;
			index = 0;
		}
		public boolean hasNext()
		{
			while(index < items.length && !items[index].isEmpty())
			{
				if(items[index].getPrice() < pri && items[index].getCategory() == MAIN_DISH)
					return true;
				index++;
			}
			return false;
		}
		public MenuItem next()
		{
			if(hasNext())
			{
				MenuItem mi = items[index];
				index++;
				return mi;
			}
			return new MenuItem();
		}
	}
}
