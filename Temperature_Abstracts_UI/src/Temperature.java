
public abstract class Temperature 
{
	private double t;
	private String INV_MSG = 
			"This temperature is invalid for the" + getScale() + " scale.";
	public Temperature(double t)
	{
		setTemp(t);
	}
	public String setTemp(double t)
	{
		if(invalid())
			return INV_MSG;
		else
			this.t = t;
		return String.valueOf(t);
	}
	public double getTemp()
	{
		return t;
	}
	public String toString()
	{
		return getTemp() + " " + getScale().substring(0, 1);
	}
	public Temperature toCelsius()
	{
		if(this instanceof Fahrenheit)
			return new Celsius((getTemp() - 32) * 0.55);
		else if(this instanceof Kelvin)
			return new Celsius(getTemp() - 273.15);
		return new Celsius((getTemp()));
	}
	public Temperature toFahrenheit()
	{
		if(this instanceof Celsius)
			return new Fahrenheit((getTemp() * 1.8) + 32);
		else if(this instanceof Kelvin)
			return new Fahrenheit(getTemp() * (9/5) - 459.67);
		return new Fahrenheit(getTemp());
	}
	public Temperature toKelvin()
	{
		if(this instanceof Celsius)
			return new Kelvin(getTemp() + 273.15);
		else if(this instanceof Fahrenheit)
			return new Kelvin((getTemp() + 459.67) * (5/9));
		return new Kelvin(getTemp());
	}
	protected abstract boolean invalid();
	protected abstract String getScale();
	protected abstract boolean aboveBoiling();
	protected abstract boolean belowFreezing();
}