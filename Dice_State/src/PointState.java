

public class PointState extends State 
{
// ------------------------------------------------------------------------
// Second roll of dice:
//    7 Loss ("seven out")
//    match of previous roll Win ("hits the points")
//    any other, roll again
// ------------------------------------------------------------------------    
    private int points_to_match;

    public PointState(State source) 
    {
        super(source);
        points_to_match = source.getContext().getCurrentRoll();
    }
    
    public PointState(Dice dice) {
        super(dice);
        System.out.println("I'm in point state's alternate constructor!");
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }
    
    //transitions to either a Win or Loss state    
    public void transitionState() 
    {
    	System.out.println("(PTS Transition)");
    	if(super.getContext().getCurrentRoll() == 7)
    		super.getContext().setState(new Loss(super.getContext()));
    	else if(super.getContext().getCurrentRoll() == points_to_match)
    		super.getContext().setState(new Win(super.getContext()));
    	else
    		super.getContext().setState(new PointState(super.getContext().getState()));
    }
}
