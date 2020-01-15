/*adapter class, provides default implementation for everything from interface
with partial implementation here and other in subclasses*/
public abstract class AddrLabel implements AddrLabelInterface
{
	public final static String ems = "";
	
	private String name;
	private String str;
	private String cty;
	private String sta;
	private String zpc;
	
	public AddrLabel(String name, String str,
			String cty, String sta, String zpc)
	{
		this.name = name;
		this.str = str;
		this.cty = cty;
		this.sta = sta;
		this.zpc = zpc;
	}
    public String getTitle()
    { 
    	return ems; 
    }
    public String getNameSuffix()
    {
    	return ems;
    }
    public String getProfessionalSuffix()
    { 
    	return ems;
    }
    public String getSuiteNum()
    { 
    	return ems; 
    }

}
