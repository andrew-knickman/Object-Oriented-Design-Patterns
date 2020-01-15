import java.util.Scanner;
import java.util.Random;

public class GameOfCraps {

    public static void main(String[] args) 
    {
 
        int wgr = 0;
        int plyrWngs = 100;
        int compWngs = 100;
        int numGames = 0;
        Scanner k = new Scanner(System.in);
        Random r = new Random();
        
        final int MAX_wgr = 100;
        Dice dice;
        
        do
        {
            numGames = promptForNumGames(k, numGames);
        }while(numGames <= 0);
        
        System.out.println("You have chosen " + numGames + " games!");
    	System.out.println("\n**********GAME START**********");

        for(int i = 1; i <= numGames; i++)
        {
        	System.out.println("\nROUND " + i);
        	System.out.println("The player has: $" + plyrWngs);
        	System.out.println("The computer has: $" + compWngs);
            // HUMAN'S ROUND
            System.out.println("\n---PLAYER TURN---");
        	wgr = getHumanswgr(k, MAX_wgr, wgr);
            dice = new Dice();
            playRound("PLAYER", dice);

            if(dice.getState() instanceof Win)
        	{
            	System.out.println("Player WIN: +$" + wgr);
            	plyrWngs = plyrWngs + wgr;
        	}
            else
            {
            	System.out.println("Player LOSS: -$" + wgr);
                plyrWngs = plyrWngs - wgr;
            }

            // COMPUTER'S ROUND
            System.out.println("\n---COMPUTER TURN---");
            wgr = randomWager(r, MAX_wgr, wgr);
            System.out.println("The computer wages $" + wgr);
            dice = new Dice();
            playRound("COMPUTER", dice);

            if(dice.getState() instanceof Win)
            {
            	
            	System.out.println("Computer WIN: +$" + wgr);
                compWngs = compWngs + wgr;
            }
            else
            {
            	System.out.println("Computer LOSS: -$" + wgr);
            	compWngs = compWngs - wgr;
            }
        }  
    	System.out.println("**********GAME END**********");
    	System.out.println("\nFINAL RESULTS");
    	System.out.println("PLAYER: $" + plyrWngs);
    	System.out.println("COMPUTER: $" + compWngs);
        k.close();
    } 
        
    public static int promptForNumGames(Scanner k, int numGames)
    { 
    	System.out.println("How many games are you playing?");
    	numGames = k.nextInt();
    	return numGames;
    }

    public static int getHumanswgr(Scanner k, double max_wgr, int wgr)
    {
    	do
    	{
        	System.out.printf("\nWhat do you wager? (Can't exceed $%.2f)", max_wgr);
        	wgr = k.nextInt();
    	}while(wgr > max_wgr);
    	return wgr;
    }

    public static int randomWager(Random r, int max_wgr, int wgr)
    {
    	wgr = r.nextInt(max_wgr) + 1;
    	return wgr;
    }

    public static void playRound(String name, Dice dice)
    {
    	//play until win or loss occurs
        while(!(dice.getState() instanceof Win) && !(dice.getState() instanceof Loss))
        {
        	System.out.print(name + " ");
        	dice.rollDice();
        }
    }
}
