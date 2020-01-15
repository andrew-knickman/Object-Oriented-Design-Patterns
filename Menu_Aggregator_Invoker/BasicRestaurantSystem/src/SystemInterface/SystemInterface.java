
package SystemInterface;

import Aggregator.*;
import Commands.Invoker;
import java.util.ArrayList;

/**
 *
 * @author dierbach
 */
public class SystemInterface {
    
    public static String[] getMenu(){
        Menu menu = Invoker.getMenu();
        
        ArrayList<String> displayLines = new ArrayList<>();
        
        menu.reset();
        while(menu.hasNext()){
            displayLines.add(menu.getNextItem().toString());
        }
        
        // convert ArrayList<String> to array of Strings
        return (String[]) displayLines.toArray();
    }
}
