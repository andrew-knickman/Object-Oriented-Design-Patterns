
public class StoreHeader 
{
	private String grt; //greeting
	private String adr; //address
	private String zip; //zip code
	private String state;
	private String pho; //phone number
	private String sto; //store number
	
	//test header
	public StoreHeader()
	{
		grt = "Welcome to Best Buy!";
		adr = "123 Main St., SomeTown";
		zip = "21455";
		state = "MD";
		pho = "410-704-5555";
		sto = "2018";
	}
	public StoreHeader(String grt, String adr, String state, String zip, String sto, String pho)
	{
		this.grt = grt;
		this.adr = adr;
		this.state = state;
		this.zip = zip;
		this.sto = sto;
		this.pho = pho;
	}
	public String getState()
	{
		return state;
	}
	public String toString()
	{
		return 	grt
				+ "\nBEST BUY \t Store #" + sto 
				+ "\n" + adr + ", " + state + ", " + zip + "\t" + pho;  
	}

}
