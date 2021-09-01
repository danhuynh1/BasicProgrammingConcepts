import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //Initializing Variables and getting user input
        float currentBalance = getFloatFromUser(sc,"How much do you want to invest?");
        int yearsCount = getIntFromUser(sc, "How many years are investing?");
        float interestRate = getFloatFromUser(sc, "What is the annual interest rate % growth?");
        float difference;

        int periodCode;
        do {
            System.out.printf("Please Enter Compound Period (1)Quarterly (2)Monthly (3)Daily: ");
            try {
                periodCode = Integer.parseInt(sc.nextLine());
                if (periodCode<1 || periodCode > 3){
                    throw new NumberFormatException();
                }
                break;
    
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);

        System.out.println("Calculating");
        for (int i=1; i< yearsCount+1;i++){
            float newBalance = getNewBalance(currentBalance, interestRate,periodCode);
            difference = newBalance - currentBalance;
            System.out.printf("Year %d\n",i);
            System.out.printf("Began with $%.2f\nEarned $%.2f\nEnded with $%.2f\n\n",currentBalance,difference,newBalance);
            currentBalance = newBalance;
        }
        sc.close();
    }
    /**
     * Helper method to calculate new balance given an interest rate and compound period 
     * @param currentBalance
     * @param interestRate
     * @param periodCode
     * @return currentBalance
     */

    public static float getNewBalance(float currentBalance, float interestRate,int periodCode){
        int period = 0;

        //Get Compound period 
        switch(periodCode){
            case 1 -> period = 4;
            case 2 -> period = 12;
            case 3 -> period = 365;
        }

        for (int i =0 ; i <period; i++){
        currentBalance = currentBalance * (1+((interestRate/period)/100));
        }
        return currentBalance;
    }
/**
 * Helper Method to get proper positive Float from scanner 
 * @param sc
 * @param prompt
 * @return
 */

public static float getFloatFromUser(Scanner sc, String prompt){
    float value;
    do {
        System.out.printf("%s: ",prompt);
        try {
            value = Float.parseFloat(sc.nextLine());
            if (value<0){
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
* Helper Method to get proper positive int from scanner 
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
            if (value<0){
                throw new NumberFormatException();
            }
            break;

        } catch(NumberFormatException ex) {
            System.out.println("Please input a correct value.");
        }
    }while(true);
    return value;
}
}
