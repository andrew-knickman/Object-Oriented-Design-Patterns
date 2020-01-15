

public class ComingOutState extends State 
{
// ------------------------------------------------------------------------
// First roll of dice:
//    2,3, or 12 Loss ("craps")  
//    7 or 11 Win ("natural")
//    any other (4,5,6,8,9,10) establishes "points"
// ------------------------------------------------------------------------
    private int roll;

    public ComingOutState(Dice dice) 
    {
        super(dice);
    }
    
     public ComingOutState(State source) 
     {
        super(source);
        System.out.println("I'm in coming out state's alternate constructor");
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    } 
     
    //transitions to either a Win, Loss or Points state 
    public void transitionState() 
    {
    	System.out.println("(COS Transition)");
    	roll = super.getContext().getCurrentRoll();
    	if(roll == 2 || roll == 3 || roll == 12)
    		super.getContext().setState(new Loss(super.getContext()));
    	else if(roll == 7 || roll == 11)
    		super.getContext().setState(new Win(super.getContext()));
    	else
    		super.getContext().setState(new PointState(super.getContext().getState()));
    }    
}
