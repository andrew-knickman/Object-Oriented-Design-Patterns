package iterator;
import java.util.Random;
public class RandomIntList 
{
	int[] list;
	Random r = new Random();
	
	//initializes a list of length 'size' and fills it w/ values from 1-100
	public RandomIntList(int size)
	{
		list = new int[size];
		initList();
	}
	public IntListItrInterface getAllValuesIterator()
	{
		return new AllValuesIterator(this);
	}
	public IntListItrInterface getEvenValuesIterator()
	{
		return new EvenValuesIterator(this);
	}
	public IntListItrInterface getFibonacciIterator()
	{
		return new FibonacciIterator(this);
	}
	private void initList()
	{
		for(int i = 0; i < list.length; i++)
		{
			list[i] = r.nextInt(100) + 1;
		}
	}

}
