/*non-functional example code*/
public class BusinessAccount 
{
	public static final double MIN_BALANCE = 1000.0;
	...
	private State objState;
	private String acctNum;
	private double balance;
	public void setState(States){}
	public State getState()
	public double getBalance(){}
	...
	public boolean deposit(double amt){}
	public boolean withdraw(double amt){}
	public BusinessAccount(String actNum)
	{
		this.actNum = actNum;
		objState = State.InitialState();
	}
}
public class State
{
	private BusinessAccount context;
	public BusinessAccount getContext(){}
	public void setContext(BusinessAccount newAct){}
	public State transitionState(){}//abstract
	public State(State source){}//constructor
	public State(BusinessAccount act){}//constructor
	public static State IntialState(BusinessAccount act)()
	public boolean deposit(double amt)
	{
		double balance = getContext().getBalance();
		getContext().setBalance(balance + amt);
		transitionState();
		System.out.println("An amt of " + amt);
		return true;
	}
}
public class NoTransactionFeeState extends State
{
	public NoTransactionFeeState (BusinessAccount act){}
	public NoTransactionFeeState (State source){}
	public boolean deposit(double amt){super.deposit(amt);}
	public boolean withdraw(double amt)
	{
		double balance = getContext().getBalance();
		if((balance - amt) > BusinessAccount.OVERDRAW_LIMIT)
		{
			super.withdraw(amt);
			return true;
		}
		else
			System.out.println(BusinessAccount.ERR_OVERDRAW_LIMIT_EXCEEDED);;
			return false;
	}
	public State transitionState()
	{
		double balance = getcontext().getBalance();
		if(balance < 0)
		{
			getContext().setState(new OVerDrawnState(this));		
		}
		else
		{
			if(balance < BusinessAccount.MIN_BALANCE)
			{
				getContext().set(new TransactionFeeState(this));
			}
		}
		return getContext.getState();
	}
}