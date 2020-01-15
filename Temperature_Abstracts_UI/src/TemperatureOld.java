
public class TemperatureOld 
{
	private double t;
	private Character type;
	
	public TemperatureOld(double t, Character type)
	{
		this.t = t;
		this.t = checkType(type);
	}
	public void setTemp(double t)
	{
		this.t = t;
	}
	public void setType(Character type)
	{
		//checks for different type, nothing if same type passed
		if(!this.type.equals(type))
		{
			type = checkType(type);
			convertTemp(type);
		}
	}
	public double getTemp()
	{
		return t;
	}
	public Character getType()
	{
		return type;
	}
	public String toString()
	{
		return "Temperature: " + String.valueOf(t) + " " + type;
	}
	public String aboveBoiling()
	{
		//convert to F for check, then return to original type
		Character tmpType = this.type;
		convertTemp('F');
		if(t > 212)
				return "Above Boiling";
		convertTemp(tmpType);
		return "N/A";
	}
	public String belowFreezing()
	{
		//convert to F for check, then return to original type
		Character tmpType = this.type;
		convertTemp('F');
		if(t < 32)
			return "Below Freezing";
		convertTemp(tmpType);
		return "N/A";
	}
	private Character checkType(Character type)
	{
		//defaults to F on invalid type (protect convertTemp() from invalid type)
		if(!type.equals('F') || !type.equals('C') || !type.equals('F'))
			return 'F';
		return type;
	}
	private void convertTemp(Character type)
	{
		//checks for different type, nothing if same type passed
		type = checkType(type);
		if(this.type.equals('F'))
		{
			if(type == 'C')
			{
				this.t = ((this.t - 32)*5)/9;
				this.type = 'C';
			}
			else if(type == 'K')
			{
				this.t= (((this.t - 32)*5)/9) + 273.15;
				this.type = 'K';
			}	
		}
		else if(this.type.equals('C'))
		{
			if(type == 'F')
			{
				this.t = ((this.t * 9)/5) + 32;
				this.type = 'F';
			}
			else if(type == 'C')
			{
				this.t = ((this.t + 273.15));
				this.type = 'C';
			}
		}
		else if(this.type.equals('K'))
		{
			if(type == 'F')
			{
				this.t = (((this.t - 273.15)*9)/5) + 32;
				this.type = 'F';
			}
			else if(type == 'C')
			{
				this.t = (this.t - 273.15);
				this.type = 'C';
			}
		}
	}
}
