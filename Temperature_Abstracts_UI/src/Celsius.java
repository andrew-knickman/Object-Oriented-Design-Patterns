
public class Celsius extends Temperature
{
	public static final double ABSO_ZRO = -273.0;
	public static final double BOIL_PNT = 100.0;
	public static final double FREZ_PNT = 0.0;
	public static final String SCALE = "C";
	
	public Celsius(double t)
	{
		super(t);
	}
	protected boolean invalid()
	{
		if(super.getTemp() < ABSO_ZRO)
			return true;
		return false;
	}
	protected String getScale()
	{
		return SCALE;
	}
	protected boolean aboveBoiling()
	{
		if(super.getTemp() > BOIL_PNT)
			return true;
		return false;
	}
	protected boolean belowFreezing()
	{
		if(super.getTemp() < FREZ_PNT)
			return true;
		return false;
	}
}
