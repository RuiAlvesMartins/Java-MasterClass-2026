package section16.Challenges.GameConsole;

import java.util.function.Predicate;

//todo? 
public record GameAction(char key, String prompt, Predicate<Integer> action) {
    
    //  key: button user must press to select the action;
    //  prompt: message displayed to the user to describe the action;
    //  action: will return boolean, int is player index;

}
