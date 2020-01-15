
public class ProfessionalAddrLabel extends AddrLabel
{
	private String prosuf;
	private String ste;
	
	public ProfessionalAddrLabel(String prosuf, String ste, String name, String str,
			String cty, String sta, String zpc)
	{
		super(name, str, cty, sta, zpc);
		this.prosuf = prosuf;
		this.ste = ste;
	}

}
