/**
 * Created by Karoon on 4/10/2017.
 */

import java.util.Scanner;
import java.util.InputMismatchException;
public class DFA_Algorithm {
    public static void main (String [] args){
        // Method to construct the DFA
        if(checkString(constructDFA())){
            System.out.println("String was accepted by the constructed DFA!" );
        }else{System.out.println("String was not accepted by the constructed DFA!");}
    }
    public static State [] constructDFA(){
        // Initialize the variables
        int numStates = -1, numAcceptingStates = 0 , zeroConnection = 0 , oneConnection = 1;
        // Initialize the Scanner
        Scanner input = new Scanner(System.in);

        // Ask the user for the number of states. Check and Validate that it is greater than 0 and less than or equal to 20
        System.out.print("Number of States (Less than 20): ");
        while(numStates <= 0 || numStates > 20){
            boolean check = false;
            try {
                numStates = input.nextInt();
                if(numStates<=0 || numStates >20){check = true;}else{check = false;}
            }catch(InputMismatchException e){System.out.println("Incorrect input. Exiting. "); System.exit(0);}
            if(check){System.out.print("Input has to be less than 20 and greater than 0.\nNumber of States (Less than 20): ");}
        }
        // Initialize the array with total number of states
        State [] totalStates = new State[numStates];
        for(int y = 0; y<numStates; y++){
            totalStates[y] = new State();
        }
        // Loop until there is a connection for every state with input validation
        while(totalStates[totalStates.length-1].getOutGoingOneState() == 0){
            for(int x = 0; x < numStates; x++){
                System.out.print("Enter the state "+ (x+1) + " goes to with a symbol 0(1 to " + numStates +"): ");
                try {
                    zeroConnection = input.nextInt();
                }catch(InputMismatchException e){System.out.println("Not a valid input. Exiting.");}
                while(!getValidState(zeroConnection, numStates)){
                    System.out.print("Enter the state "+ (x+1) + " goes to with a symbol 0(1 to " + numStates +"): ");
                    try {
                        zeroConnection = input.nextInt();
                    }catch(InputMismatchException f){System.out.println("Not a valid input. Exiting.");}
                }
                System.out.print("Enter the state "+ (x+1) + " goes to with a symbol 1(1 to " + numStates +"): ");
                try{
                    oneConnection = input.nextInt();
                }catch(InputMismatchException e){System.out.println("Not a valid input. Exiting.");}
                while(!getValidState(oneConnection, numStates)){
                    System.out.print("Enter the state "+ (x+1) + " goes to with a symbol 1(1 to " + numStates +"): ");
                    try{
                        oneConnection = input.nextInt();
                    }catch(InputMismatchException e){System.out.println("Not a valid input. Exiting.");}
                }
                totalStates[x].setState(x+1, false, zeroConnection, oneConnection);

            }
        }
        // Get the set of accepting states with -1 being the termination variable
        while(numAcceptingStates != -1 ){
            try{
                while(!getValidState(numAcceptingStates, numStates)){
                    System.out.print("Please enter valid accepting states (-1 to exit): ");
                    numAcceptingStates = input.nextInt();
                }
                totalStates[numAcceptingStates-1].setAcceptingState(true);
                numAcceptingStates = input.nextInt();
            }catch (InputMismatchException g){System.out.println("Not a valid input. Exiting."); System.exit(0);}
        }
        System.out.println("DFA Constructed!");
        printDFA(totalStates);
        return totalStates;
    }

    public static boolean checkString(State [] DFAStates){
        // Initialize Variables
        String userInput = "";
        int currentState = 0;
        // Method to check if a string is in the constructed DFA
        Scanner userInputString = new Scanner(System.in);
        // Get the input string from the user
        System.out.print("Please enter a string: ");
        userInput = userInputString.nextLine();
        // Loop through the string
        for(int counter = 0; counter<userInput.length(); counter++){
            if(userInput.charAt(counter) == '0'){
                currentState = DFAStates[currentState].getOutGoingZeroState()-1;
            }
            if(userInput.charAt(counter) == '1'){
                currentState = DFAStates[currentState].getOutGoingOneState()-1;
            }
        }
        // Close Scanner
        userInputString.close();
        // Return Scanner
        if(DFAStates[currentState].getAcceptingState()){return true;} else{return false;}

    }
    // Check if the State entered is a valid state
    public static boolean getValidState(int num, int size){
        if(num<=size && num > 0)
            return true;
        return false;
    }
    // Print the DFA
    public static void printDFA(State []States){
        for(State q: States){
            q.Print();
        }
    }
}
