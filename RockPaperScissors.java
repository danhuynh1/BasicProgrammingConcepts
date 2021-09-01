import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    static String[] choicesRPS = {"Rock","Paper","Scissors"};
    public static void main(String[] args){
        playGame();
    }
    /**
     * Method to initiate a RPS game for (1-10) rounds, and displays a count 
     *  
     **/
    public static void playGame(){
        Scanner sc = new Scanner(System.in);
        //initializing variables 
        int userWins =0 ,computerWins = 0, ties = 0;
        int userChoice,opponentChoice;
        Random opponent = new Random();
        boolean playAgain; 

        int rounds = getIntFromUser(sc, "How many rounds would you like to play?");
        
        //Maximum number of rounds = 10, minimum number of rounds = 1.  If the user asks for something outside this range, the program prints an error message and quits.
        if(rounds<=10 && rounds > 1){
            for (int i = 0 ; i<rounds;i++){
                System.out.println("Round " + (i+1));

                //Uses method to force user input from 1-3, representing RPS respectively
                userChoice = getIntRPSFromUser(sc, "Your choice? (1:Rock, 2:Paper, 3:Scissors)");
                opponentChoice = (opponent.nextInt(3) + 1);
                System.out.printf("\nYou chose %s and I chose %s... ",choicesRPS[userChoice-1],choicesRPS[opponentChoice-1]);
  
                //uses whoWins method to return 0: Tie, 1: User Wins, 2: Program wins , then updates count respectively
                switch(whoWins(userChoice, opponentChoice)){
                    case 0 -> {
                        System.out.println("We tied!");
                        ties ++;
                    }
                    case 1 -> {
                        System.out.println("You won!");
                        userWins++;
                    }
                    case 2 -> {
                        System.out.println("You lost.");
                        computerWins++;
                    }
                }
            }

            System.out.printf("You won %d time(s), I won %d time(s), we tied %d time(s)\n",userWins,computerWins,ties);

            //Prompts users to input a string yes/no to run method again.
            playAgain = getYesNoFromUser(sc, "Play again?");
            if (playAgain) playGame();
            else System.out.println("Thanks for playing!");

        }else{
            System.out.println("The inputed rounds is out of bounds.");
            // playAgain = getYesNoFromUser(sc, "Try again?");
            // if (playAgain) playGame();
            // else System.out.println("Bye!");
        }
        sc.close();
    }

    /**
     * whoWins is a helper method to compare 1:Rock 2:Paper 3:Scissors, returning an integer to represent the winning Status
     * @param userChoice
     * @param opponentChoice
     * @return 
     * 0 : userChoice and opponentChoice are tied, 
     * 1 : userChoice > opponentChoice, 
     * 2 : opponentChoice> userChoice
     */
    public static int whoWins(int userChoice,int opponentChoice){
        int result = -1;

        //Tie scenario
        if (userChoice == opponentChoice){
            return 0;

        }else{
            //User chose rock
            if (userChoice == 1){
                if (opponentChoice == 2){
                    return 2;
                }
                else if (opponentChoice == 3){
                    return 1;
                }
            }
            //User chose paper
            if (userChoice == 2){
                if (opponentChoice == 1){
                    return 1;
                }
                else if (opponentChoice == 3){
                    return 2;
                }
            }
            //User chose scissors
            if (userChoice == 3){
                if (opponentChoice == 1){
                    return 2;
                }
                else if (opponentChoice == 2){
                    return 1;
                }
            }
        }
        return result;
    }


    /**
     * Helper method to get an int from prompt
     * @param sc
     * @param prompt
     * @return
     */

    public static int getIntFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
 
    
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);
        return value;
    }

        /**
     * Helper method to get an int (1-3) for RPS from prompt
     * @param sc
     * @param prompt
     * @return
     */

    public static int getIntRPSFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value<1||value>3){
                    throw new NumberFormatException();
                }
                break;
    
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);
        return value;
    }

    /**
     * Helper method to return a boolean based on line input yes/no;
     * @param sc
     * @param prompt 
     * @return
     */
    public static boolean getYesNoFromUser(Scanner sc,String prompt){
        boolean foundResult = false;
        while(!foundResult){
            System.out.printf("%s (Yes/No): ",prompt);   
            String sread = sc.nextLine();
            if(sread.equalsIgnoreCase("yes")) return true;
            if(sread.equalsIgnoreCase("no")) return false;
            System.out.println("Invalid Choice.");
        }
        return false;
    }
}
