package iterator;

class FibonacciIterator implements IntListItrInterface
{
	private int current_index;
	private RandomIntList list;
	private int prev_sum;
	
	public FibonacciIterator(RandomIntList list)
	{
		current_index = 2;
		prev_sum = 0;
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
			int v1 = this.list.list[current_index - 2];
			int v2 = this.list.list[current_index - 1];
			if(prev_sum == 0)
				prev_sum = v1 + v2;
			else
				prev_sum += v2;
			current_index++;
			return (prev_sum);
		}
		return -1;
	}
}
