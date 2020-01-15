package iterator;

class EvenValuesIterator implements IntListItrInterface 
{
	private int current_index;
	private RandomIntList list;
	
	public EvenValuesIterator(RandomIntList list)
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
	public boolean isEven()
	{
		if(this.list.list[current_index] % 2 == 0)
			return true;
		return false;
	}
	public int next()
	{
		if(hasNext())
		{
			if(!isEven())
				current_index++;
			else if(isEven())
			{
				int val = current_index;
				current_index++;
				return this.list.list[val];
			}
		}
		return -1;
	}
}
