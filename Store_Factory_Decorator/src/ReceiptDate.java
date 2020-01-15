
public class ReceiptDate 
{
	int day;
	int mon;
	int year;
	
	public ReceiptDate(int day, int mon, int year)
	{
		this.day = day;
		this.mon = mon;
		this.year = year;
	}
	public int getDay()
	{
		return day;
	}
	public int getMonth()
	{
		return mon;
	}
	public int getYear()
	{
		return year;
	}
	public String toString()
	{
		return mon + "/" + day + "/" + year;
	}
}
