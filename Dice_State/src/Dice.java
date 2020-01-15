import java.util.Random;

public class Dice 
{
// Context class - current roll of the dice
    
    private int current_roll;
    private State objState;
    private Random r;

    public Dice() 
    {
        objState = State.InitialState(this);
        r = new Random();
    }

    public void setState(State newState) 
    {
        objState = newState;
    }

    public State getState() {
        return objState;
    }

    public int getCurrentRoll() {
        return current_roll;
    }

    public void rollDice() {
        current_roll = generateRoll();
        System.out.print("rolled a " + current_roll + "\n");
        objState.roll_dice();
    }
    
    //randomly generated number between 2-12
    private int generateRoll()
    {
    	return (r.nextInt(11) + 2);
    }    
}
