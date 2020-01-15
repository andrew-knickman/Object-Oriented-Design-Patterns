
public class Client {

	public static void main(String[] args) 
	{
		Aggregator agg = new Aggregator();
		Invoker ivkr = new Invoker(agg);
		SystemInterface si = new SystemInterface(ivkr);
		UserInterface ui = new UserInterface(si);
		ui.start();
	}

}
