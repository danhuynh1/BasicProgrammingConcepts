import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {

    static String[] choicesRPS = {"Rock","Paper","Scissors"};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean playAgain; 
        int rounds;
        do{
            rounds = getIntFromUser(sc, "How many rounds would you like to play?");
            playGame(rounds,sc);
            playAgain = getYesNoFromUser(sc, "Play again?");
            if (playAgain==false) System.out.println("\nThanks for playing.\n");
        }while(playAgain == true);
        sc.close();

    }
    /**
     * Method to initiate a RPS game for rounds loop, and displays a results count 
     * @param rounds; int(1-10) indicating how many games of RPS are to be played
     * @param sc; scanner input to read user input (userChoice)
     *  
     **/
    public static void playGame(int rounds, Scanner sc){
        //initializing variables 
        int userWins =0 ,computerWins = 0, ties = 0;
        int userChoice,opponentChoice;
        Random opponent = new Random();    
        for (int i = 0 ; i<rounds;i++){
            System.out.println("\n\t\tRound " + (i+1)+"\n");

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
    }

    /**
     * Helper method to compare 1:Rock 2:Paper 3: Scissors, returning an integer to repesent the winning Status
     * @param userChoice
     * @param opponentChoice
     * @return 
     * 0 : userChoice == opponentChoice 
     * 1 : userChoice > opponentChoice 
     * 2 : opponentChoice> userChoice
     */

    public static int whoWins(int userChoice,int opponentChoice){
        int result;
        //Tie scenario
        if (userChoice == opponentChoice) return 0;
        else{
            //Win scenario
            if (((userChoice == 1) && (opponentChoice == 3))||((userChoice == 2) && (opponentChoice == 1))||((userChoice == 3) && (opponentChoice == 2))) return 1;
            //Lose scenario
            else result = 2;
        }
        return result;
    }

    /**
     * Helper method to get an int from prompt
     * @param sc
     * @param prompt
     * @return value
     */

    public static int getIntFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value<1||value>10){
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
     * Helper method to get an int (1-3) for RPS from prompt
     * @param sc
     * @param prompt
     * @return value
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
     * @return boolean result
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
