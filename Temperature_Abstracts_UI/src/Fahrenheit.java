
public class Fahrenheit extends Temperature
{
	public static final double ABSO_ZRO = -459.67;
	public static final double BOIL_PNT = 212.0;
	public static final double FREZ_PNT = 32.0;
	public static final String SCALE = "F";

	public Fahrenheit(double t)
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
