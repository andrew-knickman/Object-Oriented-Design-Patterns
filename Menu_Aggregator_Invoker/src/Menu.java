
public class Menu 
{
	private MenuItem[] mitems;
	private int current;
	
	public Menu()
	{
		mitems = new MenuItem[20];
		startMenu();
	}
	
	//copy
	public Menu(Menu otherMenu)
	{
		int i = 0;
		while(otherMenu.hasNext())
		{

			mitems[i] = otherMenu.getNextItem();
			i++;
			
		}
		/*if(!otherMenu.hasNext())
			otherMenu = new Menu();
		mitems = System.arraycopy(otherMenu.mitems, 0, mitems, 0, mitems.length);*/
		//System.arraycopy(otherMenu.mitems, 0, mitems, 0, mitems.length);
	}
	
	public void addItem(MenuItem item)
	{
		mitems[findEmpty()] = item;
	}
	public void reset()
	{
		current = 0;
	}
	public boolean hasNext()
	{
		if(current == mitems.length - 1)
			return false;
		return mitems[current + 1] != null;
	}
	public MenuItem getNextItem()
	{
		return mitems[current++];
	}
	
	//private
	
	private void startMenu()
	{
		for(int i = 0; i < mitems.length; i++)
			mitems[i] = null;
	}
	private int findEmpty()
	{
		int i = 0;
		while((i < mitems.length) && (mitems[i] != null))
			i++;
		return i;
	}

}
