
public class CompanyAddrLabel extends AddrLabel
{
	
	private String attnName;
	private String cmpName;
	
	private String name;
	private String str;
	private String cty;
	private String sta;
	private String zpc;
	
	public CompanyAddrLabel(String attnName, String cmpName, String str, 
			String name, String cty, String sta, String zpc)
	{
		super(name, str, cty, sta, zpc);

		this.attnName = attnName;
		this.cmpName = cmpName;
	}
	public String getAttnName()
	{
		return ems;
	}
	public String getCompany()
	{
		return ems;
	}
	public String getName()
	{
		return ems;
	}
	public String getStreet()
	{
		return ems;
	}
	public String getCity()
	{
		return ems;
	}
	public String getState()
	{
		return ems;
	}
	public String getZipCode()
	{
		return ems;
	}
}
