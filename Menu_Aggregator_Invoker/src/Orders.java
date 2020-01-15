
public class Orders 
{
	private OrderItem[] oitems;
	private int current;
	
	public Orders()
	{
		oitems = new OrderItem[50];
		startOrders();
	}
	
	//copy
	public Orders(Orders otherOrders)
	{
		System.arraycopy(otherOrders.oitems, 0, oitems, 0, oitems.length);
	}
	
	public void addOrder(OrderItem item)
	{
		oitems[findEmpty()] = item;
	}
	public void reset()
	{
		current = 0;
	}
	public boolean hasNext()
	{
		if(current == oitems.length - 1)
			return false;
		return oitems[current + 1] != null;
	}
	public OrderItem getNextOrder()
	{
		return oitems[current++];
	}
	
	//private
	
	private void startOrders()
	{
		for(int i = 0; i < oitems.length; i++)
			oitems[i] = null;
	}
	private int findEmpty()
	{
		int i = 0;
		while(oitems[i] != null)
			i++;
		return i;
	}
}