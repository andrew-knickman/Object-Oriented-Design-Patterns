package iterator;

class AllValuesIterator implements IntListItrInterface 
{
	private int current_index;
	private RandomIntList list;
	
	public AllValuesIterator(RandomIntList list)
	{
		current_index = 0;
		this.list = list;
	}
	
	public boolean hasNext()
	{
		if((current_index + 1) < this.list.list.length)
			return true;
		return false;
	}
	
	public int next()
	{
		if(hasNext())
		{
			return this.list.list[current_index++];
		}
		return -1;
	}
}
